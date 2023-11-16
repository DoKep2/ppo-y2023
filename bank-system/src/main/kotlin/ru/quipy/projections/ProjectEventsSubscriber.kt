package ru.quipy.projections

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.quipy.aggregates.AccountManagementAggregate
import ru.quipy.api.*
import ru.quipy.streams.AggregateSubscriptionsManager
import javax.annotation.PostConstruct

@Service
class ProjectEventsSubscriber {

    val logger: Logger = LoggerFactory.getLogger(ProjectEventsSubscriber::class.java)

    @Autowired
    lateinit var subscriptionsManager: AggregateSubscriptionsManager

    @PostConstruct
    fun init() {
        subscriptionsManager.createSubscriber(AccountManagementAggregate::class, "some-meaningful-name") { //fixme

            `when`(AccountCreatedEvent::class) { event ->
                logger.info("Account created")
            }

            `when`(AccountUpdatedEvent::class) { event ->
                logger.info("Account updated")
            }

            `when`(AccountClosedEvent::class) { event ->
                logger.info("Account closed") // fixme
            }

            `when`(TransferInitiatedEvent::class) { event ->
                logger.info("Transfer initated") // fixme
            }
        }
    }
}