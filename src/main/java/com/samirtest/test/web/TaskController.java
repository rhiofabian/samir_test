package com.samirtest.test.web;

import com.samirtest.test.entity.Task;
import com.samirtest.test.service.TaskService;
import com.samirtest.test.web.vm.TaskCreateRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    private List<Task> getAllTasks() {
        return taskService.getAll();
    }

    @PostMapping("/tasks")
    private Task createNewTask(@RequestBody TaskCreateRequest taskCreateRequest) {
        return taskService.createTask(taskCreateRequest);
    }

    @PutMapping("/tasks/completed/{id}")
    private Task completeTask(@PathVariable("id") UUID taskId) {
        return taskService.completeTask(taskId);
    }
}
