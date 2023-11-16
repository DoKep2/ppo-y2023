package ru.quipy.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.quipy.aggregates.AccountManagementAggregate
import ru.quipy.core.EventSourcingService
import ru.quipy.aggregates.AccountAggregateState
import java.util.*

@RestController
@RequestMapping("/projects")
class ProjectController(
    val projectEsService: EventSourcingService<UUID, AccountManagementAggregate, AccountAggregateState>
) {

//    @PostMapping("/{projectTitle}")
//    fun createProject(@PathVariable projectTitle: String, @RequestParam creatorId: String) : ProjectCreatedEvent {
//        return projectEsService.create { it.create(UUID.randomUUID(), projectTitle, creatorId) }
//    }
//
//    @GetMapping("/{projectId}")
//    fun getAccount(@PathVariable projectId: UUID) : ProjectAggregateState? {
//        return projectEsService.getState(projectId)
//    }
//
//    @PostMapping("/{projectId}/tasks/{taskName}")
//    fun createTask(@PathVariable projectId: UUID, @PathVariable taskName: String) : TaskCreatedEvent {
//        return projectEsService.update(projectId) {
//            it.addTask(taskName)
//        }
//    }
}