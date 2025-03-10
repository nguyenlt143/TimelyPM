package dev.fpt.web_app.application.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateTaskStatusRequest {
    @NotNull(message = "taskId ID can not be null")
    private Long taskId;
    @NotNull(message = "taskId ID can not be null")
    private Integer statusId;
}
