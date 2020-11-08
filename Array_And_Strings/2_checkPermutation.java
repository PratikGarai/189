// given 2 strings check if one is permutation of the other
// assuming it is an ASCII string
import java.util.Scanner;

class CheckPermutation
{
	
	boolean isPermutation(String a, int la, String b, int lb)
	{
		if(la!=lb)
			return false;

		char[] counts = new char[256];
		for(int i=0;i<la;i++)
		{
			counts[a.charAt(i)]++;
			counts[b.charAt(i)]--;
		}

		for(int i=0;i<la;i++)
			if(counts[i]!=0)
				return false;
		
		return true;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		CheckPermutation ob = new CheckPermutation();
		System.out.print("Enter the length of 1st string : ");
		int la = in.nextInt();
		System.out.print("Enter the 1st string : ");
		String a = in.next();
		System.out.print("Enter the length of 2nd string : ");
		int lb = in.nextInt();
		System.out.print("Enter the 2nd string : ");
		String b = in.next();

		System.out.println();
		if(ob.isPermutation(a,la,b,lb))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
