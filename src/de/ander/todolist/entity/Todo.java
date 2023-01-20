package de.ander.todolist.entity;

import java.time.LocalDateTime;

public class Todo {
	private int id;
	private String description;
	private boolean checked;
	private LocalDateTime created;
	
	public Todo() {
		
	}
	public Todo(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", checked=" + checked + ", created=" + created
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	
}
