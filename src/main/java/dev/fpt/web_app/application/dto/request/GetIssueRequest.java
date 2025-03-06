package dev.fpt.web_app.application.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GetIssueRequest {
    @NotNull(message = "Project Id can not be null")
    private Long projectId;
    // Additional filters:

    private Integer statusId;
    private String severity;
    private Long priorityId;
    private String labels;
    private Long assignedToId;
    private String summary;
}
