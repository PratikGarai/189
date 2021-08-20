// Stack and Queue Template

class Stck<T>
{
	int capacity, top;
	T[] buffer;

	Stck(int capacity) {
		this.capacity = capacity;
		@SuppressWarnings("unchecked")
		buffer = (T[]) new Object[capacity];
		top = -1;
	}

	T peek() {
		if(top==-1)
			return null;
		else 
			return buffer[top];
	}

	T pop() {
		if(top==-1) {
			System.out.println("Empty stack, underflow");
			return null;
		} else {
			return buffer[top--];
		}
	}

	boolean push(T data) {
		if(top==capacity-1) {
			System.out.println("Full stack, overflow");
			return false;
		} else {
			buffer[++top] = data;
			return true;
		}
	}
}


class Q<T> 
{
	int capacity, head, rear;
	T[] buffer;
	
	Q(int capacity) {
		this.capacity = capacity;
		@SuppressWarnings("unchecked")
		buffer = (T[]) new Object[capacity];
		rear = -1;
		head = 0;
	}

	T peek() {
		if(rear==-1||rear==head-1) {
			System.out.println("Empty queue, underflow");
			return null;
		} else {
			return buffer[rear];
		}
	}

	T pop() {
		if(rear==-1||rear==head-1) {
			System.out.println("Empty queue, underflow");
			return null;
		} else {
			return buffer[++rear];
		}
	}

	boolean push(T data) {
		if(head==capacity) {
			System.out.println("Queue full, underflow");
			return false;
		} else {
			buffer[head++] = data;
			return true;
		}
	}
}
