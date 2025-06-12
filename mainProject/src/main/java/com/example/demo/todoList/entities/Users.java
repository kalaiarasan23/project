package com.example.demo.todoList.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String userName;
	
	@OneToMany(mappedBy = "users", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<TodoList> todoList= new ArrayList<>();;

	public Users() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<TodoList> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<TodoList> todoList) {
		this.todoList = todoList;
	}
	
	   public void addTodoList(TodoList todoList) {
	        this.todoList.add(todoList);
	        todoList.setUsers(this);
	    }

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + "size "+todoList.size()+"]";
	}
	
}
