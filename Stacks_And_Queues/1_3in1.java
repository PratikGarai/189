// implement 3 stacks inside a single array
// There are 2 ways :
// 	1. Fixed location
// 	2. Dynamic

import java.util.Scanner;

class ThreeInOne
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		System.out.print("Enter the number of elements : ");
		int n = in.nextInt();

		FixedModel ob = new FixedModel(n);
		int x,s;
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the "+(i+1)+"th number : ");
			x = in.nextInt();
			System.out.print("Enter the stack number : ");
			s = in.nextInt();
			if(ob.push(s,x))
				System.out.println("Push successfull");
			else
				System.out.println("Push failed");
		}

		System.out.print("The data in the stack : ");
		ob.printData();

		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the stack number to pop from : ");
			s = in.nextInt();
			System.out.println("The element popped : "+ob.pop(s));
		}
	}
}

class FixedModel
{
	int length;
	int[] data;
	int[][] pos;
	FixedModel(int n)
	{
		length = n;
		data = new int[n];
		pos = new int[3][3];    // for each stack, a {low, high, top}

		int k = n/3;
		pos[0][2] = -1;
		pos[0][1] = k;
		pos[1][2] = k-1;
		pos[1][0] = k;
		pos[1][1] = 2*k;
		pos[2][2] = 2*k-1;
		pos[2][0] = 2*k;
		pos[2][1] = n;
	}

	boolean push(int stack_number, int d)
	{
		if(stack_number>3||stack_number<=0)
			return false;
		if(pos[stack_number-1][2]==pos[stack_number-1][1]-1)
			return false;
		data[++pos[stack_number-1][2]] = d;
		return true;
	}

	int peek(int stack_number)
	{
		if(stack_number>3||stack_number<=0)
			return -1;
		if(pos[stack_number-1][2]==pos[stack_number-1][0]-1)
			return -1;
		return data[pos[stack_number-1][2]--]; 
	}

	int pop(int stack_number)
	{
		if(stack_number>3||stack_number<=0)
			return -1;
		if(pos[stack_number-1][2]==pos[stack_number-1][0]-1)
			return -1;
		return data[pos[stack_number-1][2]--]; 
	}

	void printData()
	{
		for(int s : data)
			System.out.print(s+" ");
		System.out.println();
	}
}
