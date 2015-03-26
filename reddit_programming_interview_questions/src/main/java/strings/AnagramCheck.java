package strings;

import java.util.Arrays;

// http://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
public class AnagramCheck {
	public static boolean checkAnagramWithSort(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		
		char[] str1Array = str1.toCharArray();
		char[] str2Array = str2.toCharArray();
		
		Arrays.sort(str1Array);
		Arrays.sort(str2Array);
		
		return Arrays.equals(str1Array, str2Array);
	}
	
	public static boolean checkAnagramWithTwoCountArrays(String string1, String string2) {
	    if (string1.length() != string2.length()) {
	    	return false;
	    }
		
	    // Create two count arrays and initialize all values as 0
		int NO_OF_CHARS = 256;
	    int count1[] = new int[NO_OF_CHARS];
	    int count2[] = new int[NO_OF_CHARS];
	    int i;
	    
		char[] str1 = string1.toCharArray();
		char[] str2 = string2.toCharArray();
		
	    // For each character in input strings, increment count in
	    // the corresponding count array
	    for (i = 0; i < str1.length;  i++) {
	        count1[str1[i]]++;
	    }
	    
	    for (i = 0; i < str2.length;  i++) {
	        count2[str2[i]]++;
	    }
	    
	    System.out.println(Arrays.toString(count1));
	    System.out.println(Arrays.toString(count2));
	 
	    // Compare count arrays
	    for (i = 0; i < NO_OF_CHARS; i++) {
	        if (count1[i] != count2[i]) {
	        	return false;
	        }
	    }
	 
	    return true;
	}
	
	public static boolean checkAnagramWithOneCountArrays(String string1, String string2) {
	    if (string1.length() != string2.length()) {
	    	return false;
	    }
		
	    // Create two count arrays and initialize all values as 0
		int NO_OF_CHARS = 256;
	    int count[] = new int[NO_OF_CHARS];
	    int i;
	    
		char[] str1 = string1.toCharArray();
		char[] str2 = string2.toCharArray();
		
	    // For each character in first input string, increment count in the count array
	    for (i = 0; i < str1.length;  i++) {
	        count[str1[i]]++;
	    }
	    
	    // For each character in second input string, decrement count in the count array
	    for (i = 0; i < str2.length;  i++) {
	        count[str2[i]]--;
	    }
	    
	    System.out.println(Arrays.toString(count));
	 
	    // Compare count arrays
	    for (i = 0; i < NO_OF_CHARS; i++) {
	        if (count[i] > 0) {
	        	return false;
	        }
	    }
	 
	    return true;
	}
	
	public static void main(String[] args) {
		String string1 = "abca";
		String string2 = "bcaa";
		
		System.out.println(string1);
		System.out.println(string2);
		
		System.out.println(checkAnagramWithSort(string1, string2));
		System.out.println(checkAnagramWithTwoCountArrays(string1, string2));
		System.out.println(checkAnagramWithOneCountArrays(string1, string2));
	}
}
