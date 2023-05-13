package test;

import model.Board;
import model.Solver;
import algo.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] blocks = { { 0, 1, 3 }, { 4, 2, 5 }, { 7, 8, 6 } };
//		int[][] blocks = { { 1, 2, 3 }, { 4, 5, 6 }, { 8, 7, 0 } };
		int[][] blocks = { { 5, 1, 0 }, { 7, 2, 8 }, { 3, 6, 4 } };
//		int[][] blocks = { { 6, 1, 8 }, { 4, 3, 2 }, { 7, 5, 0 } };
		Board initial = new Board(blocks);

		Solver solver = new Solver(initial);
//		solver.changeAlgorithm(new BfsAlgorithm());
		solver.solve();

		if (!solver.isSolvable()) {
			System.out.println("No solution possible");
		} else {
			System.out.println("Number of moves = " + solver.getMoves());
			System.out.println("Time: " + solver.getTimeExcute());
			System.out.println(solver.getSolution());
		}
	}

}
