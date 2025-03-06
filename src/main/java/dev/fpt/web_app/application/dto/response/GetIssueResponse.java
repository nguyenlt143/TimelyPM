package dev.fpt.web_app.application.dto.response;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class GetIssueResponse {
    private Long id;
    private String summary;
    private String description;
    private String projectName;
    private String assignedToName;
    private String reportedByName;
    private String severity;
    private String labels;
    private Timestamp createdAt;
    private Timestamp startDate;
    private Timestamp dueDate;
    private Boolean isActive;
    private Timestamp deactivatedAt;
    private String priorityName;
}
