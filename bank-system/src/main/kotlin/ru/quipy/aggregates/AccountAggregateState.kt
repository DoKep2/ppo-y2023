package ru.quipy.aggregates

import ru.quipy.api.*
import ru.quipy.core.annotations.StateTransitionFunc
import ru.quipy.domain.AggregateState
import java.util.*

// Service's business logic
class AccountAggregateState : AggregateState<UUID, AccountManagementAggregate> {
    private lateinit var accountId: UUID
    private lateinit var userId: UUID
    var balance: Int = 0
    var isClosed: Boolean = false

    var createdAt: Long = System.currentTimeMillis()
    var updatedAt: Long = System.currentTimeMillis()

    override fun getId() = accountId

    // State transition functions which is represented by the class member function
    @StateTransitionFunc
    fun accountCreatedApply(event: AccountCreatedEvent) {
        userId = event.userId
        accountId = event.accountId
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun accountUpdatedApply(event: AccountUpdatedEvent) {
        balance += event.delta
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun accountClosedApply(event: AccountClosedEvent) {
        isClosed = true
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun transferInitiatedApply(event: TransferInitiatedEvent) {
        updatedAt = createdAt
    }
}
