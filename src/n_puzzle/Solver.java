package n_puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solver {

	private Board initial;
	private Board goal;
	private MinPriorityQueue<SearchNode> minPriorityQueue;
	private MinPriorityQueue<SearchNode> minPriorityQueueTwin;

	public Solver(Board initial) {
		this.initial = initial;
		int n = initial.dimension();
		minPriorityQueue = new MinBinaryHeap<SearchNode>();
		minPriorityQueue.insert(new SearchNode(initial, 0, null));
		minPriorityQueueTwin = new MinBinaryHeap<SearchNode>();
		minPriorityQueueTwin.insert(new SearchNode(initial.twin(), 0, null));

		int[][] blocks = new int[n][n];
		int k = 1;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				blocks[i][j] = k;
				k++;
			}
		blocks[n - 1][n - 1] = 0;
		goal = new Board(blocks);

		while (!minPriorityQueue.min().getBoard().equals(goal)
				&& !minPriorityQueueTwin.min().getBoard().equals(goal)) {
			SearchNode nodeTemp = minPriorityQueue.deleteMin();
			SearchNode nodeTempTwin = minPriorityQueueTwin.deleteMin();

			for (Board neighbor : nodeTemp.getBoard().neighbors()) {
				if (nodeTemp.getMoves() == 0 || !neighbor.equals(nodeTemp.getPreviousNode().getBoard())) {
					minPriorityQueue.insert(new SearchNode(neighbor, nodeTemp.getMoves() + 1, nodeTemp));
				}
			}

			for (Board neighbor : nodeTempTwin.getBoard().neighbors()) {
				if (nodeTempTwin.getMoves() == 0
						|| !neighbor.equals(nodeTempTwin.getPreviousNode().getBoard())) {
					minPriorityQueueTwin
							.insert(new SearchNode(neighbor, nodeTempTwin.getMoves() + 1, nodeTempTwin));
				}
			}
		}
	}

	public boolean isSolvable() {
		if (minPriorityQueue.min().getBoard().equals(goal)) {
			return true;
		}
		if (minPriorityQueueTwin.min().getBoard().equals(goal)) {
			return false;
		}

		return false;
	}

	public int moves() {
		if (!isSolvable())
			return -1;
		return minPriorityQueue.min().getMoves();
	}

	public Iterable<Board> solution() {
		if (!isSolvable())
			return null;
		Stack<Board> temp = new Stack<Board>();
		SearchNode currentNode = minPriorityQueue.min();
		while (currentNode.getPreviousNode() != null) {
			temp.push(currentNode.getBoard());
			currentNode = currentNode.getPreviousNode();
		}
		temp.push(initial);

		List<Board> result = new ArrayList<>();
		while (!temp.isEmpty()) {
			result.add(temp.pop());
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] blocks = { { 0, 1, 3 }, { 4, 2, 5 }, { 7, 8, 6 } };
//		int[][] blocks = { { 1, 2, 3 }, { 4, 5, 6 }, { 8, 7, 0 } };
//		int[][] blocks = { { 6, 1, 2 }, { 4, 8, 3 }, { 0, 7, 5 } }; //blocks này khó quá, chạy nóng máy vẫn chưa giải được
		Board initial = new Board(blocks);

		Solver solver = new Solver(initial);

		if (!solver.isSolvable()) {
			System.out.println("No solution possible");
		} else {
			System.out.println("Minimum number of moves = " + solver.moves());
			for (Board board : solver.solution()) {
				System.out.println(board);
			}
		}
	}

}
