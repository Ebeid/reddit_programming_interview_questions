package strings;

import java.util.HashMap;
import java.util.Map.Entry;

// http://javahungry.blogspot.com/2013/12/first-non-repeated-character-in-string-java-program-code-example.html
public class FindFirstNonRepeatedCharacterInString {
	public static void main(String[] args) {
		System.out.println(firstNonRepeatedCharacter("abcabcd"));
	}

	public static Character firstNonRepeatedCharacter(String str) {
		HashMap<Character, Integer> characterhashtable = new HashMap<Character, Integer>();
		int i, length;
		Character c;
		
		length = str.length(); // Scan string and build hash table
		
		for (i = 0; i < length; i++) {
			c = str.charAt(i);
			
			if (characterhashtable.containsKey(c)) {
				// increment count corresponding to c
				characterhashtable.put(c, characterhashtable.get(c) + 1);
			} else {
				characterhashtable.put(c, 1);
			}
		}
		
		printHashTable(characterhashtable);
		
		// Search characterhashtable in in order of string str
		for (i = 0; i < length; i++) {
			c = str.charAt(i);
			
			if (characterhashtable.get(c) == 1)
				return c;
		}
		
		return null;
	}
	
	public static void printHashTable(HashMap<Character, Integer> characterhashtable) {
		for (Entry<Character, Integer> entry : characterhashtable.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}
