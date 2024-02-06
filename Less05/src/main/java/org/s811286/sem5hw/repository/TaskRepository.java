package org.s811286.sem5hw.repository;

import org.s811286.sem5hw.model.Task;
import org.s811286.sem5hw.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);
}
