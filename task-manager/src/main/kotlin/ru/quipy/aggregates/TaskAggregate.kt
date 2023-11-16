package ru.quipy.aggregates

import ru.quipy.core.annotations.AggregateType
import ru.quipy.domain.Aggregate
import ru.quipy.domain.AggregateState
import ru.quipy.domain.Event
import java.util.UUID

@AggregateType(aggregateEventsTableName = "task-aggregate")
class TaskAggregate : Aggregate


data class TaskAggregateState(
    val taskId: UUID,
) : AggregateState<UUID, TaskAggregate> {
    override fun getId(): UUID = taskId
}
