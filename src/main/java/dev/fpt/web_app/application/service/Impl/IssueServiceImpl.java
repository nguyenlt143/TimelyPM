package dev.fpt.web_app.application.service.Impl;

import dev.fpt.web_app.application.dto.request.GetIssueRequest;
import dev.fpt.web_app.application.dto.request.UpdateIssueStatusRequest;
import dev.fpt.web_app.application.dto.request.AssignIssueRequest;
import dev.fpt.web_app.application.dto.response.GetIssueResponse;
import dev.fpt.web_app.application.service.IssueService;
import dev.fpt.web_app.domain.entity.Issue;
import dev.fpt.web_app.domain.entity.Status;
import dev.fpt.web_app.domain.entity.User;
import dev.fpt.web_app.domain.repository.IssueRepository;
import dev.fpt.web_app.domain.repository.StatusRepository;
import dev.fpt.web_app.domain.repository.UserRepository;
import jakarta.persistence.criteria.Predicate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final StatusRepository statusRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public IssueServiceImpl(IssueRepository issueRepository,
                            StatusRepository statusRepository,
                            UserRepository userRepository,
                            ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<GetIssueResponse> getIssues(GetIssueRequest request, Pageable pageable) {
        Specification<Issue> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (request.getProjectId() != null) {
                predicates.add(cb.equal(root.get("project").get("id"), request.getProjectId()));
            }
            if (request.getStatusId() != null) {
                predicates.add(cb.equal(root.get("status").get("id"), request.getStatusId()));
            }
            if (request.getSeverity() != null) {
                predicates.add(cb.equal(root.get("severity"), request.getSeverity()));
            }
            if (request.getPriorityId() != null) {
                predicates.add(cb.equal(root.get("priority").get("id"), request.getPriorityId()));
            }
            if (request.getLabels() != null) {
                predicates.add(cb.like(cb.lower(root.get("labels")), "%" + request.getLabels().toLowerCase() + "%"));
            }
            if (request.getAssignedToId() != null) {
                predicates.add(cb.equal(root.get("assignedTo").get("id"), request.getAssignedToId()));
            }
            if (request.getSummary() != null) {
                predicates.add(cb.like(cb.lower(root.get("summary")), "%" + request.getSummary().toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };

        Page<Issue> issues = issueRepository.findAll(spec, pageable);
        return issues.map(issue -> {
            GetIssueResponse response = modelMapper.map(issue, GetIssueResponse.class);
            if (issue.getProject() != null) {
                response.setProjectName(issue.getProject().getProjectName());
            }
            if (issue.getAssignedTo() != null) {
                response.setAssignedToName(issue.getAssignedTo().getUserName());
            }
            if (issue.getReportedBy() != null) {
                response.setReportedByName(issue.getReportedBy().getUserName());
            }
            if (issue.getPriority() != null) {
                response.setPriorityName(issue.getPriority().getPriorityName());
            }
            response.setId(issue.getId());
            return response;
        });
    }

    @Override
    public GetIssueResponse getIssueById(Long id) {
        Issue issue = issueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Issue not found with id " + id));
        GetIssueResponse response = modelMapper.map(issue, GetIssueResponse.class);
        response.setProjectName(issue.getProject().getProjectName());
        response.setAssignedToName(issue.getAssignedTo().getUserName());
        response.setReportedByName(issue.getReportedBy().getUserName());
        response.setPriorityName(issue.getPriority().getPriorityName());
        response.setId(issue.getId());
        return response;
    }

    @Override
    public GetIssueResponse updateIssueStatus(UpdateIssueStatusRequest request) {
        Issue issue = issueRepository.findById(request.getIssueId())
                .orElseThrow(() -> new RuntimeException("Issue not found with id " + request.getIssueId()));
        Status newStatus = statusRepository.findById(request.getStatusId())
                .orElseThrow(() -> new RuntimeException("Status not found with id " + request.getStatusId()));
        issue.setStatus(newStatus);
        issueRepository.save(issue);
        return modelMapper.map(issue, GetIssueResponse.class);
    }

    @Override
    public GetIssueResponse assignIssue(AssignIssueRequest request) {
        Issue issue = issueRepository.findById(request.getIssueId())
                .orElseThrow(() -> new RuntimeException("Issue not found with id " + request.getIssueId()));
        User newAssignee = userRepository.findById(request.getAssignedToId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + request.getAssignedToId()));
        issue.setAssignedTo(newAssignee);
        issueRepository.save(issue);
        return modelMapper.map(issue, GetIssueResponse.class);
    }
}
