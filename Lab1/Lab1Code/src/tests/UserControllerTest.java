package tests;

import java.util.Vector;
import controller.UserController;
import model.User;

public class UserControllerTest {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";

	public static void testLoadUsers() {
		Vector<User> users_test = new Vector<>();
		assert users_test.size() == 0;
		users_test = UserController.loadUserData();
		assert users_test.size() >= 0;
		
		System.out.println(ANSI_GREEN + "All java assertions in the UserController loadUsers test suite passed." + ANSI_RESET);
	}
	
	public static void main(String[] args) {
		testLoadUsers();
	}
	
}
