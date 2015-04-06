package sorting;

import java.util.Arrays;

// https://study.cs50.net/selection_sort
public class SelectionSort {
	public static void main(String[] args) {
		int[] intArray = { 3, 5, 2, 1, 4 };
		System.out.println(Arrays.toString(intArray) + " - unsorted");

		int iterationCount = 1;

		// skip iteration if there is only on element in the list
		for (int i = 0; i <= intArray.length - 2; i++) {
			// assume index of first element is minimum element
			int minIndex = i;

			// find index of minimum element starting from next index of current
			// index
			for (int j = i + 1; j <= intArray.length - 1; j++) {
				if (intArray[j] < intArray[minIndex]) {
					minIndex = j;
				}
			}

			// if index of minimum element changed, swap current element with
			// minimum element
			if (minIndex != i) {
				int temp = intArray[i];
				intArray[i] = intArray[minIndex];
				intArray[minIndex] = temp;
			}

			System.out.println(Arrays.toString(intArray) + " - iteration "
					+ iterationCount);
			iterationCount++;
		}

		System.out.println(Arrays.toString(intArray) + " - sorted");
	}
}