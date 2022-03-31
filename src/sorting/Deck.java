package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	final String[] TYPE = { "♠️", "♣️", "♦️", "♥️" };
	final String[] ORDER = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "Át", "2" };

	private List<Card> listCards;
	private SortStrategy strategy = new SelectionSort();

	public Deck() {
		super();
		listCards = new ArrayList<>();
		// Tạo bộ bài gồm 52 lá bài
//		for (int i = 0; i < ORDER.length; ++i) {
//			for (int j = 0; j < TYPE.length; ++j) {
//				listCards.add(new Card(TYPE[j], ORDER[i]));
//			}
//		}
		//Code phía trên cần lặp ORDER.length * TYPE.length lần, còn code phái dưới chỉ cần lặp ORDER.length lần
		for(int i = 0; i < ORDER.length; ++i) {
			listCards.add(4 * i, new Card(TYPE[0], ORDER[i]));
			listCards.add(4 * i + 1, new Card(TYPE[1], ORDER[i]));
			listCards.add(4 * i + 2, new Card(TYPE[2], ORDER[i]));
			listCards.add(4 * i + 3, new Card(TYPE[3], ORDER[i]));
		}
	}

	public List<Card> getListCards() {
		return listCards;
	}

	public void setSortStrategy(SortStrategy strategy) {
		this.strategy = strategy;
	}

	public void sort() {
		strategy.sort(listCards);
	}

	public void show() {
		if (listCards.size() == 52) {
			for (Card card : listCards) {
				System.out.println(card);
			}
		} else {
			System.out.println("Không đủ 52 lá bài");
		}
	}

	public void shuffle() {
		Collections.shuffle(listCards);
	}

	class Card implements Comparable<Card> {

		private String type;
		private String order;

		public Card(String type, String order) {
			super();
			this.type = type;
			this.order = order;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getOrder() {
			return order;
		}

		public void setOrder(String order) {
			this.order = order;
		}

		@Override
		public String toString() {
			return order + " " + type;
		}

		private int indexOf(int a, String s) {
			/*
			 * Hàm nhận vào 2 tham số: số nguyên a và chuỗi s a = 0 thì trả về thứ hạng của
			 * chất lá bài đó trong 4 chất a = 1 thì trả về thứ hạng của lá bài theo số s
			 * được truyền vào là chất của lá bài hoặc thứ tự của lá bài
			 */
			if (a == 0) {
				for (int i = 0; i < TYPE.length; ++i) {
					if (TYPE[i].equals(s)) {
						return i;
					}
				}
			} else if (a == 1) {
				for (int i = 0; i < ORDER.length; ++i) {
					if (ORDER[i].equals(s)) {
						return i;
					}
				}
			}
			return -1;
		}

		@Override
		public int compareTo(Card o) {
			// TODO Auto-generated method stub
			// Nếu 2 lá bài cùng thứ tự thì xét chất
			if (order.equals(o.getOrder())) {
				return this.indexOf(0, this.getType()) - o.indexOf(0, o.getType());
			} else {
				// Nếu không thì xét theo thứ tự bình thường
				return this.indexOf(1, this.getOrder()) - o.indexOf(1, o.getOrder());
			}

		}

	}
}
