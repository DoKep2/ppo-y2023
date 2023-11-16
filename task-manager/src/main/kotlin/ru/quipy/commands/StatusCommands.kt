package ru.quipy.commands

import ru.quipy.aggregates.StatusAggregateState
import ru.quipy.events.StatusCreatedEvent
import ru.quipy.events.StatusRemovedEvent
import java.util.UUID


fun StatusAggregateState.createStatus(
    statusId: UUID,
    statusName: String,
    projectId: UUID,
): StatusCreatedEvent {
    return StatusCreatedEvent(
        statusId = statusId,
        statusName = statusName,
        projectId = projectId,
    )
}

fun StatusAggregateState.removeStatus(
    statusId: UUID,
    projectId: UUID,
): StatusRemovedEvent {
    return StatusRemovedEvent(
        statusId = statusId,
        projectId = projectId,
    )
}