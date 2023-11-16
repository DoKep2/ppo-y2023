package ru.quipy.api

import ru.quipy.aggregates.AccountManagementAggregate
import ru.quipy.core.annotations.DomainEvent
import ru.quipy.domain.Event
import java.util.*

const val ACCOUNT_UPDATED_EVENT = "ACCOUNT_UPDATED_EVENT"
const val ACCOUNT_CLOSED_EVENT = "ACCOUNT_CLOSED_EVENT"
const val TRANSFER_INITIATED_EVENT = "TRANSFER_INITIATED_EVENT"
const val ACCOUNT_CREATED_EVENT = "ACCOUNT_CREATED_EVENT"

// API
@DomainEvent(name = ACCOUNT_CREATED_EVENT)
class AccountUpdatedEvent(
    val accountId: UUID,
    val delta: Int,
    createdAt: Long = System.currentTimeMillis(),
) : Event<AccountManagementAggregate>(
    name = ACCOUNT_UPDATED_EVENT,
    createdAt = createdAt,
)

@DomainEvent(name = ACCOUNT_CLOSED_EVENT)
class AccountClosedEvent(
    val accountId: UUID,
    createdAt: Long = System.currentTimeMillis(),
) : Event<AccountManagementAggregate>(
    name = ACCOUNT_CLOSED_EVENT,
    createdAt = createdAt,
)

@DomainEvent(name = TRANSFER_INITIATED_EVENT)
class TransferInitiatedEvent(
    val accountFromId: UUID,
    val accountToId: UUID,
    val delta: Int,
    createdAt: Long = System.currentTimeMillis(),
) : Event<AccountManagementAggregate>(
    name = TRANSFER_INITIATED_EVENT,
    createdAt = createdAt
)

@DomainEvent(name = ACCOUNT_CREATED_EVENT)
class AccountCreatedEvent(
    val userId: UUID,
    val accountId: UUID,
    createdAt: Long = System.currentTimeMillis(),
) : Event<AccountManagementAggregate>(
    name = ACCOUNT_CREATED_EVENT,
    createdAt = createdAt
)