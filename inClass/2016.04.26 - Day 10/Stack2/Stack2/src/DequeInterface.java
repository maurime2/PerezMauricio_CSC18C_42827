public interface DequeInterface<T>
{
	// returns true if the deque is empty (no items in deque) 
	// false if deque is (has at least one or more items in deque)
    public boolean isEmpty();
	
	// return the number of items currently in the deque
    public int size();
 
	// returns the value of the item currently at front of deque
	public T front();
	
	// returns the value of the item currently at the end of the deque
    public T back();
	
	// places parameter newItem onto the front of the deque
	public void push_front(T newItem);
	
	// places parameter newItem onto the end of the deque
	// // (this is synonymous to the endeque method)
    public void push_back(T newItem);
	
	// returns and removes the current item at the end of the deque
	// the item that is in the deque in front the item becomes the new end item
    public T pop_back();
	
	// returns and removes the current item at the front of the deque
	// the item that is in the deque behind the item becomes the new front item
    public T pop_front();
	
	// displays the current deque
	public void display();
	
	// iterators to implement
	// move the iterator to the beginning of the deque
	public void begin();
	
	// move the iterator to the end of the deque
	public void end();
	
	// move the iterator to the next node in the deque
	public void next();
	
	// move the iterator to the previous node in the deque
	public void previous();
	
	// return the current node data value pointed by the iterator
	public T getCurrent();
	
	// return the current node data value pointed by the iterator
	public void setCurrent(T newItem);
	
}