package com.incubyte;

import java.util.*;

// just a comment 
// exception for negative number
class MyException extends Exception {
	public MyException(ArrayList<Integer> str) {
		System.out.println("negatives not allowed" + str);
	}
}
// 
public class string_calculator {

	public static void main(String[] args) throws MyException {

		System.out.println(add("1,2")); // 1
		System.out.println(add("1,6,7,8,4545"));// 2
		System.out.println(add("1,6,7\n4545"));// 3
		System.out.println(add("//;\n1;2")); // 4
		System.out.println(add("//;\n1;2;-90;-4"));// 5
		System.out.println(add("//;\n1;2;10000;999"));// 6
		System.out.println(add("//[***]\n1***2***3"));// 7
		System.out.println(add("//[*][%]\n1*2%3*7"));// 8
		System.out.println(add("//[**][%%%]\n1**2%%%3**7"));//
	}

	public static String delim(String num) {
		String s = num;
		s = s.substring(s.indexOf("[") + 1);
		s = s.substring(0, s.indexOf("]"));
		// System.out.println("delimiter is"+s);
		String delimiter = s;

		/// cut the initial defining part
		// System.out.println("the ip string is "+
		/// numbers.substring(numbers.indexOf("]") + 2));
		num = num.substring(num.indexOf("]") + 2);

		num = num.replaceAll(delimiter, ",");
		return num;

	}

	public static int add(String numbers) throws MyException

	{
		// empty string
		if (numbers == "")
			return 0;

		String delimiter = "" + ','; // the default delimiter
		// support different delimiters
		// case for string delimiters

		// getting rid of reserved characters ( in regex) replace with default delimiter
		if (numbers.contains("*"))
			numbers = numbers.replace("*", delimiter);
		if (numbers.startsWith("//[")) {
			// more than 1 delimiter
			while (!Character.isDigit(numbers.charAt(0))) {
				numbers = delim(numbers);
			}
		}

		else if (numbers.startsWith("//")) {
			delimiter = "" + numbers.charAt(2);

			// System.out.println("delimiter is "+ delimiter);
			// cut the initial part of numbers
			numbers = numbers.substring(4);

		}
		// allow new line
		numbers = numbers.replace("\n", delimiter);

		if (numbers.contains(delimiter)) {
			// unknown number of numbers
			String[] parts = numbers.split(delimiter);
			int sum = 0;
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = 0; i < parts.length; i++) {

				// negative exception
				int temp = Integer.parseInt(parts[i]);
				if (temp < 0)
					al.add(Integer.valueOf(temp));
				// numbers greater than 1000 should be ignores
				if (temp > 1000) {
					continue;
				}
				sum += temp;
			}

			try {
				if (!al.isEmpty())
					throw new MyException(al);

			} catch (MyException m) {
				System.out.println(m);

			}
			return sum;
		}

		// only one digit
		return Integer.parseInt(numbers);
	}
