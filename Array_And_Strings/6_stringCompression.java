// Compress the given string in case of repeated characters
// aabbbbcccaa -> a2b4c3a2
// Apply change only if final result is shorter than original

import java.util.Scanner;

class StringCompression {

	public String getCompressedString(String s) {
		int l = s.length();
		if(l==0||l==1)
			return s;
		StringBuilder sbd = new StringBuilder();
		char last_char = s.charAt(0);
		int count = 1;
		for(int i=1; i<l; i++)
		{
			if(last_char==s.charAt(i))
				count++;
			else {
				sbd.append(last_char);
				sbd.append(count);
				last_char = s.charAt(i);
				count = 1;
			}
		}
		sbd.append(last_char);
		sbd.append(count);

		String new_str = sbd.toString();
		if(l<=new_str.length())
			return s;
		else
			return sbd.toString();
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the string to compress : ");
		String s = in.nextLine();
		StringCompression ob = new StringCompression();

		System.out.println("The compressed string : "+ob.getCompressedString(s));
	}
}
