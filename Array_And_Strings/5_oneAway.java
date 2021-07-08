// Given 2 strings, check if they can be made qual with at most 1 operation
// Operations : Insert , delete, replace

import java.util.Scanner;

class OneAway {

	public boolean check(String a, String b) {
		int l1 = a.length();
		int l2 = b.length();

		if(Math.abs(l1-l2) >= 2)
			return false;

		int i1 = 0;
		int i2 = 0;
		int changes = 0;

		while(i1<l1 && i2<l2) {
			if(changes>=2) {
				return false;
			}
			else if (a.charAt(i1)==b.charAt(i2)) {
				i1++;
				i2++;
			} 
			else if (l1==l2) {
				i1++;
				i2++;
				changes++;
			} 
			else if (l1>l2) {
				i1++;
				changes++;
			}
			else {
				i2++;
				changes++;
			}
		}

		return changes<2;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the 1st string : ");
		String a = in.nextLine();
		System.out.print("Enter the 2nd string : ");
		String b = in.nextLine();

		OneAway ob = new OneAway();
		if(ob.check(a, b))
			System.out.println("One away");
		else 
			System.out.println("More than one away");
	}
}
