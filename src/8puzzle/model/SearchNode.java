package model;

public class SearchNode implements Comparable<SearchNode> {

	private Board board;
	private int moves;
	private int priority;
	private String direction;

	public SearchNode(Board board, int moves, String direction) {
		super();
		this.board = board;
		this.moves = moves;
		this.priority = board.manhattan() + moves;
		this.direction = direction;
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

	public String getDirection() {
		return direction;
	}

	@Override
	public int compareTo(SearchNode o) {
		// TODO Auto-generated method stub
		return this.priority - o.priority;
	}

	@Override
	public String toString() {
		return board.toString();
	}

}