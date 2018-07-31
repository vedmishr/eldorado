package com.app.SpringBootProject.bean;

import java.sql.Date;

public class Guest {
	
	private long guestId;
	private String email;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String password;
	private Date createdDate;
	private Date updatedDate;
	public Guest() {
		super();
	}
	public Guest( String email, String firstName, String lastName, String address, String phone,
			String password) {
		super();
		
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.password = password;
		
	}
	public long getguestId() {
		return guestId;
	}
	public void setguestId(long guestId) {
		this.guestId = guestId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getupdatedDate() {
		return updatedDate;
	}
	public void setupdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "GuestProfile [guestId=" + guestId + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", address=" + address + ", phone=" + phone + ", password=" + password
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
	


}
