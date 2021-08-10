// Take a value n, then rearrage the linked list in a way that values less than n
// occur before n and values greater than n occur afte n in the list

import java.util.Scanner;

class Partition {

	Node head;
	Node last;

	// List of smaller stuff
	Node head2;
	Node last2;

	// List of bigger stuff
	Node head3;
	Node last3;

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

	public Node getPartitioned(int element) {
		if(head==null)
			return head;
		
		int counts = 0;
		Node curr = head;
		while(curr != null)
		{
			int d = curr.data;
			if(d < element) {
				// System.out.println(d+" to list 2");
				if(head2 == null) {
					head2 = new Node(d);
					last2 = head2;
				}
				else {
					last2.next = new Node(d);
					last2 = last2.next;
				}
			} else if(d == element) {
				counts++;
			} else {
				// System.out.println(d+" to list 3");
				if(head3 == null) {
					head3 = new Node(d);
					last3 = head3;
				}
				else {
					last3.next = new Node(d);
					last3 = last3.next;
				}
			}
			curr = curr.next;
		}

		for(int i=0;i<counts;i++) {
			if(head2==null) {
				head2 = new Node(element);
				last2 = head2;
			}
			else {
				last2.next = new Node(element);
				last2 = last2.next;
			}
		}

		if(head2==null)
			return head3;
		
		last2.next = head3;
		return head2;
	}

	public void printResult(Node head) {
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


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of elements : ");
		int n = in.nextInt();

		Partition ob = new Partition();
		ob.acceptData(n);
		ob.printList();

		System.out.print("Enter the partition element : ");
		int ele = in.nextInt();
		Node result = ob.getPartitioned(ele);
		ob.printResult(result);
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
