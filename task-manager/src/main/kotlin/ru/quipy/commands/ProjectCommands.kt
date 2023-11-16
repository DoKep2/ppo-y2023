package ru.quipy.commands

import ru.quipy.aggregates.ProjectAggregateState
import ru.quipy.events.ProjectCreatedEvent
import ru.quipy.events.UserAddedToProjectEvent
import java.util.UUID


fun ProjectAggregateState.createProject(
    projectId: UUID,
    ownerId: UUID,
    projectName: String,
): ProjectCreatedEvent {
    return ProjectCreatedEvent(
        projectId = projectId,
        ownerId = ownerId,
        projectName = projectName,
    )
}

fun ProjectAggregateState.addUserToProject(
    userId: UUID,
    projectId: UUID,
): UserAddedToProjectEvent {
    return UserAddedToProjectEvent(
        userId = userId,
        projectId = projectId,
    )
}