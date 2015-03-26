package strings;

// http://stackoverflow.com/questions/3133770/how-to-find-out-if-the-value-contained-in-a-string-is-double-or-not
public class IsStringIntOrDouble {
	public static boolean isDoubleParse(String s) {
		if (s == null)
			return false;
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isIntegerParse(String s) {
		if (s == null)
			return false;
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isDoubleParse("2.22"));
		System.out.println(isIntegerParse("2"));
		System.out.println(isDoubleParse("abc"));
	}
}
