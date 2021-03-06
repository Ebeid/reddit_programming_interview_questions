package strings;

// http://www.ericleschinski.com/c/java_permutations_recursion/
public class PrintAllPermutations {
	private static void permutation(String prefix, String str) {
		int n = str.length();
		
		System.out.print("prefix: " + prefix + " str: " + str + " n: " + n + " ");

		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++) {
				System.out.println("i: " + i + " character: " + str.charAt(i));
				
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1));
			}
		}
	}

	public static void main(String[] args) {
		permutation("", "ABCD");
	}
}
