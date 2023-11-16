package ru.quipy.events

import ru.quipy.aggregates.UserAggregate
import ru.quipy.core.annotations.DomainEvent
import ru.quipy.domain.Event
import java.util.UUID

private const val USER_REGISTERED_EVENT = "USER_REGISTERED_EVENT"
private const val USER_ADDED_TO_PROJECT_EVENT = "USER_ADDED_TO_PROJECT_EVENT"

@DomainEvent(name = USER_REGISTERED_EVENT)
class UserRegisteredEvent(
    val userId: UUID,
    val email: String,
    val login: String,
    val password: String,
    createdAt: Long = System.currentTimeMillis(),
) : Event<UserAggregate>(
    name = USER_REGISTERED_EVENT,
    createdAt = createdAt,
)

@DomainEvent(name = USER_ADDED_TO_PROJECT_EVENT)
class UserAddedToProjectEvent(
    val userId: UUID,
    val projectId: UUID,
    createdAt: Long = System.currentTimeMillis(),
) : Event<UserAggregate>(
    name = USER_ADDED_TO_PROJECT_EVENT,
    createdAt = createdAt,
)