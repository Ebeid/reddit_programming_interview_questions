package strings;

public class IsPalindrome {
	// http://stackoverflow.com/questions/4138827/check-string-for-palindrome
	public static boolean istPalindrom(char[] word){
	    int i1 = 0;
	    int i2 = word.length - 1;
	    
	    while (i2 > i1) {
	        if (word[i1] != word[i2]) {
	            return false;
	        }
	        
	        ++i1;
	        --i2;
	    }
	    
	    return true;
	}
	
	public static void main(String[] args) {
		String word = "abcba";
		
		System.out.println(istPalindrom(word.toCharArray()));
	}
}
