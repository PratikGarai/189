// Find the Kth last element of a linked list

import java.util.Scanner;

class KthLast
{
	int kth(Node head, int k)
	{
		Node base = head;
		Node curr = head;
		for(int i=0;i<k;i++)
			curr = curr.next;
		while(curr!=null)
		{
			curr = curr.next;
			base = base.next;
		}
		return base.data;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		KthLast ob = new KthLast();

		System.out.print("Enter the number of elements : ");
		int n = in.nextInt();
		Node head = null;
		Node curr = null;
		int ele;
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the "+(i+1)+"th element : ");
			ele = in.nextInt();
			if(head==null)
			{
				head = new Node(ele);
				curr = head;
			}
			else
			{
				curr.next = new Node(ele);
				curr = curr.next;
			}
		}
		
		curr = head;
		System.out.println("The entered list is : ");
		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			curr = curr.next;
		}

		System.out.print("\nEnter the value of 'k' : ");
		int k = in.nextInt();
		if(k<=0)
			System.out.println("Invalid, k should be atleast 1");
		else if(k>n)
			System.out.println("Not possible, 'k' greater than number of elements in list ");
		else
			System.out.println("The K th last element is : "+ob.kth(head, k));
	}
}

class Node
{
	int data ;
	Node next ;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
