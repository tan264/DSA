package sorting;

import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		// Tạo bộ bài lần đầu(dĩ nhiên là theo thứ tự sẵn)
		Deck deck = new Deck();
		System.out.println("Bộ bài ban đầu: ");
		deck.show();

		// Tráo bài
		space();
		deck.shuffle();
		System.out.println("\nBộ bài sau khi được tráo: ");
		deck.show();

		// Sắp xếp
		space();
		// Thuật toán sắp xếp mặc định là SelectionSort tăng dần
		deck.sort();
		System.out.println("\nSắp xếp lại bộ bài theo SelectionSort");
		deck.show();

		// Tráo bài
		space();
		deck.shuffle();
		System.out.println("\nBộ bài sau khi được tráo:");
		deck.show();

		// Sắp xếp
		space();
		// Thay đổi thuật toán sắp xếp -> BubbleSort
		deck.setSortStrategy(new BubbleSort());
		deck.sort();
		System.out.println("\nSắp xếp lại bộ bài theo BubbleSort");
		deck.show();

		// Tráo bài
		space();
		deck.shuffle();
		System.out.println("\nBộ bài sau khi được tráo:");
		deck.show();

		// Sắp xếp
		space();
		// Thay đổi thuật toán sắp xếp -> InsertionSort
		deck.setSortStrategy(new InsertionSort());
		deck.sort();
		System.out.println("\nSắp xếp lại bộ bài theo InsertionSort");
		deck.show();

		// Tráo bài
		space();
		deck.shuffle();
		System.out.println("\nBộ bài sau khi được tráo:");
		deck.show();

		// Sắp xếp
		space();
		// Thay đổi thuật toán sắp xếp -> MergeSort
		deck.setSortStrategy(new MergeSort());
		deck.sort();
		System.out.println("\nSắp xếp lại bộ bài theo MergeSort");
		deck.show();

		// Tráo bài
		space();
		deck.shuffle();
		System.out.println("\nBộ bài sau khi được tráo:");
		deck.show();

		// Sắp xếp
		space();
		// Thay đổi thuật toán sắp xếp -> QuickSort
		deck.setSortStrategy(new QuickSort());
		deck.sort();
		System.out.println("\nSắp xếp lại bộ bài theo QuickSort");
		deck.show();

		// Tráo bài
		space();
		deck.shuffle();
		System.out.println("\nBộ bài sau khi được tráo:");
		deck.show();

		// Sắp xếp
		space();
		// Thay đổi thuật toán sắp xếp -> HeapSort
		deck.setSortStrategy(new HeapSort());
		deck.sort();
		System.out.println("\nSắp xếp lại bộ bài theo HeapSort");
		deck.show();

		space();

		// Tạo một mảng số nguyên (Integer)
		SortedList<Integer> listIntegers = new SortedList<>();
		// Thêm các phần tử vào list
		listIntegers.add(13);
		listIntegers.add(11);
		listIntegers.add(1);
		listIntegers.add(33);
		listIntegers.add(6);
		listIntegers.add(45);
		System.out.print("Mảng ban đầu: ");
		listIntegers.print();

		// Sắp xếp
		space();
		// Thuật toán sắp xếp mặc định là SelectionSort tăng dần
		listIntegers.sort();
		System.out.print("Mảng đã được sắp xếp theo SelectionSort: ");
		listIntegers.print();

		// Trộn mảng, dùng phương thức có sẵn
		space();
		Collections.shuffle(listIntegers.getList());
		System.out.print("Mảng sau khi được tráo: ");
		listIntegers.print();

		// Sắp xếp
		space();
		// Thay đổi thuật toán sắp xếp -> BubbleSort
		listIntegers.setStrategy(new BubbleSort());
		listIntegers.sort();
		System.out.print("Mảng đã được sắp xếp theo BubbleSort: ");
		listIntegers.print();

		// Trộn mảng, dùng phương thức có sẵn
		space();
		Collections.shuffle(listIntegers.getList());
		System.out.print("Mảng sau khi được tráo: ");
		listIntegers.print();

		// Sắp xếp
		space();
		// Thay đổi thuật toán sắp xếp -> InsertionSort
		listIntegers.setStrategy(new InsertionSort());
		listIntegers.sort();
		System.out.print("Mảng đã được sắp xếp theo InsertionSort: ");
		listIntegers.print();

		// Trộn mảng, dùng phương thức có sẵn
		space();
		Collections.shuffle(listIntegers.getList());
		System.out.print("Mảng sau khi được tráo: ");
		listIntegers.print();

		// Sắp xếp
		space();
		// Thay đổi thuật toán sắp xếp -> MergeSort
		listIntegers.setStrategy(new MergeSort());
		listIntegers.sort();
		System.out.print("Mảng đã được sắp xếp theo MergeSort: ");
		listIntegers.print();

		// Trộn mảng, dùng phương thức có sẵn
		space();
		Collections.shuffle(listIntegers.getList());
		System.out.print("Mảng sau khi được tráo: ");
		listIntegers.print();

		// Sắp xếp
		space();
		// Thay đổi thuật toán sắp xếp -> QuickSort
		listIntegers.setStrategy(new QuickSort());
		listIntegers.sort();
		System.out.print("Mảng đã được sắp xếp theo QuickSort: ");
		listIntegers.print();

		// Trộn mảng, dùng phương thức có sẵn
		space();
		Collections.shuffle(listIntegers.getList());
		System.out.print("Mảng sau khi được tráo: ");
		listIntegers.print();

		// Sắp xếp
		space();
		// Thay đổi thuật toán sắp xếp -> HeapSort
		listIntegers.setStrategy(new HeapSort());
		listIntegers.sort();
		System.out.print("Mảng đã được sắp xếp theo HeapSort: ");
		listIntegers.print();

	}

	public static void space() {
		System.out.println("\t\t------------------------------");
		System.out.println("\t\t------------------------------");
	}
}
