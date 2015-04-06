package sorting;

import java.util.Arrays;

// https://study.cs50.net/bubble_sort
public class BubbleSort {
	public static void main(String[] args) {
		int[] intArray = { 4, 1, 3, 5, 2 };

		System.out.println(Arrays.toString(intArray) + " - unsorted");

		int length = intArray.length;
		int iterationCount = 1;

		while (length > 0) {
			for (int i = 1; i < length; i++) {
				// If previous element is bigger than current element, swap the
				// elements.
				if (intArray[i - 1] > intArray[i]) {
					int temp = intArray[i];
					intArray[i] = intArray[i - 1];
					intArray[i - 1] = temp;
				}
			}
			length--;

			System.out.println(Arrays.toString(intArray) + " - iteration "
					+ iterationCount);
			iterationCount++;
		}

		System.out.println(Arrays.toString(intArray) + " - sorted");
	}
}
