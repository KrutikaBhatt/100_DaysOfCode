/* This problem was asked by Amazon.
 * 
 * Implement a stack API using only a heap. A stack implements the following methods:
 * 
 * -push(item), which adds an element to the stack
 * -pop(), which removes and returns the most recently added element (or throws an error if there is nothing on the stack)
 * 
 * Recall that a heap has the following operations:
 * -push(item), which adds a new key to the heap
 * -pop(), which removes and returns the max value of the heap
 */

import java.util.*;

// Class that defines the structure of each element in stack

class stackElements{
	int key;
	int data;
	
	stackElements(int key,int data){
		this.key = key;
		this.data = data;
	}
}


class stackHeap{
	
	// Create a Priority Queue that compares and places the element according to key
	PriorityQueue<stackElements> heap = new PriorityQueue<>(new Comparator<stackElements>() {
		
		public int compare(stackElements e1,stackElements e2) {
			return e2.key - e2.key;
		}
	});
	
	// Writing functions to push and pop
	
	int top = -1;   // Reference variable
	
	public void push(int data) {
		heap.add(new stackElements(top++,data));
	}
	
	public Integer pop() {
		
		if(top == -1) {
			return null;
		}
		
		top--;
		return heap.poll().data;
	}
	
	// Also implemented Peek 
	
	public Integer peek() {
		if(top == -1) {
			return null;
		}
		return heap.peek().data;
	}
}

public class Day22 {

	public static void main(String[] args) {
		stackHeap stack = new stackHeap();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Peek : "+stack.peek());

        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        
        
	}

}
