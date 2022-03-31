package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements SortStrategy {
	private <T extends Comparable<T>> void merge(List<T> a, List<T> b, int u, int m, int v) {

		for (int k = u; k <= v; k++) {
			b.set(k, a.get(k));
		}
		int i = u;
		int j = m + 1;
		for (int k = u; k <= v; k++) {
			if (i > m)
				a.set(k, b.get(j++));
			else if (j > v)
				a.set(k, b.get(i++));
			else if (b.get(j).compareTo(b.get(i)) < 0)
				a.set(k, b.get(j++));
			else
				a.set(k, b.get(i++));
		}
	}

	private <T extends Comparable<T>> void sort(List<T> a, List<T> b, int u, int v) {
		if (v <= u)
			return;
		int m = u + (v - u) / 2;
		sort(a, b, u, m);
		sort(a, b, m + 1, v);
		merge(a, b, u, m, v);
	}

	@Override
	public <T extends Comparable<T>> void sort(List<T> list) {
		// TODO Auto-generated method stub
		List<T> b = new ArrayList<>(list.size());
		for (int i = 0; i < list.size(); i++) {
			b.add(null);
		}
		sort(list, b, 0, list.size() - 1);
	}
}
