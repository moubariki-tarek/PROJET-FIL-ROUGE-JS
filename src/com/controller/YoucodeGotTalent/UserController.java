package com.controller.YoucodeGotTalent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.config.YoucodeGotTalent.Config;
import com.methods.YoucodeGotTalent.Methods;
import com.models.YoucodeGotTalent.User;
import java.util.Random;

public class UserController {
	Config config;
	
	public UserController() throws SQLException {
		
		config= new Config("jdbc:mysql://localhost/youcodegt","root","");
		
	}
	
	public void display() throws SQLException {
		
		String query = "Select * from users";
		Statement statement = config.connect().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		while (resultSet.next()) {
			
			System.out.println(resultSet.getString("first_name"));
			
		}  
		
	}
	// Add user
	public void AddUser(String first_name,String last_name,String email,String phone) {
		PreparedStatement stmt;
		ResultSet rs;
		try {
			String sql = "INSERT INTO users (user_id, first_name, last_name,email,phone) VALUES(?,?,?,?,?)";
			Methods mt = new Methods();
			stmt = config.connect().prepareStatement(sql);
			Long id =mt.randomId();
//			System.out.println(id);
			stmt.setLong(1, id);
			stmt.setString(2, first_name);
			stmt.setString(3, last_name);
			stmt.setString(4, email);
			stmt.setString(5, phone);
			stmt.executeUpdate();
			
			sql = "SELECT * FROM users WHERE user_id = ?";
			stmt = config.connect().prepareStatement(sql);
			
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
			System.out.println("votre compte est bien enregistre votre information est :\nnom : "+rs.getString("first_name")+
			"\nprenom : "+rs.getString("last_name")+"\nemail : "+rs.getString("email")+"\nphone : "+rs.getString("phone")+
			 "\nId : "+rs.getLong("user_id")+" enregistre votre id pour participe");
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}finally {
			
			rs=null;
			stmt= null;
		}
		
		
	}
	// find user by id
	public User findUserById() throws SQLException {
		User user;
		PreparedStatement stmt;
		ResultSet rs;
		Scanner inp = new Scanner(System.in);
		System.out.println("entre votre id : ");
		long id = inp.nextLong();
		
			String sql = "SELECT * FROM users WHERE user_id = ?";
			stmt = config.connect().prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			rs.next();
			user = new User(id, rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("phone"));
			return user;
			}
	
	
			
			
			
			

	// update user by id 
	
	public void updateUser() throws SQLException {
		User user;
		PreparedStatement stmt;
		ResultSet rs;
		Scanner inp = new Scanner(System.in);
		System.out.println("entre votre id pour le mise a jour : ");
		long id = inp.nextLong();
		
			String sql = "SELECT * FROM users WHERE user_id = ?";
			stmt = config.connect().prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			rs.next();
		System.out.println("bonjour : "+rs.getString("first_name")+
			"\nvoici votre information \nprenom : "+rs.getString("last_name")+"\nemail : "+rs.getString("email")+"\nphone : "+rs.getString("phone")+
			"\nsi vous avez un besoin de modifier votre information tapez 1 ");
			int choix = inp.nextInt();
					switch (choix) {
					case 1:
						System.out.println("first name");
						String first_name = inp.next();
						System.out.println("last name");
						String last_name = inp.next();
						System.out.println("email");
						String email = inp.next();
						System.out.println("phone");
						String phone = inp.next();
						sql  = "UPDATE users SET first_name =?, last_name = ?,email = ?,phone = ? WHERE user_id = ?";
						stmt=config.connect().prepareStatement(sql);
						stmt.setString(1, first_name);
						stmt.setString(2, last_name);
						stmt.setString(3, email);
						stmt.setString(4, phone);
						stmt.setLong(5, id);
						stmt.executeUpdate();
						break;

					default:
						System.out.println("error");
						break;
					}  
				}
	
	}
	

