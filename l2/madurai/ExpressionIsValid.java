package com;

import java.util.Arrays;

public class ExpressionIsValid {
	public static void main(String[] args) {
		String s = "( a OR b ( OR AND d ) )";
//		String s = "( a OR b ( c AND ) )";

		String split[] = s.split(" "); 
		
		
		int n = split.length;

		boolean b = isValid(split, n);

		if (b) {
			System.out.println("Valid");
		} else {
			System.out.println("invalid");
		}
	}

	private static boolean isValid(String[] split, int n) {

		int open = 0;
		int close = 0;

		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(split));
			// bracket conditon
			if (split[i].equals("(")) {
				
				open++;
			} 
			if (split[i].equals(")")) {
				close++;
			}

			if (split[i].equals("AND") ) {
				
				char previous = split[i - 1].charAt(0);
				char after = split[i + 1].charAt(0);
				
				
				if (!(previous >= 'a' && previous <= 'z')) {
					return false;
				}
				
				if (!(after >= 'a' && after <= 'z')) {
					return false;
				}

			} else if (split[i].equals("OR")) {
				char previous = split[i - 1].charAt(0);
				char after = split[i + 1].charAt(0);
				
				if (!(previous >= 'a' && previous <= 'z')) {
					return false;
				}
				if (!(after >= 'a' && after <= 'z')) {
					return false;
				}
			}

		}

		System.out.println(open + " : " + close);
		if (open != close) {
			return false;
		}
		return true;

		// bracket conditon

	}
}
