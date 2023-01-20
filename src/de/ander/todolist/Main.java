package de.ander.todolist;

import java.util.ArrayList;
import java.util.Scanner;

import de.ander.todolist.entity.Todo;
import de.ander.todolist.mapper.TodoMapper;

public class Main {

	private static ArrayList<Todo> todos;

	private static final String CONTROLS = 
			"\n-----------------------------\n"
			+ "new: new Todo item\n"
			+ "view: view the Todo list\n"
			+ "check: check or uncheck a Todo\n"
			+ "delete: delete Todo item\n"
			+ "exit: exit program\n"
			+ "-----------------------------\n";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		
		while(!exit) {
			todos = new TodoMapper().find(); 
			System.out.println(CONTROLS);
			String input = sc.nextLine().toUpperCase();
			
			switch (input) {
				case "NEW":
					System.out.println("What would you like to add?");
					String description = sc.nextLine();
					Todo todo = new Todo(description);
					todos.add(todo);
					new TodoMapper().insert(todo); // send to DB
					break;
					
				case "VIEW":
					for(Todo t: todos) {
						System.out.println(t);
					}
					break;
				case "CHECK":
					for(Todo t: todos) {
						System.out.println(t);
					}
					System.out.println("Enter task ID to mark it as checked");
					int id = (Integer.parseInt(sc.nextLine()));
					new TodoMapper().update(id);
					break;
								
				case "DELETE":
					for(Todo t: todos) {
						System.out.println(t);
					}
					System.out.println("Enter task ID to delete");
					int id3 = (Integer.parseInt(sc.nextLine()));
				
					if (find(id3, todos)){
						todos.removeIf(t -> t.getId()==id3);
						new TodoMapper().delete(id3);
						System.out.println("---------------\n" + id3 + " removed\n"+ "---------------\n");
					} else{
						System.out.println("---------------\n" + "ID not found, returning to main menu\n" + "---------------\n");
						}
					break;
				
				case "EXIT":
					exit = true;
					break;
				default:
					break;
			}
		}
	}	
	public static boolean find(int id, ArrayList<Todo> list) {
		int j = 0;
		for(int i = 0; i < list.size(); i ++) {
			if(list.get(i).getId() == id) {
				System.out.println(list.get(i));
				j +=1;
			}
		} 
		if(j > 0) {
			return true;
		} else {
			return false;
		}
	}
}
