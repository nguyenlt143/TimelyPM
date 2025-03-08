package dev.fpt.web_app.application.service.Impl;
import dev.fpt.web_app.application.dto.request.GetTaskRequest;
import dev.fpt.web_app.application.dto.response.GetTaskResponse;
import dev.fpt.web_app.application.service.TaskService;
import dev.fpt.web_app.domain.entity.Task;
import dev.fpt.web_app.domain.repository.TaskRepository;
import dev.fpt.web_app.domain.specification.TaskSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<GetTaskResponse> searchTask(GetTaskRequest request, Pageable pageable) {
        Specification<Task> spec = TaskSpecification.filterBy(request);
        Page<Task> taskPage = taskRepository.findAll(spec, pageable);

        return taskPage.map(this::mapToResponse);
    }

    private GetTaskResponse mapToResponse(Task task) {
        GetTaskResponse response = modelMapper.map(task, GetTaskResponse.class);

        // Ánh xạ các thuộc tính đặc biệt (nếu có)
        if (task.getProject() != null) {
            response.setProjectName(task.getProject().getProjectName());
        }
        if (task.getAssignedTo() != null) {
            response.setAssignedToName(task.getAssignedTo().getUsername());
        }
        if (task.getReportedBy() != null) {
            response.setReportedByName(task.getReportedBy().getUsername());
        }
        if (task.getPriority() != null) {
            response.setPriorityName(task.getPriority().getPriorityName());
        }

        // Gán ID thủ công (để chắc chắn)
        response.setId(task.getId());

        return response;
    }
}
