package com.controller.YoucodeGotTalent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.config.YoucodeGotTalent.Config;
import com.methods.YoucodeGotTalent.Methods;
import com.models.YoucodeGotTalent.User;

public class UserController {
	Config config;
	
	public UserController() throws SQLException {
		
		config= new Config("jdbc:mysql://localhost/youcodegt","root","");
		
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
			System.out.println("your account is correctly registered your information is:\n Name : "+rs.getString("first_name")+
			"\n lastname : "+rs.getString("last_name")+"\n Email : "+rs.getString("email")+"\n Phone : "+rs.getString("phone")+
			 "\nId : "+rs.getLong("user_id")+" Note: register your id to participate");
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
		System.out.println("Enter your id : ");
		long id = inp.nextLong();
		
			String sql = "SELECT * FROM users WHERE user_id = ?";
			stmt = config.connect().prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			rs.next();
			user = new User(id, rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("phone"));
			inp.close();
			return user;
			}
	
			
			

	// update user by id 
	
	public void updateUser() throws SQLException {
		PreparedStatement stmt;
		ResultSet rs;
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter your id for the update : ");
		long id = inp.nextLong();
		
			String sql = "SELECT * FROM users WHERE user_id = ?";
			stmt = config.connect().prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			rs.next();
		System.out.println("hello : "+rs.getString("first_name")+
			"\n here is your information \n Lastname : "+rs.getString("last_name")+"\n Email : "+rs.getString("email")+"\n Phone : "+rs.getString("phone")+
			"\n if you need to change your information type 1");
			int choix = inp.nextInt();
					switch (choix) {
					case 1:
						System.out.println("Enter your firstname :");
						String first_name = inp.next();
						System.out.println(" Enter your lastname :");
						String last_name = inp.next();
						System.out.println(" Enter your email :");
						String email = inp.next();
						System.out.println("Enter your phone :");
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
						System.out.println("Error");
						break;
					}  inp.close();
				}
	
	}
	

