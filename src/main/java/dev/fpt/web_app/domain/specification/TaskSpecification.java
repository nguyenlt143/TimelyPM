package dev.fpt.web_app.domain.specification;

import dev.fpt.web_app.application.dto.request.GetTaskRequest;
import dev.fpt.web_app.domain.entity.Task;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;


import java.util.ArrayList;
import java.util.List;

public class TaskSpecification {
    public static Specification<Task> filterBy(GetTaskRequest request) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (request.getProjectId() != null) {
                predicates.add(cb.equal(root.get("project").get("id"), request.getProjectId()));
            }
            if (request.getStatusId() != null) {
                predicates.add(cb.equal(root.get("status").get("id"), request.getStatusId()));
            }
            if (request.getPriorityId() != null) {
                predicates.add(cb.equal(root.get("priority").get("id"), request.getPriorityId()));
            }
            if (request.getLabels() != null && !request.getLabels().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("labels")), "%" + request.getLabels().toLowerCase() + "%"));
            }
            if (request.getAssignedToId() != null) {
                predicates.add(cb.equal(root.get("assignedTo").get("id"), request.getAssignedToId()));
            }
            if (request.getSummary() != null && !request.getSummary().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("summary")), "%" + request.getSummary().toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
