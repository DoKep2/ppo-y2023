package ru.quipy.projections

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.quipy.aggregates.AccountManagementAggregate
import ru.quipy.api.*
import ru.quipy.streams.annotation.AggregateSubscriber
import ru.quipy.streams.annotation.SubscribeEvent

@Service
@AggregateSubscriber(
    aggregateClass = AccountManagementAggregate::class, subscriberName = "demo-subs-stream"
)
class AnnotationBasedProjectEventsSubscriber {

    val logger: Logger = LoggerFactory.getLogger(AnnotationBasedProjectEventsSubscriber::class.java)

    @SubscribeEvent
    fun accountCreatedSubscriber(event: AccountCreatedEvent) {
        logger.info("Account created")
    }

    @SubscribeEvent
    fun accountUpdatedSubscriber(event: AccountUpdatedEvent) {
        logger.info("Account updated")
    }

    @SubscribeEvent
    fun accountClosedSubscriber(event: AccountClosedEvent) {
        logger.info("Account closed")
    }

    @SubscribeEvent
    fun TransferInitiatedSubscriber(event: TransferInitiatedEvent) {
        logger.info("Transfer initiated")
    }
}