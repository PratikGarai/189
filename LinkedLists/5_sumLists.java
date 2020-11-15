// two linked lists have numbers in reverse order , add them to make to make a new reversed inked list
// 7 -> 1 -> 6  +  5 -> 9-> 2  =  2 -> -1 -> 9
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
	
	Node add(Node n1 , Node n2)
	{
		Node a = n1;
		Node b = n2;
		Node head = null;
		Node curr = null;
		int carry = 0;
		while(a!=null && b!=null)
		{
			carry += a.data + b.data;
			if(head==null)
			{
				head = new Node(carry%10);
				curr = head;
			}
			else
			{
				curr.next = new Node(carry%10);
				curr = curr.next;
			}
			carry = carry/10;
			a = a.next;
			b = b.next;
		}
		while(a!=null)
		{
			carry += a.data;
			if(head==null)
			{
				head = new Node(carry%10);
				curr = head;
			}
			else
			{
				curr.next = new Node(carry%10);
				curr = curr.next;
			}
			carry = carry/10;
			a = a.next;
		}
		while(b!=null)
		{
			carry += b.data;
			if(head==null)
			{
				head = new Node(carry%10);
				curr = head;
			}
			else
			{
				curr.next = new Node(carry%10);
				curr = curr.next;
			}
			carry = carry/10;
			b = b.next;
		}
		while(carry!=0)
		{
			if(head==null)
			{
				head = new Node(carry%10);
				curr = head;
			}
			else
			{
				curr.next = new Node(carry%10);
				curr = curr.next;
			}
			carry = carry/10;
		}
		return head;
	}

	Node numberToNodeForward(int n)
	{
		Node head = null;
		Node curr = null;
		while(n!=0)
		{
			curr = new Node(n%10);
			n = n/10;
			curr.next = head;
			head = curr;
		}
		return head;
	}

	Node addFront(Node a , Node b)
	{
		int l1 = 0;
		int l2 = 0;
		Node curr = a;
		while(curr!=null)
		{
			l1++;
			curr = curr.next;
		}
		curr = b;
		while(curr!=null)
		{
			l2++;
			curr = curr.next;
		}

		if(l1<l2)
		{
			a = padWithZeroFront(a,l2-l1);
		}
		else if(l2<l1)
		{
			b = padWithZeroFront(b,l1-l2);
		}

		Node sum = new Node(0);
		int carry = recuSum(a,b,sum);
		if(carry!=0)
			sum.data = carry;
		else
			sum = sum.next;
		return sum;
	}

	Node padWithZeroFront(Node head, int t)
	{
		Node curr = null;
		for(int i=0;i<t;i++)
		{
			curr = new Node(0);
			curr.next = head;
			head = curr;
		}
		return head;
	}

	int recuSum(Node a, Node b, Node prev)
	{
		int carry = 0;
		prev.next = new Node(0);
		if(a.next!=null)
		{
			carry = recuSum(a.next, b.next, prev.next);
		}
		carry += a.data+b.data;
		prev.next.data = carry%10;
		return carry/10;
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

		// Node na = ob.numberToNode(a);
		// Node nb = ob.numberToNode(b);
		// Node res = ob.add(na,nb);

		// For follow up question
		Node na = ob.numberToNodeForward(a);
		Node nb = ob.numberToNodeForward(b);
		Node res = ob.addFront(na,nb);

		System.out.print("The 1st list is : ");
		ob.printList(na);
		System.out.print("The 2nd list is : ");
		ob.printList(nb);
		System.out.print("The result list is : ");
		ob.printList(res);
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
