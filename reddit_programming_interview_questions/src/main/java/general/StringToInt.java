package general;

// http://stackoverflow.com/questions/1410555/how-does-integer-parseintstring-actually-work
public class StringToInt {
	public int ConvertStringToInt(String s) throws NumberFormatException {
		int num = 0;
		
		for (int i = 0; i < s.length(); i++) {
			// ASCII 0 => 48, 9 => 57
			if (((int) s.charAt(i) >= 48) && ((int) s.charAt(i) <= 57)) {
				num = num * 10 + ((int) s.charAt(i) - 48);
				
				System.out.println("num: " + num);
			} else {
				throw new NumberFormatException();
			}
		}
		
		return num;
	}

	public static void main(String[] args) {
		StringToInt obj = new StringToInt();
		int i = obj.ConvertStringToInt("1234123");
		System.out.println(i);
	}

}