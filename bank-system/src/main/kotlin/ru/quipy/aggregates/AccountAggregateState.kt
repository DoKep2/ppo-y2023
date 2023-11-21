package ru.quipy.aggregates

import ru.quipy.api.*
import ru.quipy.core.annotations.StateTransitionFunc
import ru.quipy.domain.AggregateState
import ru.quipy.entity.AccountEntity
import ru.quipy.entity.UserEntity
import java.util.*

class AccountAggregateState : AggregateState<UUID, AccountManagementAggregate> {
    private lateinit var account: AccountEntity
    private lateinit var user: UserEntity

    var createdAt: Long = System.currentTimeMillis()
    var updatedAt: Long = System.currentTimeMillis()

    override fun getId() = account.accountId

    @StateTransitionFunc
    fun accountCreatedApply(event: AccountCreatedEvent) {
        this.account = AccountEntity(
            accountId = event.accountId,
            isClosed = false,
            balance = 0,
        )
        this.user = UserEntity(
            userId = event.userId
        )
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun accountUpdatedApply(event: AccountUpdatedEvent) {
        account.balance += event.delta
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun accountClosedApply(event: AccountClosedEvent) {
        account.isClosed = true
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun transferInitiatedApply(event: TransferInitiatedEvent) {
        updatedAt = createdAt
    }
}
