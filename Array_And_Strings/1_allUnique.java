// program to determine if all characters of a string are unique or not
// assumption: only ASCII characters are used
import java.util.Scanner;

class AllUnique
{
	
	// buffer allowed
	String buffer(String a, int n)
	{
		char[] buff = new char[256];
		for(int i=0;i<n;i++)
		{
			if(buff[a.charAt(i)]==1)
				return("No");
			else
				buff[a.charAt(i)] = 1;
		}
		return("Yes");
	}

	//no buffer allowed
	String n_buffer(String a, int n)
	{
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(a.charAt(i)==a.charAt(j))
					return("No");
			}
		}
		return("Yes");
	}

	public static void main( String[] args )
	{
		Scanner in = new Scanner(System.in);
		AllUnique ob = new AllUnique();
		System.out.print("Enter the length of the string : ");
		int n = in.nextInt();
		System.out.print("Enter the string : ");
		String s = in.next();
		
		System.out.println();
		System.out.println("Buffer space model : "+ob.buffer(s,n)); 
		System.out.println("Non Buffer space model : "+ob.n_buffer(s,n)); 
	}
}
