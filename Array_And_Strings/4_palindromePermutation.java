// Given a string, find if it is a permutatio of a palindrome, ignoring case

import java.util.Scanner;

class PalindromePermutation {

	public boolean check(String s) {

		int l = s.length();
		char[] c = s.toLowerCase().toCharArray();
		int[] counts = new int[26];
		for(char ch : c) {
			if(ch>='a' && ch<='z')
				counts[ch-'a'] += 1;
		}

		int singles = 0;
		for(int count : counts) {
			if(count%2==1) {
				singles += 1;
			}
		}

		return singles==0||singles==1;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String s;
		System.out.print("Enter the sentence : ");
		s = in.nextLine();
		PalindromePermutation ob = new PalindromePermutation();
		boolean res = ob.check(s);

		if(res)
			System.out.println("Permutation of a palindrome");
		else 
			System.out.println("Not permutation of a palindrome");
	}
}
