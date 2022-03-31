package sorting;

import java.util.List;

public class BubbleSort implements SortStrategy {

	@Override
	public <T extends Comparable<T>> void sort(List<T> list) {
		// TODO Auto-generated method stub
		int n = list.size();
		for (int i = n - 1; i > 0; --i) {
			for (int j = 1; j <= i; ++j) {
				if (list.get(j - 1).compareTo(list.get(j)) > 0) {
					T temp = list.get(j - 1);
					list.set(j - 1, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}

}
