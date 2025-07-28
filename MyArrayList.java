package arraylist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyArrayList<E> implements List<E> {
	private int size;
	private E[] data;

	private void resize() {
		if (size == 0) {
			// generic 타입이라 들어갈 변수가 double인지 int인지 모르니까 !! new E(); 선언 안됨
			data = (E[]) new Object[10];
		} else {
			E[] newData = (E[]) new Object[size + 10];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}

	public MyArrayList() {
		size = 0;
		resize();
	}

	// 현재 배열에 뒷부분 내용을 추가하는 것
	@Override
	public void add(E element) {
		if (data.length == size) {
			resize();
		}
		data[size++] = element;
	}

	@Override
	public void add(int index, E element) {
//		size: 실제 항목의 개수
		checkBoundInclusive(index);
		if (size == data.length) {
			resize();
		}
		if (index != size) {
			System.arraycopy(data, index, data, index + 1, size - index);
		}
		data[index] = element;
		size++;

	}

	@Override
	public E get(int index) {
		checkBoundExclusive(index);
		return data[index];
	}

	@Override
	public E remove(int index) {
		checkBoundExclusive(index);
		E r = data[index];
		if (index != --size) {
			System.arraycopy(data, index + 1, data, index, size - index);
		}

		return r;
	}

	@Override
	public void removeAll() {
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

//	확장 for문을 만들 수 있는 객체를 만든 것
	@Override
	public Iterator<E> iterator() {

		return new Iterator<E>() {
//			pointer역할: ps
			private int pos = 0;
			private int size = size();

			// next가 작동하는 구간 정의
			@Override
			public boolean hasNext() {
				return pos < size;
			}

//			값을 저장하고 pos를 다음 위치로 옮긴다.			
			@Override
			public E next() {
				// hasNext 사용하지 못할 때의 안전장치
				if(pos >= size) {
					throw new NoSuchElementException();
				}
				return data[pos++];
			}

	
		};

	}
	
}
