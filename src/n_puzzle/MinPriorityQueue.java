package n_puzzle;

public interface MinPriorityQueue<T extends Comparable<T>> {
	public void insert(T v);

	public T deleteMin();

	public boolean isEmpty();

	public T min();

	public int size();
}
