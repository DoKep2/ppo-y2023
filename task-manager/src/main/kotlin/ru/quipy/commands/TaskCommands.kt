package ru.quipy.commands

import ru.quipy.aggregates.TaskAggregate
import ru.quipy.aggregates.TaskAggregateState
import ru.quipy.events.TaskCreatedEvent
import ru.quipy.events.TaskModifiedEvent
import ru.quipy.events.TaskRemovedEvent
import java.util.*


fun TaskAggregateState.createTask(
    taskId: UUID,
    taskName: String,
    taskDescription: String,
    projectId: UUID,
    assigneeId: UUID?,
    statusId: UUID?,
): TaskCreatedEvent {
    return TaskCreatedEvent(
        taskId = taskId,
        taskName = taskName,
        taskDescription = taskDescription,
        projectId = projectId,
        assigneeId = assigneeId,
        statusId = statusId,
    )
}

fun TaskAggregateState.modifyTask(
    taskId: UUID,
    taskName: String,
    assigneeId: UUID?,
    statusId: UUID?,
): TaskModifiedEvent {
    return TaskModifiedEvent(
        taskId = taskId,
        taskName = taskName,
        assigneeId = assigneeId,
        statusId = statusId,
    )
}

fun TaskAggregate.removeTask(
    taskId: UUID,
): TaskRemovedEvent {
    return TaskRemovedEvent(
        taskId = taskId,
    )
}