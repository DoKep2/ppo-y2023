package ru.quipy.aggregates

import ru.quipy.core.annotations.AggregateType
import ru.quipy.domain.Aggregate
import ru.quipy.domain.AggregateState
import java.util.*

@AggregateType(aggregateEventsTableName = "project-aggregate")
class ProjectAggregate : Aggregate


data class ProjectAggregateState(
    val projectId: UUID
) : AggregateState<UUID, ProjectAggregate> {
    override fun getId(): UUID = projectId
}