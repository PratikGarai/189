// Stack and Queue Template

import java.util.Scanner;

public class sq_template {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Stack<Integer> stack = new Stack<Integer>(5);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.printStack();
		System.out.println("Popping : " + stack.pop());
		stack.printStack();

		Queue<String> queue = new Queue<String>(5);
		queue.enqueue("Abc");
		queue.enqueue("Def");
		queue.enqueue("Ghi");
		queue.printQueue();
		System.out.println("Dequeuing : " + queue.dequeue());
		queue.printQueue();
	}
}

class Stack<T>
{
	int capacity, top;
	T[] buffer;

	Stack(int capacity) {
		this.capacity = capacity;
		buffer = (T[]) new Object[capacity];
		top = -1;
	}

	boolean isEmpty() {
		return top==-1; 
	}

	boolean isFull() {
		return top==capacity-1;
	}

	T peek() {
		if(isEmpty())
			return null;
		else 
			return buffer[top];
	}

	T pop() {
		if(isEmpty()) {
			System.out.println("Empty stack, underflow");
			return null;
		} else {
			return buffer[top--];
		}
	}

	boolean push(T data) {
		if(isFull()) {
			System.out.println("Full stack, overflow");
			return false;
		} else {
			buffer[++top] = data;
			return true;
		}
	}

	void printStack() {
		System.out.print("Bottom -> ");
		for(int i=0; i<=top; i++) {
			System.out.print(buffer[i]+" -> ");
		}
		System.out.println("Top");
	}
}


class Queue<T> 
{
	int capacity, head, rear;
	T[] buffer;
	
	Queue(int capacity) {
		this.capacity = capacity;
		buffer = (T[]) new Object[capacity];
		rear = -1;
		head = 0;
	}

	boolean isEmpty() {
		return rear==head-1;
	}

	boolean isFull() {
		return head==capacity;
	}

	T peek() {
		if(isEmpty()) {
			System.out.println("Empty queue, underflow");
			return null;
		} else {
			return buffer[rear];
		}
	}

	T dequeue() {
		if(isEmpty()) {
			System.out.println("Empty queue, underflow");
			return null;
		} else {
			return buffer[++rear];
		}
	}

	boolean enqueue(T data) {
		if(isFull()) {
			System.out.println("Queue full, underflow");
			return false;
		} else {
			buffer[head++] = data;
			return true;
		}
	}

	void printQueue() {
		System.out.print("Rear -> ");
		for(int i=rear+1; i<head; i++) {
			System.out.print(buffer[i]+" -> ");
		}
		System.out.println("Front");
	}
}
