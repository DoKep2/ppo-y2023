package ru.quipy.commands

import ru.quipy.aggregates.UserAggregateState
import ru.quipy.events.UserRegisteredEvent
import java.util.*


fun UserAggregateState.registerUser(
    userId: UUID,
    email: String,
    login: String,
    password: String,
): UserRegisteredEvent {
    return UserRegisteredEvent(
        userId = userId,
        email = email,
        login = login,
        password = password,
    )
}