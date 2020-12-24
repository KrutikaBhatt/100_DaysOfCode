/* This problem was asked by Google.
 * Given the head of a singly linked list, swap every two nodes and return its head.
 * For example, given 1 -> 2 -> 3 -> 4, return 2 -> 1 -> 4 -> 3
 */

// Creating basic structure for elements in linked list
class Node{
	
	int data;
	Node next;
	
	public Node(int data) {
		
		this.data =data;
		this.next = null;
		
	}
}

public class Day16 {
	
	
	
	public static Node swapNodes(Node head) {
		
		// Temporory Node for Transversing the List 
		Node temp= new Node(-1);
		temp.next = head;
		
		//Since after the method is performed - head->1->2->3->4
		// The second element will be the swapped with the first 
		// Making the second node as head
		// Thus making head point to the second node
		
		head = head.next;
		
		while(temp!=null && temp.next!=null) {
			
			// first = 1(first)->2->3->4
			Node first = temp.next;
			
			// Second = 1->(second)2->3->4
			Node second = temp.next.next;
			
			// first= 1(first)->3->4
			first.next= first.next.next;
			
			// second= 2(second)->1(first)->3->4
			second.next= first;
			
			// temp= -1(head)->2(second)->1(first)->3->4
			temp.next= second;

			// temp= 1(head)->3->4
			temp= temp.next.next;
		}
		
		return head;
		
	}
	
	// Display the linked list
	public static void display(Node head)
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data);
			if(temp.next!=null)
				System.out.print("-> ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next= new Node(3);
		head.next.next.next= new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		
		
		System.out.println("---- Original List ----");
		display(head);
		
		System.out.println(" ---- Swapped List ----");
		
		Node swapedList = swapNodes(head);
		display(swapedList);
		
		
		
		
		

	}

}
