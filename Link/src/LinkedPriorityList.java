/**
 * This collection class implements an abstract data type to store elements
 * where indexes represent priorities that can change in several ways.
 * 
 * @author Rick Mercer
 * @param <E>
 *            The type of all elements stored in this collection
 */
public class LinkedPriorityList<E> implements PriorityList<E> {

	// This private inner class saves lots of typing and is hidden from
	// outsiders
	private class Node {

		// These instance variables can be accessed from the enclosing class
		private E data;
		private Node next;

		// If you don't use this constructor in this class, delete it before
		// submitting to WebCat to avoid losing points for code coverage.
	

		// If you don't use this constructor in this class, delete it before
		// submitting to WebCat to avoid losing points for code coverage.
		public Node(E element, Node link) {
			data = element;
			next = link;
		}
	}

	// These instance variables belong to the enclosing class
	private Node first;
	private int size;

	// Create an empty list with zero elements
	public LinkedPriorityList() {
		first = null;
		size = 0;
	}

	/**
	 * Return the number of elements currently in this PriorityList
	 * 
	 * @return The number of elements in this PriorityList
	 */
	public int size() {
		// TODO: Make this method work correctly
		return size;
	}

	/**
	 * Return true if there are zero elements in this PriorityList *
	 * 
	 * @return true if size() == 0 or false if size() > 0
	 */
	public boolean isEmpty() {

		return first == null;
	}

	/**
	 * If possible, insert the element at the given index. If index is out of
	 * range, throw new IllegalArgumentException();. For example, when size is
	 * 3, the only possible values for index are 0, 1, 2, and 3.
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @param el
	 *            The element to insert
	 * @throws IllegalArgumentException
	 */
	public void insertElementAt(int index, E el)
			throws IllegalArgumentException {
		if (index < 0 || index >this.size())
			throw new IllegalArgumentException(""+index);
		if (index == 0) {
			first = new Node(el, first);
			size++;
		} else {
			Node ref = first;
			for(int i=0;i<index-1;i++) 
				ref = ref.next;
			
			ref.next = new Node(el, ref.next);
			size++;
		}
	}

	/**
	 * If possible, return a reference to the element at the given index. If
	 * index is out of range, throw new IllegalArgumentException(); When size is
	 * 3, the only possible values for index are 0, 1, and 2.
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @return A reference to to element at index index.
	 * @throws IllegalArgumentException
	 */
	public E getElementAt(int index) throws IllegalArgumentException {
		if (index < 0 || index >=this.size())
			throw new IllegalArgumentException("" + index);
		Node ref = first;
		for (int i = 0; i < index; i++)
			ref = ref.next;
		return ref.data;
	}

	/**
	 * If possible, remove the element at the given index. If index is out of
	 * range, throw new IllegalArgumentException();
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void removeElementAt(int index) throws IllegalArgumentException {
		if (index < 0 || index >= this.size())
			throw new IllegalArgumentException("" + index);
		Node ref = first;
		for (int i = 0; i < index; i++)
			ref = ref.next;
		for (int i = index; i <size()-1; i++){
			ref.data = ref.next.data;
			ref=ref.next;
		}
		size--;
	}

	/**
	 * If possible, swap the element located at index with the element at
	 * index+1. An attempt to lower the priority of the element at index
	 * size()-1 has no effect. If index is out of range, throw new
	 * IllegalArgumentException();
	 * 
	 * @param index
	 *            The index of the element to move
	 * @throws IllegalArgumentException
	 */
	public void lowerPriorityOf(int index) throws IllegalArgumentException {
		if (index < 0 || index >=this.size())
			throw new IllegalArgumentException("" + index);
			Node ref = first;
			for (int i = 0; i < index; i++)
				ref = ref.next;
			E temp=ref.data;
			ref.data=ref.next.data;
			ref.next.data=temp;
	}

	/**
	 * If possible, swap the element located at index with the element at
	 * index-1. An attempt to raise the priority at index 0 has no effect. If
	 * index is out of range, throw new IllegalArgumentException();
	 * 
	 * @param index
	 *            The index of the element to move
	 * @throws IllegalArgumentException
	 */
	public void raisePriorityOf(int index) throws IllegalArgumentException {
		if (index < 0 || index >= this.size())
			throw new IllegalArgumentException("" + index);
			Node ref = first;
			for (int i = 0; i <index-1; i++)
				ref = ref.next;
			E temp=ref.data;
			ref.data=ref.next.data;
			ref.next.data=temp;
	}

	/**
	 * Return a copy of all elements as an array of Objects that is the size of
	 * this PriorityList and in the same order. If there are no elements in this
	 * list, return new Object[0];. A change to the return value must not affect
	 * this ArrayPriorityList object.
	 * 
	 * @return An array of Objects where capacity == size()
	 */
	public Object[] toArray() {
		if (isEmpty()) {
			return new Object[0];
		} else {
			Object[] Jack = new Object[size()];
			Node ref = first;
			for (int i = 0; i < size(); i++) {
				Jack[i] = ref.data;
				ref = ref.next;
			}
			return Jack;
		}
	}

	/**
	 * If possible, move the element at the given index to the end of this list.
	 * An attempt to move the last element to the last has no effect. If the
	 * index is out of range, throw new IllegalArgumentException();
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void moveToLast(int index) throws IllegalArgumentException {
		if (index <0 || index >=this.size())
			throw new IllegalArgumentException("" + index);
		Node ref = first;
		for (int i = 0; i < index; i++){
			ref = ref.next;
			}
			E temp=ref.data;
		for(int i=index;i<=size()-2;i++)
			{
			ref.data=ref.next.data;
			ref=ref.next;
			}
		ref.data=temp;
	}

	/**
	 * If possible, move the element at the given index to the front of this
	 * list. An attempt to move the top element to the top has no effect. If the
	 * index is out of range, throw new IllegalArgumentException();
	 * 
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void moveToTop(int index) throws IllegalArgumentException {
		if (index <0 || index >=this.size())
			throw new IllegalArgumentException("" + index);
		Node ref = first;
		for (int i = 0; i < index; i++){
			ref = ref.next;
			}
			E temp=ref.data;
			
			insertElementAt(0,temp);
			removeElementAt(index+1);
	}
}