package sorting;

import java.util.List;

public class SelectionSort implements SortStrategy {

	@Override
	public <T extends Comparable<T>> void sort(List<T> list) {
		// TODO Auto-generated method stub
		int minIndex = -1;
		for (int i = 0; i < list.size() - 1; ++i) {
			minIndex = i;
			for (int j = i + 1; j < list.size(); ++j) {
				if (list.get(j).compareTo(list.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			T temp = list.get(i);
			list.set(i, list.get(minIndex));
			list.set(minIndex, temp);
		}
	}

}
