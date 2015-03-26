package strings;

// http://stackoverflow.com/questions/19484406/detecting-if-a-string-has-unique-characters-comparing-my-solution-to-cracking
public class CheckForUnique {
	public static void main(String[] args) {
		System.out.println(hasDuplicates("aac"));
		System.out.println(hasDuplicates("abc"));
	}

	// assume word only contains lower case characters
	public static boolean hasDuplicates(String word) {
		boolean[] check = new boolean[26]; // 26 English alphabets
		
		for (int i = 0; i < word.length(); i++) {
			// int value of 'a' is 97. By subtracting this number we find array
			// index starting from 0 to 26
			int pos = word.toLowerCase().charAt(i) - 'a';
			
			if (check[pos])
				return true;
			else
				check[pos] = true;
		}
		
		return false;
	}
}
