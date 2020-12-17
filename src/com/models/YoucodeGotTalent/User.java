package com.models.YoucodeGotTalent;

public class User {
	private long Id;
	private String lastName;
	private String firstName;
	private String email;
	private String phone;
// Constructor
		public User(long id, String lastName, String firstName, String email, String phone) {
	Id = id;
	this.lastName = lastName;
	this.firstName = firstName;
	this.email=email;
	this.phone = phone;
		}
// Getters and Setters
	public long getId() {
		return Id;
	}



	public void setId(long id) {
		Id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//methods	
	// Tostring 
	@Override
	public String toString() {
		return "User [Id=" + Id + ", lastName=" + lastName + ", firstName=" + firstName + ", phone=" + phone + "]";
	}
	

}
	


