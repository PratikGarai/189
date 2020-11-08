// replaces whitespaces in a string with "%20"

import java.util.Scanner;

class URLify
{

	String urlify(String s, int n)
	{
		StringBuilder str = new StringBuilder();
		for(int i=0;i<n;i++)
		{
			char a = s.charAt(i);
			if(a==' ')
				str.append("%20");
			else 
				str.append(String.valueOf(a));
		}

		return str.toString();
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		URLify ob = new URLify();
		System.out.print("Enter the length of the string : ");
		int n = in.nextInt();
		System.out.print("Enter the string : ");
		in.nextLine();
		String s = in.nextLine();

		System.out.println();
		System.out.println(ob.urlify(s,n));
	}
}
