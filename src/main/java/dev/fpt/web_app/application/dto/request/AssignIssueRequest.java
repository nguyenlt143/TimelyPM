package dev.fpt.web_app.application.dto.request;

import lombok.Data;

@Data
public class AssignIssueRequest {
    private Long issueId;
    private Long assignedToId; // New user ID to assign the issue to
}
