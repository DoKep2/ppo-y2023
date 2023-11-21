package ru.quipy.commands

import ru.quipy.api.AccountClosedEvent
import ru.quipy.api.AccountCreatedEvent
import ru.quipy.api.AccountUpdatedEvent
import ru.quipy.api.TransferInitiatedEvent
import ru.quipy.aggregates.AccountAggregateState
import java.util.*

    fun AccountAggregateState.changeBalance(accountId: UUID, delta: Int): AccountUpdatedEvent {
    return AccountUpdatedEvent(
        accountId = accountId,
        delta = delta,
    )
}

fun AccountAggregateState.closeAccount(accountId: UUID): AccountClosedEvent {
    return AccountClosedEvent(
        accountId = accountId,
    )
}

fun AccountAggregateState.initiateTransfer(accountFromId: UUID, accountToId: UUID, delta: Int): TransferInitiatedEvent
{
    return TransferInitiatedEvent(
        accountFromId = accountFromId,
        accountToId = accountFromId,
        delta = delta,
    )
}

fun AccountAggregateState.createAccount(userId: UUID, accountId: UUID): AccountCreatedEvent {
    return AccountCreatedEvent(
        userId = userId,
        accountId = accountId
    )
}
