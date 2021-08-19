// Check if inkedlist is palindrome or not

import java.util.Scanner;

class Template {

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


	public Result checkPalindrome(Node node) {
		if(node==null) {
			return new Result(head, true);
		} else {
			Result res = checkPalindrome(node.next);
			if(!res.result)
				return res;
			else {
				if(node.data==res.node.data)
					return new Result(res.node.next, true);
				else 
					return new Result(res.node, false);
			}
		}
	}


	public boolean checkPalindromeDriver(Node node) {
		Result res = checkPalindrome(node);
		return res.result;
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of elements : ");
		int n = in.nextInt();

		Template ob = new Template();
		ob.acceptData(n);
		ob.printList();
		ob.printList(ob.head);
		System.out.println("Is palindrome : "+ob.checkPalindromeDriver(ob.head));
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

class Result {
	Node node;
	boolean result;

	public Result(Node node, boolean result) {
		this.node = node;
		this.result = result;
	}
}
