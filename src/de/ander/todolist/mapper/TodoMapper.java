package de.ander.todolist.mapper;

import java.sql.*;
import java.util.ArrayList;

import de.ander.todolist.entity.Todo;
import de.ander.todolist.DBManager;

public class TodoMapper {
	
	private final String TABLE = "Todos";
	
	public ArrayList<Todo> find () {
		String sql = "SELECT * FROM " + TABLE;
		
		ArrayList<Todo> todos = new ArrayList<>();
		
		try {
			Connection con = DBManager.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql); 
			
			while(rs.next()) { 
				Todo todo = new Todo();
				todo.setId(rs.getInt("id"));
				todo.setDescription(rs.getString("description"));
				todo.setChecked(rs.getBoolean("checked"));
				todo.setCreated(rs.getTimestamp("created").toLocalDateTime());
				
				todos.add(todo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return todos;
	}
	
	public void insert(Todo todo) {
		String sql = "INSERT INTO " + TABLE + "(description) VALUES ('" + todo.getDescription() + "')";
		
		try {
			Connection con = DBManager.getConnection();
			Statement stmt = con.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(int id) {
		String query = "SELECT * FROM " + TABLE + " WHERE id = " + id;
		String sql = "UPDATE " + TABLE + " SET checked = ? WHERE id = ? ";
		
		try {
			Connection con = DBManager.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			PreparedStatement pstmt = con.prepareStatement(sql);
			if(rs.next()) {
				if(rs.getBoolean("checked")) {
					pstmt.setBoolean(1, false);
				} else {
					pstmt.setBoolean(1, true);
				}
			}
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM " + TABLE + " WHERE id = " + id;
		
		try {
			Connection con = DBManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
