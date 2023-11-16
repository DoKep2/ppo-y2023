package ru.quipy.aggregates

import ru.quipy.core.annotations.AggregateType
import ru.quipy.domain.Aggregate
import ru.quipy.domain.AggregateState
import java.util.UUID

@AggregateType(aggregateEventsTableName = "status-aggregate")
class StatusAggregate : Aggregate


data class StatusAggregateState(
    val statusId: UUID,
) : AggregateState<UUID, StatusAggregate> {
    override fun getId(): UUID = statusId
}