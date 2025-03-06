package dev.fpt.web_app.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AssignIssueRequest {
    @NotBlank(message = "Issue Id can not be null")
    private Long issueId;
    @NotBlank(message = "assigned Id Id can not be null")
    private Long assignedToId;
}
