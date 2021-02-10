package com.controller.YoucodeGotTalent;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import com.config.YoucodeGotTalent.Config;

public class ParticipationController {
Config config;
	
	public ParticipationController() throws SQLException {
		
		config= new Config("jdbc:mysql://localhost/youcodegt","root","");
		
	}
	
	
	// add participation 
	public void addParticipation() throws SQLException {
		 Scanner inp = new Scanner(System.in);
		 System.out.println("Entre your id :");
		 String idStr = inp.nextLine();
		 long id = Long.parseLong(idStr);
		
		
		
		 System.out.println(" Write the category number you want to participate in :");
		 System.out.println("1-  Dancing ");
		 System.out.println("2-  Singing ");
		 System.out.println("3- Acting");
		 System.out.println("4- Comedy");
		 System.out.println("5- Mental arithmetic");
		 System.out.println("6- Rubik's cube");
		 String idCat = inp.nextLine();
		 Long id_category = Long.parseLong(idCat);	
		
		 System.out.println("Enter the description of your hobby : ");
		 String desc = inp.nextLine();
		
		 System.out.println("The start date  'example: (2020-12-23 10:40:01)'");
		 String startTimeSow = inp.nextLine();
		 Timestamp startTimestamp = Timestamp.valueOf(startTimeSow);
		 
		
		 System.out.println("The end date 'example: (2020-12-23 10:40:01)'");
		 String endTimeSow = inp.nextLine();
		 Timestamp endTimestamp = Timestamp.valueOf(endTimeSow);
		
		 System.out.println("Enter the path of your file :");
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
			inp.close();
			statement1.executeUpdate();
		 
		 System.out.println("your participation is registered :");
		
				
	}

}
