package com.controller.YoucodeGotTalent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;

import com.config.YoucodeGotTalent.Config;

public class ParticipationController {
Config config;
	
	public ParticipationController() throws SQLException {
		
		config= new Config("jdbc:mysql://localhost/youcodegt","root","");
		
	}
	
	public void display() throws SQLException {
		
		String query = "Select * from participation";
		Statement statement = config.connect().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		while (resultSet.next()) {
			
			System.out.println(resultSet.getString("name"));
			
		}  
		
	}
	
	// add participation 
	public void addParticipation() throws SQLException {
		 Scanner inp = new Scanner(System.in);
		 System.out.println("Enter votre id:");
		 String idStr = inp.nextLine();
		 long id = Long.parseLong(idStr);
		
		
		
		 System.out.println("ecrire le numero de categorie que vous voulez participer:");
		 System.out.println("1- La dance");
		 System.out.println("2- En chantant");
		 System.out.println("3- La scène");
		 System.out.println("4- La Comédie");
		 System.out.println("5- Calcul mental");
		 System.out.println("6- Le cube de Rubik");
		 String idCat = inp.nextLine();
		 Long id_category = Long.parseLong(idCat);	
		
		 System.out.println("Entrez la description de votre loisire : ");
		 String desc = inp.nextLine();
		
		 System.out.println("entre la date de debut exemple :(2020-12-23 10:40:01)");
		 String startTimeSow = inp.nextLine();
		 Timestamp startTimestamp = Timestamp.valueOf(startTimeSow);
		 
		
		 System.out.println("entre la date de debut exemple :(2020-12-23 10:20:01)");
		 String endTimeSow = inp.nextLine();
		 Timestamp endTimestamp = Timestamp.valueOf(endTimeSow);
		
		 System.out.println("Entrez le chemin de votre fichier :");
		 String file = inp.nextLine();
		
		 boolean is_accepted = false;
		
		 String sql = "INSERT into participation (user_id ,id_catagory, description, show_start_time, show_start_end,attahed_file,is_accepted) values(?,?,?,?,?,?,?)";
		 PreparedStatement statement1 = config.connect().prepareStatement(sql);
			statement1.setLong(1, id);
			statement1.setLong(2, id_category);
			statement1.setString(3, desc);
			statement1.setTimestamp(4, startTimestamp);
			statement1.setTimestamp(5, endTimestamp );
			statement1.setString(6, file);
			statement1.setBoolean(7, is_accepted );
			
			statement1.executeUpdate();
		 
		 System.out.println("votre partcipation est bien enregistre");
		
				
	}

}
