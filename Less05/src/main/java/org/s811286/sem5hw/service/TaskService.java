package org.s811286.sem5hw.service;

import lombok.AllArgsConstructor;
import org.s811286.sem5hw.model.Task;
import org.s811286.sem5hw.model.TaskStatus;
import org.s811286.sem5hw.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    /**
     * Получение всех задач.
     */
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    /**
     * Получение задачи по ID.
     */
    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    /**
     * Получение задач по статусу.
     */
    public List<Task> getTaskByStatus(TaskStatus status) {
        return repository.findByStatus(status);
    }

    /**
     * Создание задачи.
     */
    public Task createTask(Task task) {
        task.setDateCreation(LocalDateTime.now());
        task.setStatus(TaskStatus.NOT_STARTED);
        return repository.save(task);
    }

    /**
     * Обновление статуса задачи.
     * (null ->) NOT_STARTED -> IN_PROGRESS -> COMPLETED ->
     * --> -> -> NOT_STARTED
     */
    public Task updateTask(Long id, Task taskDetails) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setDescription(taskDetails.getDescription());
            task.setDateCreation(taskDetails.getDateCreation());

            TaskStatus ts = taskDetails.getStatus();
            if (ts.equals(null)) {
                ts = TaskStatus.NOT_STARTED;
            } else if (ts.equals(TaskStatus.NOT_STARTED)) {
                ts = TaskStatus.IN_PROGRESS;
            } else if (ts.equals(TaskStatus.IN_PROGRESS)) {
                ts = TaskStatus.COMPLETED;
            } else if (ts.equals(TaskStatus.COMPLETED)) {
                ts = TaskStatus.NOT_STARTED;
            }
            task.setStatus(ts);

            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    /**
     * Удаление задачи.
     */
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
