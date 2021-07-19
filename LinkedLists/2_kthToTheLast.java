// find the kth to the last elemnt in the linked list

import java.util.Scanner;

class KthToTheLast {

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

	public void kthToTheLast(int k) {
		Node front = head;
		Node back = head;

		int count = 0;
		while(count<k && front!=null) {
			front = front.next;
			count++;
		}

		if(count<k) {
			System.out.println("List length is insufficient");
			return;
		}

		while(front!=null) {
			front = front.next;
			back = back.next;
		}

		System.out.println("The kth to the last element is : "+back.data);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of elements : ");
		int n = in.nextInt();

		KthToTheLast ob = new KthToTheLast();
		ob.acceptData(n);
		ob.printList();

		System.out.print("Enter k : ");
		int k = in.nextInt();
		ob.kthToTheLast(k);
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
