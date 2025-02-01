package model;

public class User {
	private String username; // email address
	private String password;
	private String first_name;
	private String last_name;
	private String mobile_number;
	
	public User(String user, String pass, String first, String last, String mobile) {
		this.username = user;
		this.password = pass;
		this.first_name = first;
		this.last_name = last;
		this.mobile_number =  mobile;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String user) {
		this.username = user;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String pass) {
		this.password = pass;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String toString() {
		return "User [username=" + username + ", password=" + password + ", first_name=" + first_name + ", last_name="
				+ last_name + ", mobile_number=" + mobile_number + "]";
	}
	
	
}
