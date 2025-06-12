package com.example.demo.todoList.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class TodoList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Task> taskList= new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "user_idn")
	private Users users;
	

	public TodoList() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}    	 // After done this i got the result
//	 List<TodoList> l = users.getTodoList();
//	 TodoList t = l.get(0) ;
//	 for(TodoList todo : l) {
//		 if(todo.getId() == listId) {
//			 t = todo;
//			 l.remove(todo);
//			 break;
//		 }
//	 }
//	 users.setTodoList(l);
//	 
	 


	public List<Task> getTaskList() {
		return taskList;
	}


	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}


	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}


	@Override
	public String toString() {
		return "TodoList [id=" + id + ", name=" + name + ", users=" + users + "]";
	}

	
}
