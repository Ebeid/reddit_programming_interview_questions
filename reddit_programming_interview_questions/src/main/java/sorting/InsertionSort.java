package sorting;

import java.util.Arrays;

// https://study.cs50.net/insertion_sort
public class InsertionSort {
	public static void main(String[] args) {
		int[] intArray = { 3, 1, 5, 4, 2 };
		System.out.println(Arrays.toString(intArray) + " - unsorted");
		System.out.println();

		int iterationCount = 1;

		for (int i = 0; i < intArray.length; i++) {
			int currentElement = intArray[i];
			System.out.println("currentElement: " + currentElement);

			// index for sorted section of array
			int j = i;

			// if previous element is greater than current element
			// j > 0 condition is necessary to prevent
			// java.lang.ArrayIndexOutOfBoundsException in first iteration
			while (j > 0 && intArray[j - 1] > currentElement) {
				intArray[j] = intArray[j - 1]; // shift elements rightwards
				j--; // change to previous index
			}

			System.out.println("j: " + j);

			// place current element into a room made from shifting
			intArray[j] = currentElement;

			System.out.println(Arrays.toString(intArray) + " - iteration "
					+ iterationCount);
			iterationCount++;
			System.out.println();
		}

		System.out.println(Arrays.toString(intArray) + " - sorted");
		System.out.println();
	}
}