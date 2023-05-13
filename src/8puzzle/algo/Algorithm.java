package algo;

import model.Board;
import model.SearchNode;

public interface Algorithm {
	SearchNode solve(Board initial);
}
