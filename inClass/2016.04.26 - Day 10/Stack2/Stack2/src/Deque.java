public class Deque<T> implements DequeInterface<T>
{
	// linked list containing the items in the deque
	private Node<T> head=null, tail=null, iterator=null;
	
	// current number of items in deque
	private int numberOfItems;
	
	// Deque constructor that starts with empty deque.
	public Deque()
	{
		numberOfItems=0; // no items yet!
	}
	
	// displays current contents of the deque
	public void display()
	{
		Node current=head;
		for(int i=0;i<numberOfItems;i++)
		{
			System.out.print(current.getValue()+" ");
			current=current.getNext();
			if ( current==null ) break;
		}	
	}
	
	// ----- functions/methods in the interface that must be implemented -----
	
	// returns true if the deque is empty (no items in deque) 
	// false if deque is (has at least one or more items in deque)
    public boolean isEmpty()
	{
		return numberOfItems==0;
	}
	
	// return the number of items currently in the deque
    public int size()
	{
		return numberOfItems;
	}
 
	// returns the value of the item currently at front of deque
	public T front()
	{
		return head.getValue(); // return item stored at head node
	}
	
	// returns the value of the item currently at the end of the deque
    public T back()
	{
		return tail.getValue(); // return item stored at tail node
	}
	
	// places parameter item onto the end of the deque
    public void push_back(T newItem)
	{
		// if head node is null, make head and tail node contain the first node
		if ( head == null)
		{
			head = new Node(newItem);
			tail=head; // when first item is endequed, head and tail are the same
			iterator=head; // iterator starts off at the head when deque is first created
			numberOfItems++; // increment the number of items in the deque
		}
		else
		{
			Node<T> newNode = new Node(newItem);
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail=newNode;
			numberOfItems++;
		}
	}
	
	// returns and removes the current item at the front of the deque
	// the item that is in the deque behind the item becomes the new front item
    public T pop_front()
	{
		T headDataValue = null;
		if ( numberOfItems > 0 )
		{
			headDataValue = head.getValue();
			Node<T> oldHead=head;
			head=head.getNext();
			oldHead.setNext(null);
                        if ( head != null) head.setPrevious(null);
			numberOfItems--;
		}
		return headDataValue;  // returns the data value from the popped head, null if deque empty
	}
	
	// places parameter newItem onto the front of the deque
	public void push_front(T newItem)
	{
		if ( head == null)
		{
			head = new Node(newItem);
			tail=head; // when first item is endequed, head and tail are the same
			iterator=head; // iterator starts off at the head when deque is first created
			numberOfItems++; // increment the number of items in the deque
		}
		else
		{
			Node<T> newNode = new Node(newItem);		
			head.setPrevious(newNode);
			newNode.setNext(head);			
			head=newNode;
			iterator=head; // iterator starts off at the head when deque is first created
			numberOfItems++;
		}
	}
	
	// returns and removes the current item at the end of the deque
	// the item that is in the deque in front the item becomes the new end item
    public T pop_back()
	{
		T tailDataValue = null;
		if ( numberOfItems > 0 )
		{
			tailDataValue = tail.getValue();
			Node<T> oldTail = tail;
			tail = oldTail.getPrevious();
			oldTail.setPrevious(null);
			numberOfItems--;
		}
		return tailDataValue;
	}
	
	// iterators to implement
	// move the iterator to the beginning of the deque
	public void begin()
	{
		iterator=head; // put iterator back at head
	}
	
	// move the iterator to the end of the deque
	public void end()
	{
		iterator=tail; // put iterator at the end of deque
	}
	
	// move the iterator to the next node in the deque
	public void next()
	{
		if ( iterator.getNext() != null ) iterator=iterator.getNext();
		// if we want to do a circular queue/deque, we could set the iterator back to head here
	}
	
	// move the iterator to the previous node in the deque
	public void previous()
	{
		if ( iterator.getPrevious() != null ) iterator=iterator.getPrevious();
		// if we want to do a circular queue/deque, we could set the iterator back to tail here
	}
	
	// return the current node data value pointed by the iterator
	public T getCurrent()
	{
		return iterator.getValue();
	}
	
	// set the current iterator node's data value to newItem
	public void setCurrent(T newItem)
	{
		iterator.setValue(newItem);
	}
	
	// Node Inner Class
    private class Node<T> {
        private T value;
        private Node _previous, _next;
    
        public Node(T data) {
            value = data;
            _previous = null;
            _next = null;
        }
    
        protected Node(T data, Node previousNode, Node nextNode) {
            value = data;
            _previous = previousNode;
            _next = nextNode;
        }
		
        public Node getNext() {
            return _next;
        }
		
	public Node getPrevious() {
            return _previous;
        }
        
	public void setValue(T newValue)
	{
            value=newValue;
	}

        public T getValue() {
            return value;
        }
    
        public void setNext(Node newNextNode) {
            _next = newNextNode;
        }
		
	public void setPrevious(Node newPreviousNode) {
            _previous = newPreviousNode;
        }
    }
}