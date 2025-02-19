package controller;


import model.User;
import java.util.Vector;

public class UserController {

    /**
     * loads user data into the system.
     *
     * @return A list of users.
     */
    public static Vector<User> loadUserData() {
        Vector<User> users = new Vector<>();
        users.add(new User("mike@mikemail.com", "my_passwd", "Mike", "Smith", "07771234567"));
        users.add(new User("james.cameron@gmail.com", "angel", "James", "Cameron", "07777654321"));
        users.add(new User("julia.roberts@gmail.com", "change_me", "Julia", "Roberts", "07770123456"));
        return users;
    }
	
    /**
     * prints all users in the system.
     *
     * @param users The list of users.
     */
    public static void printAllUsers(Vector<User> users) {
        System.out.println("There are: " + users.size() + " users in the system.");
        System.out.println(String.format("%-25s| %-15s| %-15s| %-15s| %-15s",
                "Username", "Password", "First Name", "Last Name", "Mobile Number"));
        System.out.println("-------------------------------------------------------------------------------------------");
        
        for (User user : users) {
            System.out.println(user.toString());
        }
        System.out.println();
    }
}
