package general;

import java.util.HashMap;
import java.util.Map;

// http://stackoverflow.com/questions/4720271/find-a-pair-of-elements-from-an-array-whose-sum-equals-a-given-number
// Implementation in Java : Using codaddict's algorithm
public class ArrayPairSum {
	public static void getSumPairs(int[] input, int k) {
		Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();

		for (int i = 0; i < input.length; i++) {
			// if element is available in hashmap, a pair that produces the sum is found
			if (pairs.containsKey(input[i]))
				System.out.println(input[i] + ", " + pairs.get(input[i]));
			else
				// key is derived based on sum and current element
				pairs.put(k - input[i], input[i]);
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 2, 7, 3, 5, 1, 8, 9 };
		getSumPairs(a, 10);
	}
}
