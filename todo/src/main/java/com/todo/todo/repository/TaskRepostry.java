package com.todo.todo.repository;

import com.todo.todo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepostry extends JpaRepository<Task,Long > {
}
