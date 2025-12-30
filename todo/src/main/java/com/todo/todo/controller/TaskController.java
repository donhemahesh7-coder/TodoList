package com.todo.todo.controller;

import com.todo.todo.models.Task;
import com.todo.todo.services.TaskServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

    private final TaskServices taskServices;


    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @GetMapping("/tasks")
    public String getTask(Model model) {
        List<Task> tasks = taskServices.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/tasks/add")
    public String createTask(@RequestParam String title) {
        taskServices.createTask(title);
        return "redirect:/tasks";


    }
    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskServices.deleteTask(id);

        return "redirect:/tasks";
    }


    @GetMapping("/tasks/toggle/{id}")

    public String toggleTask(@PathVariable Long id) {
        taskServices.toggleTask(id);

        return "redirect:/tasks";
    }

}
