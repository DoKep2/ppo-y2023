package ru.quipy.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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
import java.util.*

@RestController
@RequestMapping("/accounts")
class ProjectController(
    val accountEsService: EventSourcingService<UUID, AccountManagementAggregate, AccountAggregateState>
) {

    @GetMapping("health")
    fun healthCheck() : String {
        return "Ok"
    }

    @PostMapping("")
    fun createProject(@RequestParam userId: String, @RequestParam accountId: String) : AccountCreatedEvent {
        return accountEsService.create { it.createAccount(UUID.fromString(userId), UUID.fromString(accountId))  }
    }

    @GetMapping("{id}")
    fun getAccount(@PathVariable id: UUID) : AccountAggregateState? {
        return accountEsService.getState(id)
    }

    @PostMapping("/close/{id}")
    fun closeAccount(@PathVariable id: UUID) : AccountClosedEvent {
        return accountEsService.update(id) {
            it.closeAccount(id)
        }
    }

    @PostMapping("{id}")
    fun changeBalance(@PathVariable id: UUID, @RequestParam delta: Int) : AccountUpdatedEvent {
        return accountEsService.update(id) {
            it.changeBalance(id, delta)
        }
    }

    @PostMapping("/transfer")
    fun initiateTransfer(@RequestParam accountFromId: UUID, @RequestParam accountToId: UUID, @RequestParam delta: Int) : AccountUpdatedEvent {
        accountEsService.update(accountFromId) {
            it.changeBalance(accountFromId, -delta)
        }
        return accountEsService.update(accountToId) {
            it.changeBalance(accountToId, delta)
        }
    }
}