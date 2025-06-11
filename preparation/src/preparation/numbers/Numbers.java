/**
 * 
 */
package preparation.numbers;

import java.util.Arrays;

/**
 * 
 */
public class Numbers {

	public static long findFactorialRecursive(int n) {
		if (n == 1) {
			return 1;
		}
		return n * findFactorialRecursive(n - 1);
	}

	public static long findFactorial(int n) {
		long result = 1l;
		if (n < 1) {
			return 0;
		}
		for (int i = n; i >= 2; i--) {
			result *= i;
		}
		return result;
	}

	// Given an array of non-duplicating numbers from 1 to n where one number is
	// missing,
	// write an efficient java program to find that missing number.
	public static int findMissingNumber(int[] numbers) {
		System.out.println("numbers" + Arrays.toString(numbers));
		int sumOfActualArray = 0;
		int sumOfNumbers = 0;
		for (int i = 1; i <= numbers.length + 1; i++) {
			sumOfActualArray += i;
		}
		sumOfNumbers = Arrays.stream(numbers).reduce((x, y) -> x + y).getAsInt();
		System.out.println("sumOfNumbers: " + sumOfNumbers);
		System.out.println("sumOfActualArray: " + sumOfActualArray);
		return sumOfActualArray - sumOfNumbers;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Calling of functions
		System.out.println("################ Find factorial of a given number##########");
		System.out.println("factorial of 5:" + findFactorial(5));
		System.out.println("factorial of 3:" + findFactorial(3));
		System.out.println("factorial of 1:" + findFactorial(1));
		System.out.println("factorial of 5:" + findFactorialRecursive(5));
		System.out.println("factorial of 3:" + findFactorialRecursive(3));
		System.out.println("factorial of 1:" + findFactorialRecursive(1));

		System.out.println("################ Find Missing number##########");
		int[] numbers = { 1, 2, 4, 5, 6 };
		System.out.println(findMissingNumber(numbers));
		System.out.println(findMissingNumber(new int[] { 1, 2, 3, 5 }));

	}

}
