// partition a linked list so that all elements less than a given number occur before the ones greater than or equal to it

import java.util.Scanner;

class Partition 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		System.out.print("Enter the number of elements : ");
		int n = in.nextInt();

		Node head = null;
		Node curr = null;
		int x;
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the "+(i+1)+"th element : ");
			x = in.nextInt();
			if(head==null)
			{
				head = new Node(x);
				curr = head;
			}
			else
			{
				curr.next = new Node(x);
				curr = curr.next;
			}
		}

		System.out.print("\n The entered list is : ");
		curr = head;
		while(curr!=null)
		{
			System.out.print(curr.data);
			curr = curr.next;
		}

		System.out.print("\n The processed list is : ");
		curr = head;
		while(curr!=null)
		{
			System.out.print(curr.data);
			curr = curr.next;
		}
}

class Node
{
	int data ;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
