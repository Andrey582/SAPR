package stud.ganyushkin.sapr.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import stud.ganyushkin.sapr.model.CircuitComponent
import stud.ganyushkin.sapr.model.CircuitConnection
import stud.ganyushkin.sapr.service.CircuitWorkspaceService

@RestController
@RequestMapping("/api")
class CircuitController(
    private val workspaceService: CircuitWorkspaceService,
) {

    @PostMapping("/workspace/reset")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun resetWorkspace() {
        workspaceService.reset()
    }

    @PostMapping("/components")
    @ResponseStatus(HttpStatus.CREATED)
    fun createComponent(@RequestBody request: CreateCircuitComponentRequest): CircuitComponent =
        workspaceService.createComponent(request)

    @PostMapping("/connections")
    @ResponseStatus(HttpStatus.CREATED)
    fun createConnection(@RequestBody request: CreateCircuitConnectionRequest): CircuitConnection =
        workspaceService.createConnection(request)

    @GetMapping("/summary")
    fun getSummary(): CircuitSummaryResponse =
        workspaceService.getSummary()
}
