package hexFormatException;

public class Test {
	  public static void main(String[] args) {
	    try {
	      p();
	      System.out.println("After the method call");
	    }
	    catch (RuntimeException ex) {
	      System.out.println("RuntimeException");
	    }
	    catch (Exception ex) {
	      System.out.println("Exception");
	    }
	  }

	  static void p() throws Exception {
	    try {
	      String s = "5.6";
	      Integer.parseInt(s); // Cause a NumberFormatException

	      int i = 0;
	      int y = 2 / i;
	      System.out.println("Welcome to Java");
	    }
	    catch (RuntimeException ex) {
	      System.out.println("RuntimeException");
	    }
	    catch (Exception ex) {
	      System.out.println("Exception");
	    }
	  }
	}