package sorting;

import java.util.List;

public class HeapSort implements SortStrategy {

	class BinaryHeap<T extends Comparable<T>> {

		private T[] heap;
		private int n;

		public BinaryHeap(List<T> list) {
			n = list.size();
			heap = (T[]) new Comparable[n + 1];
			int index = 1;
			for (T temp : list) {
				heap[index] = temp;
				index++;
			}
			for (int i = n / 2; i >= 1; i--) {
				downHeap(i);
			}
		}

		public T[] getBinaryHeap() {
			return heap;
		}

		public void downHeap(int k) {
			while (2 * k <= n) {
				int index = 2 * k;
				if (index < n && heap[index].compareTo(heap[index + 1]) < 0)
					index++;
				if (heap[k].compareTo(heap[index]) > 0)
					break;
				swap(k, index);
				k = index;
			}
		}

		public void downHeap(int k, int n) {
			while (2 * k <= n) {
				int index = 2 * k;
				if (index < n && heap[index].compareTo(heap[index + 1]) < 0)
					index++;
				if (heap[k].compareTo(heap[index]) > 0)
					break;
				swap(k, index);
				k = index;
			}
		}

		public void swap(int i, int j) {
			T temp = heap[i];
			heap[i] = heap[j];
			heap[j] = temp;
		}

		public void heapSort() {
			while (n > 1) {
				swap(1, n);
				n--;
				downHeap(1, n);
			}
		}
	}

	@Override
	public <T extends Comparable<T>> void sort(List<T> list) {
		// TODO Auto-generated method stub
		BinaryHeap<T> a = new BinaryHeap<>(list);
		a.heapSort();
		T[] result = a.getBinaryHeap();
		int index = 1;
		for (int i = 0; i < list.size(); i++) {
			list.set(i, result[index++]);
		}
	}

}
