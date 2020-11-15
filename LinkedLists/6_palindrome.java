// To check if a list is palindrome or not


import java.util.Scanner;

class Palindrome 
{
	boolean checkPalin(Node head)
	{
		Node curr1 = head;
		Node revhead = null;
		Node curr2 = null;
		while(curr1!=null)
		{
			if(revhead==null)
			{
				revhead = new Node(curr1.data);
				curr2 = revhead;
			}
			else
			{
				curr2 = new Node(curr1.data);
				curr2.next = revhead;
				revhead = curr2;
			}
			curr1 = curr1.next;
		}

		curr1 = head;
		curr2 = revhead;
		while(curr1!=null)
		{
			if(curr1.data != curr2.data)
				return false;
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		return true;
	}

	void printList(Node head)
	{
		Node curr = head;
		while(curr!=null)
		{
			System.out.print(curr.data+" -> ");
			curr = curr.next;
		}
		System.out.println("End");
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Palindrome ob = new Palindrome();

		System.out.print("Enter the number of elements : ");
		int n = in.nextInt();
		int x;
		Node head = null;
		Node curr = null;
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
		ob.printList(head);

		if(ob.checkPalin(head))
			System.out.println("The list is palindrome!");
		else
			System.out.println("The list is not palindrome!");
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
