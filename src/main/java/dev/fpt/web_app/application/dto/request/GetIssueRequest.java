package dev.fpt.web_app.application.dto.request;

import lombok.Data;

@Data
public class GetIssueRequest {
    private Long projectId;
    // Additional filters:

    private Integer statusId;
    private String severity;
    private Long priorityId;
    private String labels;
    private Long assignedToId;
    private String summary;
}
