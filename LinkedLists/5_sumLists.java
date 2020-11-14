// two linked lists have numbers in reverse order , add them to make to make a new reversed inked list
// 7 -> 1 -> 6 + 5 -> 9-> 2 = 2 -> -1 -> 9
// It means 617 + 295 = 912

import java.util.Scanner;
class SumLists
{

	Node numberToNode(int n)
	{
		Node head=null;
		Node curr = head;
		while(n!=0)
		{
			if(head==null)
			{
				head = new Node(n%10);
				n = n/10;
				curr = head;
			}
			else
			{
				curr.next = new Node(n%10);
				n = n/10;
				curr = curr.next;
			}
		}

		return head;
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
		SumLists ob = new SumLists();

		System.out.print("Enter the 1st number : ");
		int a = in.nextInt();
		System.out.print("Enter the 2nd number : ");
		int b = in.nextInt();
		System.out.println();

		Node na = ob.numberToNode(a);
		Node nb = ob.numberToNode(b);
		System.out.print("The 1st list is : ");
		ob.printList(na);
		System.out.print("The 2nd list is : ");
		ob.printList(nb);
	}
}

class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data= d;
		next = null;
	}
}
