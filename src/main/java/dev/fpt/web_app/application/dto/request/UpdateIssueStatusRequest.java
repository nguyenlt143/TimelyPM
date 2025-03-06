package dev.fpt.web_app.application.dto.request;

import lombok.Data;

@Data
public class UpdateIssueStatusRequest {
    private Long issueId;
    private Integer statusId;
}
