package dev.fpt.web_app.application.service;

import dev.fpt.web_app.application.dto.request.*;
import dev.fpt.web_app.application.dto.response.GetTaskResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    Page<GetTaskResponse> searchTask(GetTaskRequest request, Pageable pageable);
    GetTaskResponse updateTaskStatus(UpdateTaskStatusRequest request);
    GetTaskResponse assignIssue(AssignTaskRequest request);
}
