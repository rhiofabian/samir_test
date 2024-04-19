package com.samirtest.test.service;

import com.samirtest.test.entity.Task;
import com.samirtest.test.web.vm.TaskCreateRequest;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<Task> getAll();
    Task getById(UUID taskId);
    Task createTask(TaskCreateRequest request);
    Task completeTask(UUID taskId);
}
