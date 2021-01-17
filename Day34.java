// Given a linked list and a positive integer k, rotate the list to the right by k places.

// For example, given the linked list 7 -> 7 -> 3 -> 5 and k = 2, it should become 3 -> 5 -> 7 -> 7.
// Given the linked list 1 -> 2 -> 3 -> 4 -> 5 and k = 3, it should become 3 -> 4 -> 5 -> 1 -> 2.


// Class that defines the linked list
class listNode{
	
	int data;
	listNode Nextnode;
	
	listNode(int data){
		this.data = data;
		Nextnode = null;
	}
}

public class Day34 {
	
	public static listNode rotateRight(listNode start,int k) {
		
		//Check if node is null or the LinkedList contains only one node
		if(start == null || start.Nextnode ==null) {
			return null;
		}
		
		if(k == 0) {
			return start;
		}
		
		if(start==null || start.Nextnode==null)
			return null;
		
		// len is used to store length of the linked list
	    // tmp will point to the last node after this loop
		listNode tmp = start;
		int len =1;
		while(tmp.Nextnode!=null) {
			
			tmp = tmp.Nextnode;
			len++;
		}
		
		//if k is greater than length of list
		if(k>len) {
			k = k%len;
		}
		
		 //Subtract from length to convert it into left rotation
		    k = len - k;
		
		if(k == len)
			return start;
		
		listNode current = start;
		int count = 1;
		
		while(count <k && current!=null) {
			
			current =current.Nextnode;
			count ++;
		}
		
		if(current == null)
			return start;
		
		// current points to the kth node
	    listNode kthnode = current;
	 
	    // Change next of last node to previous head
	    tmp.Nextnode = start;
	 
	    // Change head to (k+1)th node
	    start = kthnode.Nextnode;
	 
	    // Change next of kth node to null
	    kthnode.Nextnode = null;
	 
	    // Return the updated head pointer
	    return start;
	}
	
	 static void printList(listNode head)
	    {
		 listNode temp = head;
	        while (temp != null) {
	            System.out.print(temp.data + " ");
	            temp = temp.Nextnode;
	        }
	        System.out.println();
	    }
	 
	public static void main(String[] args) {
		
		
		listNode start = new listNode(-1);
		start.Nextnode = new listNode(1);
		start.Nextnode.Nextnode = new listNode(2);
		start.Nextnode.Nextnode.Nextnode = new listNode(3);
		start.Nextnode.Nextnode.Nextnode.Nextnode = new listNode(4);
		start.Nextnode.Nextnode.Nextnode.Nextnode.Nextnode = new listNode(5);
		
		System.out.println("The original list is -");
		printList(start);
		start = rotateRight(start,4);
		
		System.out.println("The rotated list is -\n");
		printList(start);
	}

}
