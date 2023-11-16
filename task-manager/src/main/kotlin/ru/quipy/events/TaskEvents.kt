package ru.quipy.events

import ru.quipy.aggregates.TaskAggregate
import ru.quipy.core.annotations.DomainEvent
import ru.quipy.domain.Event
import java.util.*

private const val TASK_CREATED_EVENT = "TASK_CREATED_EVENT"
private const val TASK_MODIFIED_EVENT = "TASK_MODIFIED_EVENT"
private const val TASK_REMOVED_EVENT = "TASK_REMOVED_EVENT"

@DomainEvent(name = TASK_CREATED_EVENT)
class TaskCreatedEvent(
    val taskId: UUID,
    val taskName: String,
    val taskDescription: String,
    val projectId: UUID,
    val assigneeId: UUID?,
    val statusId: UUID?,
    createdAt: Long = System.currentTimeMillis(),
) : Event<TaskAggregate>(
    name = TASK_CREATED_EVENT,
    createdAt = createdAt,
)

@DomainEvent(name = TASK_MODIFIED_EVENT)
class TaskModifiedEvent(
    val taskId: UUID,
    val taskName: String,
    val assigneeId: UUID?,
    val statusId: UUID?,
    createdAt: Long = System.currentTimeMillis(),
) : Event<TaskAggregate>(
    name = TASK_MODIFIED_EVENT,
    createdAt = createdAt,
)

@DomainEvent(name = TASK_REMOVED_EVENT)
class TaskRemovedEvent(
    val taskId: UUID,
    createdAt: Long = System.currentTimeMillis(),
) : Event<TaskAggregate>(
    name = TASK_REMOVED_EVENT,
    createdAt = createdAt,
)