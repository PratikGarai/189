// partition a linked list so that all elements less than a given number occur before the ones greater than or equal to it
// 2 approaches are there :
// 	1. create a new list
// 	2. use the same list by shifting greater and equal elements to tail

import java.util.Scanner;

class Partition 
{
 	Node method1(Node head, int partition)
	{
		Node curr = head;
		Node head1 = null;
		Node curr1 = null;
		Node head2 = null;
		Node curr2 = null;

		while(curr!=null)
		{
			if(curr.data<partition)
			{
				if(head1==null)
				{
					head1 = new Node(curr.data);
					curr1 = head1;
				}
				else
				{
					curr1.next = new Node(curr.data);
					curr1 = curr1.next;
				}
			}
			else
			{
				if(head2==null)
				{
					head2 = new Node(curr.data);
					curr2 = head2;
				}
				else
				{
					curr2.next = new Node(curr.data);
					curr2 = curr2.next;
				}
			}
			curr = curr.next;
		}

		curr1.next = head2;
		return head1;
	}

	void method2(Node head, int partition)
	{
		if(head==null || head.next==null)
			return;
		Node tail = head;
		while(tail.next!=null)
			tail = tail.next;
		
		Node base_tail = tail;
		Node curr = head;
		Node prev = null;
		while(curr!=base_tail.next)
		{
			if(curr.data<partition)
			{
				prev = curr;
				curr = curr.next;
			}
			else
			{
				if(prev!=null)
				{
					prev.next = curr.next;
					tail.next = curr;
					curr.next = null;
					tail = tail.next;
					curr = prev.next;
				}
				else
				{
					curr = curr.next;
					tail.next = head;
					tail.next.next = null;
					tail = tail.next;
					head = curr;
				}
			}
		}
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Partition ob = new Partition();

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
		System.out.print("\nThe entered list is : ");
		curr = head;
		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
		
		System.out.print("\nEnter the partition element : ");
		int partition = in.nextInt();

		// method 1
		// curr = ob.method1(head, partition);
		//
		// method 2
		ob.method2(head, partition);
		curr = head;

		System.out.print("\nThe processed list is : ");
		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
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
