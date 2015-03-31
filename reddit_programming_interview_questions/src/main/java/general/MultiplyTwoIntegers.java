package general;

// http://www.geeksforgeeks.org/multiply-two-numbers-without-using-multiply-division-bitwise-operators-and-no-loops/
public class MultiplyTwoIntegers {
	/* function to multiply two numbers x and y */
	public static int multiply(int x, int y) {
		System.out.println("x: " + x + " y: " + y);
		
		int returnValue = -1;
		
		/* 0 multiplied with anything gives 0 */
		if (y == 0) {
			returnValue = 0;
		}
		/* Add x one by one */
		else if (y > 0) {
			returnValue = (x + multiply(x, y - 1));
		}
		/* the case where y is negative */
		else {
			returnValue = -multiply(x, -y);
		}
		
		System.out.println("returnValue: " + returnValue);
		
		return returnValue;
	}
	
	public static void main(String[] args) {
		System.out.println(multiply(2, 3));
		System.out.println(multiply(2, -3));
	}
}
