package ru.quipy.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.quipy.aggregates.AccountManagementAggregate
import ru.quipy.core.EventSourcingService
import ru.quipy.aggregates.AccountAggregateState
import ru.quipy.api.AccountClosedEvent
import ru.quipy.api.AccountCreatedEvent
import ru.quipy.api.AccountUpdatedEvent
import ru.quipy.commands.changeBalance
import ru.quipy.commands.closeAccount
import ru.quipy.commands.createAccount
import ru.quipy.dto.AccountCreationDto
import ru.quipy.dto.TransferDto
import java.util.*

@RestController
@RequestMapping("/accounts")
class Controller(
    val accountEsService: EventSourcingService<UUID, AccountManagementAggregate, AccountAggregateState>
) {

    @GetMapping("health")
    fun healthCheck() : String {
        return "Ok"
    }

    @PostMapping("")
    fun createAccount(@RequestBody request: AccountCreationDto) : AccountCreatedEvent {
        return accountEsService.create { it.createAccount(UUID.fromString(request.userId), UUID.fromString(request.accountId))  }
    }

    @GetMapping("{id}")
    fun getAccount(@PathVariable id: UUID) : AccountAggregateState? {
        return accountEsService.getState(id)
    }

    @PostMapping("/{id}/close")
    fun closeAccount(@PathVariable id: UUID) : AccountClosedEvent {
        return accountEsService.update(id) {
            it.closeAccount(id)
        }
    }

    @PostMapping("{id}")
        fun changeBalance(@PathVariable id: UUID, @RequestBody delta: Int) : AccountUpdatedEvent {
        return accountEsService.update(id) {
            it.changeBalance(id, delta)
        }
    }

    @PostMapping("/transfer")
    fun initiateTransfer(@RequestBody request: TransferDto) : AccountUpdatedEvent {
        accountEsService.update(request.accountFromId) {
            it.changeBalance(request.accountFromId, -request.delta)
        }
        return accountEsService.update(request.accountToId) {
            it.changeBalance(request.accountToId, request.delta)
        }
    }
}