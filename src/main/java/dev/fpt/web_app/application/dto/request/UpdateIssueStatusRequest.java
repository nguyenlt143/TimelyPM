package dev.fpt.web_app.application.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateIssueStatusRequest {
    @NotNull(message = "issue ID can not be null")
    private Long issueId;
    @NotNull(message = "issue ID can not be null")
    private Integer statusId;
}
