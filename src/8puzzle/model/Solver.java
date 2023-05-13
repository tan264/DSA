package model;

import algo.AStarAlgorithm;
import algo.Algorithm;

public class Solver {

	private Board initial;
	private boolean isSolvable = false;
	private String solution = "";
	private int moves = 0;
	private double timeExcute;
	private Algorithm algorithm = new AStarAlgorithm(); // solve by default using the A* algorithm.

	public Solver(Board initial) {
		this.initial = initial;
		int[][] matrix = initial.getMatrix();
		int[] temp = new int[9];

		int k = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp[k++] = matrix[i][j];
			}
		}

		int invCount = getInvCount(temp);
		if (invCount % 2 == 0) {
			isSolvable = true;
		}

	}

	public void solve() {
		if (isSolvable) {
			double start = System.nanoTime();

			SearchNode currentNode = algorithm.solve(initial);
			timeExcute = (System.nanoTime() - start) / 1000000000.0;
			if (currentNode == null) {
				System.out.println("Cannot solve this problem");
			} else {
				solution = currentNode.getDirection();
				moves = currentNode.getMoves();
			}

		}
	}

	public String getSolution() {
		if (!isSolvable) {
			return "No solvabe";
		}
		return solution;
	}

	public Board getInitialBoard() {
		return initial;
	}

	private int getInvCount(int[] arr) {
		int count = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (arr[i] > 0 && arr[j] > 0 && arr[i] > arr[j]) {
					count++;
				}
			}
		}

		return count;
	}

	public boolean isSolvable() {
		return isSolvable;
	}

	public void changeAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	public double getTimeExcute() {
		return timeExcute;
	}

	public int getMoves() {
		return moves;
	}
}
