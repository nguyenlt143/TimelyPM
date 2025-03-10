package dev.fpt.web_app.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AssignTaskRequest {
    @NotBlank(message = "Task Id can not be null")
    private Long taskId;
    @NotBlank(message = "assigned Id Id can not be null")
    private Long assignedToId;
}
