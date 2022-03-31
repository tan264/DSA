package sorting;

import java.util.List;

public class InsertionSort implements SortStrategy {

	@Override
	public <T extends Comparable<T>> void sort(List<T> list) {
		// TODO Auto-generated method stub
		int n = list.size();
		for (int i = 1; i < n; i++) {
			T key = list.get(i);
			int j = i - 1;

			while (j >= 0 && list.get(j).compareTo(key) > 0) {
				list.set(j+1, list.get(j));
				j = j - 1;
			}
			list.set(j + 1, key);
		}
	}

}
