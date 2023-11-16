package ru.quipy.aggregates

import ru.quipy.api.*
import ru.quipy.core.annotations.StateTransitionFunc
import ru.quipy.domain.AggregateState
import java.util.*

// Service's business logic
class AccountAggregateState : AggregateState<UUID, AccountManagementAggregate> {
    private lateinit var accountId: UUID
    private lateinit var userId: UUID
    private var balance: Int = 0
    private var isClosed: Boolean = false

    var createdAt: Long = System.currentTimeMillis()
    var updatedAt: Long = System.currentTimeMillis()

//    var tasks = mutableMapOf<UUID, TaskEntity>()
//    var projectTags = mutableMapOf<UUID, TagEntity>()

    override fun getId() = accountId

    // State transition functions which is represented by the class member function
    @StateTransitionFunc
    fun accountCreatedApply(event: AccountCreatedEvent) {
        userId = event.userId
        accountId = event.accountId
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun accountUpdatedApply(event: AccountUpdatedEvent) {
//        projectTags[event.tagId] = TagEntity(event.tagId, event.tagName)
        balance += event.delta
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun accountClosedApply(event: AccountClosedEvent) {
        isClosed = true
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun transferInitiatedApply(event: TransferInitiatedEvent) {

        updatedAt = createdAt
    }
}

data class TaskEntity(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val tagsAssigned: MutableSet<UUID>
)

data class TagEntity(
    val id: UUID = UUID.randomUUID(),
    val name: String
)

/**
 * Demonstrates that the transition functions might be representer by "extension" functions, not only class members functions
 */
//@StateTransitionFunc
//fun AccountAggregateState.tagAssignedApply(event: TagAssignedToTaskEvent) {
//    tasks[event.taskId]?.tagsAssigned?.add(event.tagId)
//        ?: throw IllegalArgumentException("No such task: ${event.taskId}")
//    updatedAt = createdAt
//}
