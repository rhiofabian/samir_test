package com.samirtest.test.service.impl;

import com.samirtest.test.entity.Task;
import com.samirtest.test.repository.TaskRepository;
import com.samirtest.test.service.TaskService;
import com.samirtest.test.web.vm.TaskCreateRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.nonNull;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public List<Task> getAll() {
        List<Task> taskList = new ArrayList<>();
        taskRepository.findAll().forEach(taskList::add);
        return taskList;
    }

    @Override
    public Task getById(UUID taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        return task.orElse(null);
    }

    @Override
    public Task createTask(TaskCreateRequest request) {
        Task task = new Task();
        task.setTaskId(UUID.randomUUID());
        task.setTaskName(request.getTaskName());
        task.setTaskStatus(false);

        return taskRepository.save(task);
    }

    @Override
    public Task completeTask(UUID taskId) {
        Task existingTask = getById(taskId);
        if(nonNull(existingTask)) {
            existingTask.setTaskStatus(true);
            return taskRepository.save(existingTask);
        }
        return null;
    }
}
