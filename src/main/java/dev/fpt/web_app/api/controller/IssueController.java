package dev.fpt.web_app.api.controller;

import dev.fpt.web_app.application.dto.request.AssignIssueRequest;
import dev.fpt.web_app.application.dto.request.GetIssueRequest;
import dev.fpt.web_app.application.dto.request.UpdateIssueStatusRequest;
import dev.fpt.web_app.application.dto.response.GetIssueResponse;
import dev.fpt.web_app.application.service.IssueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/issues")
public class IssueController {

    private final IssueService issueService;

    @Autowired
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping("/search")
    public Page<GetIssueResponse> getIssues(@Valid  @RequestBody GetIssueRequest request, Pageable pageable) {
        return issueService.getIssues(request, pageable);
    }

    @GetMapping("/{id}")
    public GetIssueResponse getIssueById(@PathVariable Long id) {
        return issueService.getIssueById(id);
    }

    @PutMapping("/update-status")
    public GetIssueResponse updateIssueStatus(@Valid @RequestBody UpdateIssueStatusRequest request) {
        return issueService.updateIssueStatus(request);
    }

    @PutMapping("/assign")
    public GetIssueResponse assignIssue(@RequestBody AssignIssueRequest request) {
        return issueService.assignIssue(request);
    }
}
