package ru.quipy.aggregates

import ru.quipy.core.annotations.AggregateType
import ru.quipy.domain.Aggregate
import ru.quipy.domain.AggregateState
import java.util.*

@AggregateType(aggregateEventsTableName = "user-aggregate")
class UserAggregate : Aggregate


data class UserAggregateState(
    val userId: UUID,
) : AggregateState<UUID, UserAggregate> {
    override fun getId(): UUID = userId
}
