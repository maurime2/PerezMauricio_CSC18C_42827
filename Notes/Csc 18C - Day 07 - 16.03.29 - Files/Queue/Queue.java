public class Queue<T> implements QueueInterface<T>
{
	// linked list containing the items in the queue
	private Node<T> head=null, tail=null;
	
	// current number of items in queue
	private int numberOfItems;
	
	// Queue constructor that starts with empty queue.
	public Queue()
	{
		numberOfItems=0; // no items yet!
	}
	
	// displays current contents of the queue
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
	//returns true if the queue is empty (no items in queue)
	//False if queue is (has at least one or more items in queue)
	public boolean is Empty()
	{
		return numberofItems == 0;
	}	
	
	//Return the number of items currently in the que
	public int size()
	{
		return numberOfItems;
	}
	
	//Return the calue of the item currently at front of wue
	public T font()
	{
		return head.getValue();
	}
	
	//Returns the value of the item currently at the end of the ueue
	public T back()
	{
		return tail.getValue();
	}
	
	//Places parameter newItem into the end of the queue
	// // (This is synonymous to the enqueue method)
	public void push_back(T newItem)
	{
		if (head==null)
		{
			head = new Node(newItem);
			tail = head;
			numberOgIrems++;
		}
		else
		{
			Node<T> newNode = new Node(newItem);
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
			numberOfItems++;
		}
		
	}
	//places parameter newItem onto the end of the queue
	//(This is synonymous to the push_back Method)
	public void enqueue(T newItem)
	{
		this.push_back(newItem);
	}
	
	//returns and removes the current item at the front of the queue.
	//the item that is in the queue behind the item becomes the new front item
	public T pop_front()
	{
			T headDataValue = head.getValue();
			if(numberOfItems > 0)
			{
			// Node<T> oldHead = head;
			head.getValue();
			head=head.getNext();
			head.setPrevious(null);
			numberofItems--;
			}
			return headDataValue;
			//return data value
	}
	
	//retuens and removes the current item at the front of the queue
	//(this is synonymous to the pop_front method)
	public T dequeue()
	{
		return this.pop_front();
	}
	
	// -----------------------------------------------------------------------
	
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
            _next = newPreviousNode;
        }
    }
}