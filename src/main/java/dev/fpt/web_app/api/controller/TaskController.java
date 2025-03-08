package dev.fpt.web_app.api.controller;


import dev.fpt.web_app.application.dto.request.GetTaskRequest;
import dev.fpt.web_app.application.dto.response.GetTaskResponse;
import dev.fpt.web_app.application.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/search")
    public Page<GetTaskResponse> searchTasks(
            @Valid
            @RequestBody GetTaskRequest request,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return taskService.searchTask(request, PageRequest.of(page, size));
    }
}
