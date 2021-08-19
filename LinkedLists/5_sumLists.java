// Linked list elements represent digits from back to front, add them

import java.util.Scanner;

class SumLists {

	Node head;
	Node last;

	public void addData(int n) {
		if(head==null) {
			head = new Node(n);
			last = head;
		} else {
			last.next = new Node(n);
			last = last.next;
		}
	}

	public void acceptData(int n) {
		Scanner in = new Scanner(System.in);
		for(int i=0; i<n; i++) {
			System.out.print("Enter the "+(i+1)+"th element : ");
			addData(in.nextInt());
		}
	}

	public void printList() {
		if(head==null) {
			System.out.println("List is empty");
			return;
		}

		Node current = head;
		while(current!=null) 
		{
			System.out.print(current.data+" -> ");
			current = current.next;
		}
		System.out.println("end");
	}

	public void printList(Node head) {
		if(head==null) {
			System.out.println("List is empty");
			return;
		}

		Node current = head;
		while(current!=null) 
		{
			System.out.print(current.data+" -> ");
			current = current.next;
		}
		System.out.println("end");
	}


	public void addToList(Node head2) {
		int carry = 0;
		Node curr1 = head;
		Node curr2 = head2;
		Node prev1 = null;

		while(curr2!=null || carry!=0) {
			if(curr2!=null) {
				carry += curr2.data;
				curr2 = curr2.next;
			}
			if(curr1!=null) {
				int s = curr1.data+carry;
				curr1.data = s%10;
				carry = s/10;
				prev1 = curr1;
				curr1 = curr1.next;
			} else {
				prev1.next = new Node(carry);
				prev1 = prev1.next;
				curr1 = prev1.next;
				carry = carry/10;
			}
		}
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		SumLists ob1 = new SumLists();
		System.out.print("Enter the number of elements in list 1 : ");
		int n1 = in.nextInt();
		ob1.acceptData(n1);
		ob1.printList();

		SumLists ob2 = new SumLists();
		System.out.print("Enter the number of elements in list 2 : ");
		int n2 = in.nextInt();
		ob2.acceptData(n2);
		ob2.printList();

		ob2.addToList(ob1.head);
		ob2.printList();
	}
}

class Node {

	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}
