package n_puzzle;

@SuppressWarnings("unchecked")
public class MinBinaryHeap<T extends Comparable<T>> implements MinPriorityQueue<T> {

	private T[] heap;
	private int n;

	public MinBinaryHeap() {
		this(1);
	}

	public MinBinaryHeap(T[] heap) {
		super();
		n = heap.length;
		this.heap = (T[]) new Comparable[n + 1];
		for (int i = 0; i < n; i++) {
			this.heap[i + 1] = heap[i];
		}
		for (int i = n / 2; i >= 1; i--) {
			downHeap(i);
		}
	}

	public MinBinaryHeap(int capicity) {
		heap = (T[]) new Comparable[capicity + 1];
		n = 0;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < heap.length; i++) {
			sb.append(heap[i] + " ");
		}
		return sb.toString();
	}

	@Override
	public void insert(T v) {
		// TODO Auto-generated method stub
		if (n == heap.length - 1)
			resize(2 * heap.length);
		heap[++n] = v;
		upHeap(n);
	}

	@Override
	public T deleteMin() {
		// TODO Auto-generated method stub
		T min = heap[1];
		swap(1, n--);
		downHeap(1);
		return min;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return heap.length == 0;
	}

	@Override
	public T min() {
		// TODO Auto-generated method stub
		return heap[1];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return heap.length;
	}

	private void upHeap(int k) {
		while (k > 1 && heap[k].compareTo(heap[k / 2]) < 0) {
			int index = k / 2;
			swap(k, index);
			k = index;
		}
	}

	private void downHeap(int k) {
		while (2 * k <= n) {
			int temp = 2 * k;
			if (temp < n && heap[temp].compareTo(heap[temp + 1]) > 0) {
				temp++;
			}
			if (heap[k].compareTo(heap[temp]) < 0)
				break;
			swap(temp, k);
			k = temp;
		}
	}

	private void swap(int i, int j) {
		T temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	private void resize(int newCapacity) {
		T[] temp = (T[]) new Comparable[newCapacity];
		for (int i = 0; i < heap.length; i++) {
			temp[i] = heap[i];
		}
		heap = temp;
	}
}
