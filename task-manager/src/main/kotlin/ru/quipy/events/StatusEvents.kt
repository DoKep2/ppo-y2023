package ru.quipy.events

import ru.quipy.aggregates.StatusAggregate
import ru.quipy.core.annotations.DomainEvent
import ru.quipy.domain.Event
import java.util.UUID

private const val STATUS_CREATED_EVENT = "STATUS_CREATED_EVENT"
private const val STATUS_REMOVED_EVENT = "STATUS_REMOVED_EVENT"

@DomainEvent(name = STATUS_CREATED_EVENT)
class StatusCreatedEvent(
    val statusId: UUID,
    val statusName: String,
    val projectId: UUID,
    createdAt: Long = System.currentTimeMillis(),
) : Event<StatusAggregate>(
    name = STATUS_CREATED_EVENT,
    createdAt = createdAt,
)

@DomainEvent(name = STATUS_REMOVED_EVENT)
class StatusRemovedEvent(
    val statusId: UUID,
    val projectId: UUID,
    createdAt: Long = System.currentTimeMillis(),
) : Event<StatusAggregate>(
    name = STATUS_REMOVED_EVENT,
    createdAt = createdAt,
)