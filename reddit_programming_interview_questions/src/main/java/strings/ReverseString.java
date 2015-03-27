package strings;

import java.util.Arrays;

// http://javarevisited.blogspot.com/2012/01/how-to-reverse-string-in-java-using.html
public class ReverseString {
	public static String reverseIteratively(String input) {
		String reverse = "";
		
		for (int i = input.length() - 1; i >= 0; i --) {
			reverse = reverse + input.charAt(i);
		}
		
		return reverse;
	}
	
	// http://www.ericleschinski.com/c/reverse_string_in_java/
	public static String reverseInPlace(String input) {
		char[] reverseArray = input.toCharArray();
		
		int left = 0;
		int right = reverseArray.length - 1;
		
		while (left <= right) {
			char tmp = reverseArray[right];
			reverseArray[right] = reverseArray[left];
			reverseArray[left] = tmp;
			
			left++;
			right--;
		}
		
		return new String(reverseArray);
	}
	
	public static String reverseRecursively(String input) {
		System.out.println("reverseRecursively input:" + input);
		
		//base case to handle one char string and empty string
        if (input.length() < 2) {
            return input;
        }

        return reverseRecursively(input.substring(1)) + input.charAt(0);
	}
	
	public static void main(String[] args) {
		String input = "abc";
	
		System.out.println(reverseIteratively(input));
		System.out.println(reverseInPlace(input));
		System.out.println(reverseRecursively(input));
	}
}
