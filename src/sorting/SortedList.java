package sorting;

import java.util.ArrayList;
import java.util.List;

public class SortedList<T extends Comparable<T>> {

	private SortStrategy strategy = new SelectionSort();
	private List<T> list = new ArrayList<T>();

	public void setStrategy(SortStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void print() {
		for(T value : list) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void add(T value) {
		list.add(value);
	}

	public List<T> getList() {
		return list;
	}

	public void sort() {
		strategy.sort(list);
	}

}
