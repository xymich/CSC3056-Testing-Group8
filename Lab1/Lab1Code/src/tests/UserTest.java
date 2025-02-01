package tests;

import model.User;

//Manual Testing of the User Class
public class UserTest {

	public static void main(String[] args) {
		User testUser = new User("mike@mail.com", "password123", "Mike", "Smith", "12345");
		
		System.out.println(testUser);

	}

}
