package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Task;
import com.example.demo.entities.TodoList;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.TodoListRepository;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoListRepository todoListRepository;
    
    @Autowired
    private TaskRepository taskRepository;

    // Show all todo lists
    @GetMapping
    public String listTodoLists(Model model) {
        model.addAttribute("todoLists", todoListRepository.findAll());
        model.addAttribute("newTodoList", new TodoList());
        return "todo-lists";
    }

    // Create new todo list
    @PostMapping
    public String createTodoList(@ModelAttribute TodoList todoList) {
        todoListRepository.save(todoList);
        return "redirect:/todos";
    }

    // Show tasks in a todo list
    @GetMapping("/{listId}")
    public String viewTodoList(@PathVariable Long listId, Model model) {
        TodoList todoList = todoListRepository.findById(listId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid list id"));
        
        model.addAttribute("todoList", todoList);
        model.addAttribute("newTask", new Task());
        return "tasks";
    }

    // Add task to a todo list
    @PostMapping("/{listId}/tasks")
    public String addTask(@PathVariable Long listId, @ModelAttribute Task task) {
        TodoList todoList = todoListRepository.findById(listId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid list id"));
        
        task.setTodoList(todoList);
        taskRepository.save(task);
        return "redirect:/todos/" + listId;
    }

    // Toggle task completion status
    @PostMapping("/{listId}/tasks/{taskId}/toggle")
    public String toggleTask(@PathVariable Long listId, @PathVariable Long taskId) {
    	//get user
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid task id"));
        //set the completed or not
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
        return "redirect:/todos/" + listId;
    }

    // Delete a task
    @PostMapping("/{listId}/tasks/{taskId}/delete")
    public String deleteTask(@PathVariable Long listId, @PathVariable Long taskId) {
        taskRepository.deleteById(taskId);
        return "redirect:/todos/" + listId;
    }

    // Delete a todo list
    @PostMapping("/{listId}/delete")
    public String deleteTodoList(@PathVariable Long listId) {
        todoListRepository.deleteById(listId);
        return "redirect:/todos";
    }
}