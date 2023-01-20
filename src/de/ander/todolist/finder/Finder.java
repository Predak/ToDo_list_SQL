package de.ander.todolist.finder;

import java.util.ArrayList;

import de.ander.todolist.entity.Todo;

public interface Finder {
	public static boolean find(int id, ArrayList<Todo> list) {
		int j = 0;
		for(int i = 0; i < list.size(); i ++) {
			if(list.get(i).getId() == id) {
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
