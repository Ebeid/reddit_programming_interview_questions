package general;

// http://www.dreamincode.net/forums/topic/311569-implement-exponential-function-with-basic-operations/
public class ExponentialFunction {
	// "x ^ y" means "x * x * ... * x" (y times). "product * x" means "product + product + ... + product" (x times)
	public static int exponential(int x, int y) {
		if (y == 0) {
			return 1;
		}
		else {
			int result = 1, prod;

			for (int i = 0; i < y; i++) {
				prod = 0;

				for (int j = 0; j < x; j++) {
					prod = prod + result;
				}

				result = prod;
			}
			
			return result;
		}
	}

	// 2 ^ 4 = (2 ^ 2) * (2 ^ 2) (y is even)
	// 2 ^ 5 = 2 * (2 ^ 4) = 2 * (2 ^ 2) * (2 ^ 2) (y is odd)
	public static int exponentialRecursively(int x, int y) {
		int temp;
		if (y == 0)
			return 1;
		if (y == 1)
			return x;
		temp = exponentialRecursively(x, y / 2);
		if (y % 2 == 0)
			return temp * temp;
		return x * temp * temp;
	}
	
	public static void main(String[] args) {
		System.out.println(exponential(2, 3));
		System.out.println(exponentialRecursively(2, 3));
	}
}
