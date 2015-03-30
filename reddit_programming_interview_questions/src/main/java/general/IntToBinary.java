package general;

// http://stackoverflow.com/questions/13147413/convert-decimal-to-binary
public class IntToBinary {
	public static int convert(int decimal, int base) {
		int result = 0;
		int multiplier = 1;

		while (decimal > 0) {
			int residue = decimal % base;
			decimal = decimal / base;
			result = result + residue * multiplier;
			multiplier = multiplier * 10;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(convert(10, 2));
	}
}
