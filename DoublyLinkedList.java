package arraylist;

// 이중 연결 리스트
import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {
	private int size;
	private Node<E> head;
	private Node<E> tail;
	
	private class Node<E> {
		private Node<E> next;
		private Node<E> prev;
		private E data;
		
		private Node(E element) {
			this.data = element;
			this.next = null;
			this.prev = null;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public void add(E element) {
		Node<E> newNode = new Node<E>(element);
		if(head == null) {
			head = tail = newNode;
		}else {
			tail.next  = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}

	@Override
	public void add(int index, E element) {
		checkBoundInclusive(index);
		
		if(index == size) {
			add(element);
			
			return;
		} 
		
		Node<E> newNode = new Node<E>(element);
		
		Node<E> x = head;
		for(int i = 0; i < index; i++) {
			x = x.next;
		}
		
//		x.next = newNode.prev;
//		newNode.next = x.next.prev; 
		
		if(index == 0) {
			newNode.prev = x.prev;
			x.prev = newNode; // (?)
			newNode.next = x;
			head = newNode;
		} else {
			x.prev.next = newNode;
			newNode.prev = x.prev;
			newNode.next = x;
			x.prev = newNode;
		}
		size++;
	}

	@Override
	public E get(int index) {
		
		checkBoundInclusive(index);
		
//		head 넣은 이유: 처음부터 쭉 돌아가겠다는 의미
		Node<E> x = head;
		for(int i = 0; i < index; i++) {
			x = x.next;
		}
		
		return x.data;
	}

	@Override
	public E remove(int index) {
		
		checkBoundInclusive(index);
		
		Node<E> x = head;
		
		 while( x != null ){
			 Node<E> next = x.next;
			 Node<E> next2 = next.next;
			 
			 
			 for(int i = 0; i < index; i++) {
					x = x.next;
				}
			 
			 x.next = null;
			 next = next2.prev;
			 
		    }
		 
		  head = null;
		  tail = null;
		  size = 0;
		
		return null;
	}

	@Override
	public void removeAll() {
	
		Node<E> x = head;
		
		// 처음에 데이터가 아예 없을 수도 있으니까
	    while( x != null ){
	       Node<E> next = x.next;
	       x.next = null;
	       x.prev = null;
	       x = next;
	    }
	    head = null;
	    tail = null;
	    size = 0;
	}

	@Override
	public int size() {
		return size;
	}
	
	
	private void checkBoundInclusive(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
		}
	}

	private void checkBoundExclusive(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
		}
	}

}
