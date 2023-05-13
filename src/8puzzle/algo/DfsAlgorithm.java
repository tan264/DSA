package algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import model.Board;
import model.SearchNode;

public class DfsAlgorithm implements Algorithm {

	@Override
	public SearchNode solve(Board initial) {
		ArrayDeque<SearchNode> queue = new ArrayDeque<SearchNode>();

		SearchNode currentNode = new SearchNode(initial, 0, "");
		queue.push(currentNode);
		List<Board> visitedBoard = new ArrayList<>();
		List<Board> innerBoard = new ArrayList<>();
		innerBoard.add(currentNode.getBoard());

		try {
			while (!queue.isEmpty()) {
				currentNode = queue.pop();
				visitedBoard.add(currentNode.getBoard());
				innerBoard.remove(currentNode.getBoard());

				if (currentNode.getBoard().isGoal()) {
					return currentNode;
				}

				for (Board board : currentNode.getBoard().neighbors()) {
					if (!visitedBoard.contains(board) && !innerBoard.contains(board)) {
						queue.push(new SearchNode(board, currentNode.getMoves() + 1,
								currentNode.getDirection() + "\n" + board.toString()));
						innerBoard.add(board);
					}
				}
			}
		} catch (OutOfMemoryError e) {
			// TODO: handle exception
			queue.clear();
			visitedBoard.clear();
			innerBoard.clear();
		}

		return null;
	}

}
