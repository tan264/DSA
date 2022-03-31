package sorting;

import java.util.List;

public class SelectionSort implements SortStrategy {

	@Override
	public <T extends Comparable<T>> void sort(List<T> list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size() - 1; ++i) {
			for (int j = i + 1; j < list.size(); ++j) {
				if (list.get(i).compareTo(list.get(j)) > 0) {
					T temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}

}
