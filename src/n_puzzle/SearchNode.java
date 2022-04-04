package n_puzzle;

public class SearchNode implements Comparable<SearchNode> {

	private Board board;
	private int moves;
	private int priority;
	private SearchNode previousNode;

	public SearchNode(Board board, int moves, SearchNode previousNode) {
		super();
		this.board = board;
		this.moves = moves;
		this.priority = board.manhattan();
		this.previousNode = previousNode;
	}

	public Board getBoard() {
		return board;
	}

	public int getMoves() {
		return moves;
	}

	public int getPriority() {
		return priority;
	}

	public SearchNode getPreviousNode() {
		return previousNode;
	}

	@Override
	public int compareTo(SearchNode o) {
		// TODO Auto-generated method stub
		return this.priority - o.priority;
	}

}
