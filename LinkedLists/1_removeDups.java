// Remove duplicates from a linked list, using buffer and without buffer\

import java.util.Scanner;
import java.util.HashSet;

class RemoveDuplicates {

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

	public void printList(int n) {
		if(head==null) {
			System.out.println("List is empty");
			return;
		}

		Node current = head;
		while(current!=null) 
			System.out.print(current.data+" -> ");
		System.out.println("end");
	}

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of elements : ");
		int n = in.nextInt();

		RemoveDuplicates ob = new RemoveDuplicates();
		ob.acceptData(n);
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
