package general;

// http://stackoverflow.com/questions/2553522/interview-question-check-if-one-string-is-a-rotation-of-other-string
//	algorithm checkRotation(string s1, string s2) 
//	if(len(s1) != len(s2))
//	  return false
//	if(substring(s2,concat(s1,s1))
//	  return true
//	return false
//	end
public class RoatedArrayCheck {
	public static boolean isRotation(String s1, String s2) {
	    return (s1.length() == s2.length()) && ((s1 + s1).indexOf(s2) != -1);
	}
	
	public static void main(String[] args) {
		int[] array1 = {1,2,3,5,6,7,8};
		int[] array2 = {5,6,7,8,1,2,3};
		
		String string1 = "";
		String string2 = "";
		
		for (int element : array1) {
			string1 += element;
		}
		
		for (int element : array2) {
			string2 += element;
		}
		
		System.out.println("string1: " + string1);
		System.out.println("string2: " + string2);
		System.out.println(isRotation(string1, string2));
	}
}
