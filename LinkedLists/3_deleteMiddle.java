// delete a node in the middle of the list, i.e., except the frst and last by only accessing that node.

import java.util.Scanner;

class DeleteMiddle
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

		System.out.print("The entered list is : ");
		curr = head;
		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			curr = curr.next;
		}

		System.out.print("\nEnter the middle index to delete : ");
		int t = in.nextInt();

		Node toBeDeleted = head;
		for(int i=0;i<t-1;i++)
			toBeDeleted = toBeDeleted.next;
		
		toBeDeleted.data = toBeDeleted.next.data;
		toBeDeleted.next = toBeDeleted.next.next;


		System.out.print("\nThe new list is : ");
		curr = head;
		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
	}
}

class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
