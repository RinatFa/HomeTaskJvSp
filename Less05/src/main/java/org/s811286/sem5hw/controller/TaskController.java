package org.s811286.sem5hw.controller;

import lombok.AllArgsConstructor;
import org.s811286.sem5hw.model.Task;
import org.s811286.sem5hw.model.TaskStatus;
import org.s811286.sem5hw.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    /**
     * Добавление задачи.
     * POST localhost:8080/tasks
     * {
     * "description": "1"
     * }
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    /**
     * Просмотр всех задач.
     * GET localhost:8080/tasks
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * Просмотр задачи по ID.
     * GET localhost:8080/tasks/1
     */
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id).orElse(null);
    }

    /**
     * Просмотр задач по статусу ("завершена", "в процессе", "не начата").
     * GET localhost:8080/tasks/status/NOT_STARTED
     * GET localhost:8080/tasks/status/IN_PROGRESS
     * GET localhost:8080/tasks/status/COMPLETED
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.getTaskByStatus(status);
    }

    /**
     * Обновление статуса задачи.
     * PUT localhost:8080/tasks/1
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        Task existTask = taskService.getTaskById(id).orElse(null);
        if (existTask != null) {
            return taskService.updateTask(id, existTask);
        } else {
            return null;
        }
    }

    /**
     * Удаление задачи.
     * DELETE localhost:8080/tasks/1
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
