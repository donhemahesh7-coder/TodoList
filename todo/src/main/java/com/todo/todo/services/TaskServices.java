package com.todo.todo.services;


import com.todo.todo.models.Task;
import com.todo.todo.repository.TaskRepostry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {

    private  final TaskRepostry taskRepostry;

    public TaskServices(TaskRepostry taskRepostry) {
        this.taskRepostry = taskRepostry;
    }

    public List<Task> getAllTasks() {
        return taskRepostry.findAll();
    }

    public void createTask(String title) {
        Task task= new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepostry.save(task);


    }

    public void deleteTask(Long id) {
         taskRepostry.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task= taskRepostry.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid task id"));
                task.setCompleted(!task.isCompleted());
                taskRepostry.save(task);
    }
}
