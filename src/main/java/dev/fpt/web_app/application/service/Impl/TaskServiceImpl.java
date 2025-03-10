package dev.fpt.web_app.application.service.Impl;
import dev.fpt.web_app.application.dto.request.AssignTaskRequest;
import dev.fpt.web_app.application.dto.request.GetTaskRequest;
import dev.fpt.web_app.application.dto.request.UpdateTaskStatusRequest;
import dev.fpt.web_app.application.dto.response.GetIssueResponse;
import dev.fpt.web_app.application.dto.response.GetTaskResponse;
import dev.fpt.web_app.application.service.TaskService;
import dev.fpt.web_app.domain.entity.Issue;
import dev.fpt.web_app.domain.entity.Status;
import dev.fpt.web_app.domain.entity.Task;
import dev.fpt.web_app.domain.entity.User;
import dev.fpt.web_app.domain.repository.StatusRepository;
import dev.fpt.web_app.domain.repository.TaskRepository;
import dev.fpt.web_app.domain.repository.UserRepository;
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
    private final StatusRepository statusRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, StatusRepository statusRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Page<GetTaskResponse> searchTask(GetTaskRequest request, Pageable pageable) {
        Specification<Task> spec = TaskSpecification.filterBy(request);
        Page<Task> taskPage = taskRepository.findAll(spec, pageable);

        return taskPage.map(this::mapToResponse);
    }

    @Override
    public GetTaskResponse updateTaskStatus(UpdateTaskStatusRequest request) {
        Task task = taskRepository.findById(request.getTaskId())
                .orElseThrow(() -> new RuntimeException("Task not found with id " + request.getTaskId()));
        Status newStatus = statusRepository.findById(request.getStatusId())
                .orElseThrow(() -> new RuntimeException("Status not found with id " + request.getStatusId()));
        task.setStatus(newStatus);
        taskRepository.save(task);
        return modelMapper.map(task, GetTaskResponse.class);
    }

    @Override
    public GetTaskResponse assignIssue(AssignTaskRequest request) {
        Task task = taskRepository.findById(request.getTaskId())
                .orElseThrow(() -> new RuntimeException("Task not found with id " + request.getTaskId()));
        User newAssignee = userRepository.findById(request.getAssignedToId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + request.getAssignedToId()));
        task.setAssignedTo(newAssignee);
        taskRepository.save(task);
        return modelMapper.map(task, GetTaskResponse.class);
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
