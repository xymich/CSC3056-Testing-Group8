package utility;

public class TestUtils {
    // Test message text colors
    public static final String TEXT_COLOR_RESET = "\u001B[0m";
    public static final String TEXT_COLOR_GREEN = "\u001B[32m";
    public static final String TEXT_COLOR_RED = "\u001B[31m";


	//Prints a test pass message in green.
    
    public static void printTestPass(String testName) {
        System.out.println(TEXT_COLOR_GREEN + testName + " - PASSED" + TEXT_COLOR_RESET);
    }

    
      //Prints a test fail message in red.
 
    public static void printTestFail(String testName) {
        System.out.println(TEXT_COLOR_RED + testName + " - FAILED" + TEXT_COLOR_RESET);
    }
}
