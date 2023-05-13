package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import model.Board;
import model.SearchNode;

public class AStarAlgorithm implements Algorithm {

	@Override
	public SearchNode solve(Board initial) {
		PriorityQueue<SearchNode> pq = new PriorityQueue<>();

		SearchNode currentNode = new SearchNode(initial, 0, initial.toString());
		pq.add(currentNode);
		List<Board> visitedBoard = new ArrayList<>();
		List<Board> innerBoard = new ArrayList<>();
		innerBoard.add(currentNode.getBoard());

		try {
			while (!currentNode.getBoard().isGoal()) {
				currentNode = pq.poll();
				innerBoard.remove(currentNode.getBoard());
				visitedBoard.add(currentNode.getBoard());

				for (Board board : currentNode.getBoard().neighbors()) {
					if (!visitedBoard.contains(board) && !innerBoard.contains(board)) {
						pq.add(new SearchNode(board, currentNode.getMoves() + 1,
								currentNode.getDirection() + "\n" + board.toString()));
						innerBoard.add(board);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			pq.clear();
			visitedBoard.clear();
			innerBoard.clear();
		}

		return currentNode;
	}

}
