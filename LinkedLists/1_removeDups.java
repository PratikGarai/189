// Remove duplicate elements from an unsorted linked list

import java.util.Scanner;

class RemoveDups
{
	void removeDupsWithBuffer(Node head)
	{
	}

	void removeDupsWithoutBuffer(Node head)
	{
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		RemoveDups ob = new RemoveDups();
		Node head = null;
		Node prev = head;

		System.out.print("Enter the number of elements : ");
		int n = in.nextInt();
		int ele;
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the "+(i+1)+"th element : ");
			ele = in.nextInt();
			Node curr = new Node();
			curr.data = ele;
			if(head==null)
			{
				head = curr;
				prev = curr;
			}
			else
			{
				prev.next = curr;
				prev = curr;
			}
		}

		System.out.print("The enetered list is : ");
		Node curr = head;
		while(curr!=null)
		{
			System.out.print(curr.data+"  ");
			curr = curr.next;
		}

		System.out.print("The new list is : ");
		Node curr = head;
		while(curr!=null)
		{
			System.out.print(curr.data+"  ");
			curr = curr.next;
		}
	}
}

class Node
{
	int data;
	Node next;
	Node()
	{
		data = -1;
		next = null;
	}
}
