package preparation.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Strings {

	// reverse a string
	public static String reverseString(String str) {
		char[] chars = str.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			stringBuilder.append(chars[i]);
		}
		return stringBuilder.toString();
	}

	// reverse a string with recursion
	public static String reverseStringRecursive(String str) {
		if (str == null || str.length() == 1) {
			return str;
		}
		return str.charAt(str.length() - 1) + reverseStringRecursive(str.substring(0, str.length() - 1));
	}

	// check if the word is a palindrome word
	public static boolean palindromeCheck(String str) {
		if (null != str && !str.isBlank()) {
			String reverse = reverseStringRecursive(str);
			return reverse.equals(str);
		} else
			return true;
	}

	// print Fibonacci numbers
	public static void printFibonacci(int current, int next, int n) {
		System.out.println(current);
		if(current+next <= n)
		printFibonacci(next, current+next, n);
	}
	
	// check if 2 strings are anagram string
	public static boolean checkAnagram(String first, String second) {
		if(null == first || null ==second || first.length()!=second.length()) {
			return false;
		}else {
			char[] firstArray = first.toUpperCase().toCharArray();
			Arrays.sort(firstArray);
			char[] secondArray = second.toUpperCase().toCharArray();
			Arrays.sort(secondArray);
			if(Arrays.equals(firstArray, secondArray)) {
				return true;
			} else return false;
		}
	}

	public static void main(String[] args) {

		System.out.println("##########reverseString###############");
		System.out.println("Varma First program:" + reverseString("Varma"));
		System.out.println("##########reverseStringRecursive###############");
		System.out.println("String reverse program:" + reverseStringRecursive("Varma"));
		System.out.println("##########palindromeCheck###############");
		System.out.println("Palindrome check for -varma: " + palindromeCheck("varma"));
		System.out.println("Palindrome check for -\"  \": " + palindromeCheck("  "));
		System.out.println("Palindrome check for -null: " + palindromeCheck(null));
		System.out.println("Palindrome check for -rotator: " + palindromeCheck("rotator"));
		System.out.println("Palindrome check for -wow: " + palindromeCheck("wow"));
		System.out.println("##########printFibonacci###############");
		System.out.println("under 0");
		printFibonacci(0,1,0);
		System.out.println("under 1");
		printFibonacci(0,1,1);
		System.out.println("under 2");
		printFibonacci(0,1,2);
		System.out.println("under -10");
		printFibonacci(0,1,-10);
		System.out.println("under 10");
		printFibonacci(0,1,-10);
		System.out.println("##########check anagrams###############");
		System.out.println("Varma, vRMaa");
		System.out.println(checkAnagram("Varma", "vRMaa"));
		System.out.println("Varma, Santhosh");
		System.out.println(checkAnagram("Santhosh", "vARMA"));
		System.out.println("varaa, vARMA");
		System.out.println(checkAnagram("varaa", "vARMA"));
	}
}
