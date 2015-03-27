package general;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentInteger {
	// http://stackoverflow.com/questions/1852631/determine-the-most-common-occurance-in-an-array
	public static int mostFrequent(int... ary) {
	    Map<Integer, Integer> m = new HashMap<Integer, Integer>();

	    for (int a : ary) {
	        Integer freq = m.get(a);
	        m.put(a, (freq == null) ? 1 : freq + 1);
	    }

	    int max = -1;
	    int mostFrequent = -1;

	    for (Map.Entry<Integer, Integer> e : m.entrySet()) {
	        if (e.getValue() > max) {
	            mostFrequent = e.getKey();
	            max = e.getValue();
	        }
	    }

	    return mostFrequent;
	}
	
	public static void main(String[] args) {
		int[] n = new int[] { 10, 10, 10, 3, 10, 10, 6, 10, 10, 9, 10 };
		System.out.println(mostFrequent(n));
	}
}
