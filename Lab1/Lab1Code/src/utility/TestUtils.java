package utility;

public class TestUtils {

	// test message text colours
	public static final String TEXT_COLOR_RESET = "\u001B[0m";
	public static final String TEXT_COLOR_GREEN = "\u001B[32m";
	public static final String TEXT_COLOR_RED = "\u001B[31m";
	
	public static void printCaseFail(String tcName) {
		 System.out.println(TEXT_COLOR_RED + "Fail -- " + tcName + TEXT_COLOR_RESET);
	}
	public static void printCasePass(String tcName) {
		 System.out.println(TEXT_COLOR_GREEN + "Pass -- " + tcName + TEXT_COLOR_RESET);
	}
	public static void printAssertPass(String tcClass, String tcMethod ) {
		System.out.println(TEXT_COLOR_GREEN + "All java assertions in the " + tcClass + " " + tcMethod + " test suite passed." + TEXT_COLOR_RESET);
	}
}

