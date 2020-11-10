// Remove duplicate elements from an unsorted linked list

import java.util.Scanner;
import java.util.HashSet;

class RemoveDups
{
	void removeDupsWithBuffer(Node head)
	{
		if(head==null)
			return ;

		Node prev = head;
		Node curr = head.next;
		HashSet<Integer> a = new HashSet<Integer>();
		a.add(head.data);
		while(curr!=null)
		{
			if(a.contains(curr.data))
			{
				prev.next = curr.next;
				curr = curr.next;
			}
			else
			{
				a.add(curr.data);
				prev = prev.next;
				if(prev==null)
					break;
				curr = curr.next;
			}
		}
	}

	void removeDupsWithoutBuffer(Node head)
	{
		if(head==null)
			return ;

		Node base = head;

		while(base.next!=null)
		{
			Node prev = base;
			Node curr = base.next;
			while(curr!=null)
			{
				if(curr.data==base.data)
				{
					prev.next = curr.next;
					curr = curr.next;
				}
				else
				{
					prev = prev.next;
					curr = curr.next;
				}
			}
			base = base.next;
			if(base==null)
				break;
		}
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
	
		// ob.removeDupsWithBuffer(head);
		ob.removeDupsWithoutBuffer(head);
		System.out.print("\nThe new list is : ");
		curr = head;
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
