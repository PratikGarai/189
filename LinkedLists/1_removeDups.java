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

	public void removeDupicatesWithBuffer() {
		if(head==null)
			return;

		HashSet<Integer> h = new HashSet<Integer>();
		h.add(head.data);
		Node prev = head;
		Node curr = head.next;

		while(curr!=null) {
			if(h.contains(curr.data)) {
				prev.next = curr.next;
				curr = curr.next;
			} else {
				h.add(curr.data);
				prev = prev.next;
				curr = curr.next;
			}
		}
	}

	public void removeDupicatesWithoutBuffer() {
		if(head==null)
			return;

		Node base = head;
		Node prev = head;
		Node curr = head.next;

		while(base.next!=null) {
			while(curr!=null) {
				if(curr.data==base.data) {
					prev.next = curr.next;
					curr = curr.next;
				} else {
					prev = prev.next;
					curr = curr.next;
				}
			}

			prev = base.next;
			base = base.next;
			if(base==null)
				break;
			curr = base.next;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of elements : ");
		int n = in.nextInt();

		RemoveDuplicates ob = new RemoveDuplicates();
		ob.acceptData(n);
		ob.printList();
		// ob.removeDupicatesWithBuffer();
		ob.removeDupicatesWithoutBuffer();
		ob.printList();
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
