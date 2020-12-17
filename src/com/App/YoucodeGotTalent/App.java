package com.App.YoucodeGotTalent;
import java.sql.SQLException;
import java.util.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.controller.YoucodeGotTalent.AdminController;
import com.controller.YoucodeGotTalent.ParticipationController;
import com.controller.YoucodeGotTalent.UserController;
import com.methods.YoucodeGotTalent.Methods;
import com.models.YoucodeGotTalent.Participation;
import com.models.YoucodeGotTalent.User;

public class App {

	public static void main(String[] args) throws SQLException, AddressException, MessagingException {
		boolean back= true;
		boolean back1 = true;
		boolean back2 = true;
		boolean vBack = true;
		Scanner menu = new Scanner(System.in);
	    while (back) { 
	    	back1 = true;
	    	back2 = true;
		System.out.println("1- User");
		System.out.println("2- Admin");
		
		String input = menu.next();
		//menu.close();
		  
			 switch (Integer.parseInt(input)) {
			
		case 1 : do { 
				System.out.println("1- Add user");
			 System.out.println("2- Find user by Id");
			 System.out.println("3- Update user ");
			 System.out.println("4- Add participation ");
			 System.out.println("5- Back ");
			 int s2 = menu.nextInt();
			 UserController user = new UserController();
			 ParticipationController participation = new ParticipationController();
			 	switch(s2) {  
			 	case 1 :
			 		System.out.println("your first name");
			 		 String first_name = menu.next();
			 		System.out.println("your last name");
			 		 String last_name = menu.next();
			 		System.out.println("your email ");
			 		String email;
			 		Methods method = new Methods();
			 		boolean a;
			 	   do { 
			    	   email = menu.next();
			       		a = method.validateEmail(email);
			       		if (!a) {
			        	System.out.println("InValid email");
			       		}
			           
			        } while(a==false);
			 		 
			 		System.out.println("your phone Number ");
			 		boolean b;
			 		String phone;
				 	   do { 
				 		    phone = menu.next();
				       		b = method.validatephone(phone);
				       		if (!b) {
				        	System.out.println("PHONE INVALID");
				       		}
				           
				        } while(b==false);
			 		 
			 		user.AddUser(first_name, last_name, email, phone);
			 		break;
			 	case 2 :  System.out.println(user.findUserById().toString()); 
			 			break;
			 	case 3 : user.updateUser();
					 	break;
			 	case 4 : participation.addParticipation();	
 				break;
			 	case 5 : back2=false;
			 				break;
			 	default : System.out.println("choose from the menu below"); 
			 			break;
			 				
			 	}
		
		}while(back2);
		break;
		case 2 :
			AdminController admin = new AdminController();
			//System.out.println(admin.adminConnection());
			System.out.println("entre votre email");
			String email1 = menu.next();
			System.out.println("entre votre mot de passe");
			String password = menu.next();
			if (admin.isConnected(admin.adminConnection(email1, password))==1) {
			while (back1) { 
			    vBack = true;
			    Methods method = new Methods();
				 System.out.println("1- Find all users");
				 System.out.println("2- find all participation");
				 System.out.println("3- find  participation by email");
				 System.out.println("4- log out ");
				 int s1;
				s1 = menu.nextInt();
				 	switch(s1) {
				 	case 1 : 
				 		for(User list: admin.getAll()) {
						System.out.println(list.toString());
					}
				 		break;
				 	case 2 : for(Participation list: admin.getAllParticipation()) {
						System.out.println(list.toString());}
				 		break;
				 	case 3 :System.out.println("insert your email");
			        boolean a = false;
			        String email;
			       do { 
			    	   email = menu.next();
			       		a = method.validateEmail(email);
			       		if (!a) {
			        	System.out.println("InValid email");
			       		}
			           
			        } while(a==false);
			       
				 	
				 		System.out.println(admin.findParticipationByEmail(email).toString());
				 			 System.out.println(" you want to validate this participation ");
				 			 System.out.println(" 1- YES");
				 			 System.out.println(" 2- NO");
				 			 int v = menu.nextInt();
								while (vBack) {
										switch(v) {
										case 1 : 
													
													admin.validateParticipation(admin.findParticipationByEmail(email).getIdUser());
													
											 		method.SendMail( "smtp.gmail.com", "465", "mahdisouilmi95@gmail.com", "************", email, "validation participation", "hello,congratulations we accepted your participation ");
											System.out.println("  validated");
										vBack = false;
										break;
										case 2 : System.out.println("  did not valited");
										vBack = false;
										break;
										default : System.out.println("  error");
										 			}
										 } 
									break;
										case 4 : back1=false;
										admin.logout();
										break;
										} 
		
		
	} 
			}else System.out.println(" ERROR ");
		break;
	default : System.out.println("choose from the betwen the numbers below ! ");	
}
			}
		
	}
}
