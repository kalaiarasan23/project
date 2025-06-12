package com.example.demo.todoList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.todoList.entities.Task;
import com.example.demo.todoList.entities.TodoList;
import com.example.demo.todoList.entities.Users;
import com.example.demo.todoList.repository.TaskRepository;
import com.example.demo.todoList.repository.ToDoRepository;
import com.example.demo.todoList.repository.UsersRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private ToDoRepository todoRepository;
    
    @Autowired
    private TaskRepository taskRepository;
    
    @Autowired
    private UsersRepository usersRepository;

    
    // Show all todo lists
    @GetMapping
    public String listTodoLists(Model model, HttpSession session) {
    	Users users = (Users)session.getAttribute("users");
    	if(users == null)
    		return "redirect:/login";
    	
    	TodoList todoList = new TodoList();
        users = usersRepository.findById(users.getId()).orElse(null);

        List<TodoList> userTodoLists = todoRepository.findByUsers(users); // correct!
        model.addAttribute("todoLists", userTodoLists);
    	
        model.addAttribute("newTodoList", todoList);
        
        return "todo";
    }

    // Create new todo list
    @PostMapping
    public String createTodoList(@ModelAttribute TodoList todoList,HttpSession session) {
    	Users users = (Users)session.getAttribute("users");
    	if(users == null)
    	{
    		return "redirect:/login";
    	}
    	 users = usersRepository.findById(users.getId())
    	            .orElseThrow(() -> new RuntimeException("User not found"));
    	todoList.setUsers(users);
    	todoRepository.save(todoList);
    	users.addTodoList(todoList); 
        return "redirect:/todos";
    }

 
    // Show tasks in a todo list
    @GetMapping("/{listId}")
    public String viewTodoList(@PathVariable Integer listId, Model model,HttpSession session) {
    	Users users = (Users)session.getAttribute("users");
    	if(users == null)
    	{
    		return "redirect:/login";
    	}
    	 users = usersRepository.findById(users.getId())
    	            .orElseThrow(() -> new RuntimeException("User not found"));
    	
    	
    	TodoList todoList = todoRepository.findById(listId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid list id"));
        
        model.addAttribute("todoList", todoList);
        model.addAttribute("newTask", new Task());
        return "tasks";
    }

    // Add task to a todo list
    @PostMapping("/{listId}/tasks")
    public String addTask(@PathVariable Integer listId, @ModelAttribute Task task,HttpSession session) {
        TodoList todoList = todoRepository.findById(listId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid list id"));
        
        task.setTodoList(todoList);
        taskRepository.save(task);
        return "redirect:/todos/" + listId;
    }

    // Toggle task completion status
    @PostMapping("/{listId}/tasks/{taskId}/toggle")
    public String toggleTask(@PathVariable Integer listId, @PathVariable Integer taskId) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid task id"));
        //set the completed or not
        task.setStatus(!task.isStatus());
        taskRepository.save(task);
        return "redirect:/todos/" + listId;
    }

    // Delete a task
    @PostMapping("/{listId}/tasks/{taskId}/delete")
    public String deleteTask(@PathVariable Integer listId, @PathVariable Integer taskId,HttpSession session) {
    	Users users = (Users)session.getAttribute("users");
    	if(users == null)
    	{
    		return "redirect:/login";
    	}
    	 
    	taskRepository.deleteById(taskId);
    	
        return "redirect:/todos/" + listId;
    }

    // Delete a todo list
    @PostMapping("/{listId}/delete")
    public String deleteTodoList(@PathVariable Integer listId,HttpSession session) {
    	Users users = (Users)session.getAttribute("users");
    	if(users == null)
    	{
    		return "redirect:/login";
    	}
    	 users = usersRepository.findById(users.getId())
    	            .orElseThrow(() -> new RuntimeException("User not found"));
    	 

        	todoRepository.deleteById(listId);
        	return "redirect:/todos";
    }
   
    // create newUser button 
    @GetMapping("/newUser")
    public String NewUser(Model model, HttpSession session) {
    	Users users = (Users)session.getAttribute("users");
    	if(users == null)
    	{
    		return "redirect:/login";
    	}
    	 users = usersRepository.findById(users.getId())
    	            .orElseThrow(() -> new RuntimeException("User not found"));
    	
    	model.addAttribute("newUser", new Users());
    	return "newUser";
    }
    
    // After Create the user from newUser.html page
    @PostMapping("/newUser")
    public String addUser(@ModelAttribute Users user,RedirectAttributes redirectAttributes,Model model) {
        if (usersRepository.findByUserName(user.getUserName()).isPresent()) {
            redirectAttributes.addFlashAttribute("error", "Username already exists!");
            return "redirect:/todos/newUser";
        }
    	usersRepository.save(user);
        redirectAttributes.addFlashAttribute("successMessage", "User created successfully!");
    	return "redirect:/todos";
    }
}