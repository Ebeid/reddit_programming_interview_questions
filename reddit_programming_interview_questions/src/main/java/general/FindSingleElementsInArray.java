package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSingleElementsInArray {
	// http://stackoverflow.com/questions/1852631/determine-the-most-common-occurance-in-an-array
	public static List<Integer> findSingles(int... ary) {
	    Map<Integer, Integer> m = new HashMap<Integer, Integer>();

	    for (int a : ary) {
	        Integer freq = m.get(a);
	        m.put(a, (freq == null) ? 1 : freq + 1);
	    }

	    List<Integer> singles = new ArrayList<Integer>();
	    
	    for (Map.Entry<Integer, Integer> e : m.entrySet()) {
	        if (e.getValue() == 1) {
	        	singles.add(e.getKey());
	        }
	    }

	    return singles;
	}
	
	public static void main(String[] args) {
		int[] n = new int[] { 1, 1, 2, 2, 2, 3, 4, 5, 5 };
		System.out.println(findSingles(n));
	}
}
