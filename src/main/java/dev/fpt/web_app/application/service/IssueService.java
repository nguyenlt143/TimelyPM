package dev.fpt.web_app.application.service;


import dev.fpt.web_app.application.dto.request.AssignIssueRequest;
import dev.fpt.web_app.application.dto.request.GetIssueRequest;
import dev.fpt.web_app.application.dto.request.UpdateIssueStatusRequest;
import dev.fpt.web_app.application.dto.response.GetIssueResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {
    Page<GetIssueResponse> getIssues(GetIssueRequest request, Pageable pageable);

    GetIssueResponse getIssueById(Long id);

    GetIssueResponse updateIssueStatus(UpdateIssueStatusRequest request);

    GetIssueResponse assignIssue(AssignIssueRequest request);
}
