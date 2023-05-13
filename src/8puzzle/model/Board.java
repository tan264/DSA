package model;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private int[][] blocks;

	public Board(int[][] blocks) {
		this.blocks = blocks;
	}
	
	public int[][] getMatrix() {
		return blocks;
	}

	public int dimension() {
		return blocks.length;
	}

	public int manhattan() {
		int counter = 0;
		int[] expectedCoord = new int[2];
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {
				int value = blocks[i][j];
				if (value == 0)
					continue;
				expectedCoord[0] = (value - 1) / blocks.length;
				expectedCoord[1] = (value - 1) % blocks.length;
				counter += Math.abs(expectedCoord[0] - i) + Math.abs(expectedCoord[1] - j);
			}
		}

		return counter;
	}

	public boolean isGoal() {
		int temp = 0;
		int n = blocks.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == n - 1 && j == n - 1 && blocks[i][j] == 0)
					break;
				if (blocks[i][j] != ++temp)
					return false;
			}
		}

		return true;
	}

	public Board twin() {
		int[][] temp = clone(blocks);
		swap(temp, new int[] { temp.length - 1, 0 }, new int[] { temp.length - 1, 1 });
		return new Board(temp);
	}

	@Override
	public boolean equals(Object y) {
		Board temp = null;
		if (y instanceof Board) {
			temp = (Board) y;
		} else {
			return false;
		}

		return toString().equals(temp.toString());
	}

	public Iterable<Board> neighbors() {
		List<Board> result = new ArrayList<>();
		int n = blocks.length;
		int[] blankCoord = findBlankCoord(blocks);
		if (blankCoord[1] + 1 < n) {
			result.add(new Board(swapRight(blocks, blankCoord)));
		}
		if (blankCoord[1] - 1 >= 0) {
			result.add(new Board(swapLeft(blocks, blankCoord)));
		}
		if (blankCoord[0] - 1 >= 0) {
			result.add(new Board(swapAbove(blocks, blankCoord)));
		}
		if (blankCoord[0] + 1 < n) {
			result.add(new Board(swapBelow(blocks, blankCoord)));
		}

		return result;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
//		result.append(blocks.length + "\n");
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {
				result.append(blocks[i][j] + " ");
			}
			result.append("\n");
		}

		return result.toString();
	}

	private int[] findBlankCoord(int[][] m) {
		int n = m.length;
		int[] blankCoord = new int[2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (m[i][j] == 0) {
					blankCoord[0] = i;
					blankCoord[1] = j;
					return blankCoord;
				}
			}
		}

		return null;
	}

	private int[][] clone(int[][] a) {
		int[][] result = new int[a.length][a.length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				result[i][j] = a[i][j];
			}
		}

		return result;
	}

	private int[][] swapAbove(int[][] a, int[] blankCoord) {
		int[][] result = clone(a);

		int[] expectedCoord = new int[2];
		expectedCoord[0] = blankCoord[0] - 1;
		expectedCoord[1] = blankCoord[1];
		swap(result, blankCoord, expectedCoord);

		return result;
	}

	private int[][] swapBelow(int[][] a, int[] blankCoord) {
		int[][] result = clone(a);

		int[] expectedCoord = new int[2];
		expectedCoord[0] = blankCoord[0] + 1;
		expectedCoord[1] = blankCoord[1];
		swap(result, blankCoord, expectedCoord);

		return result;
	}

	private int[][] swapRight(int[][] a, int[] blankCoord) {
		int[][] result = clone(a);

		int[] expectedCoord = new int[2];
		expectedCoord[0] = blankCoord[0];
		expectedCoord[1] = blankCoord[1] + 1;
		swap(result, blankCoord, expectedCoord);

		return result;
	}

	private int[][] swapLeft(int[][] a, int[] blankCoord) {
		int[][] result = clone(a);

		int[] expectedCoord = new int[2];
		expectedCoord[0] = blankCoord[0];
		expectedCoord[1] = blankCoord[1] - 1;
		swap(result, blankCoord, expectedCoord);

		return result;
	}

	private void swap(int[][] a, int[] from, int[] to) {
		int temp = a[from[0]][from[1]];
		a[from[0]][from[1]] = a[to[0]][to[1]];
		a[to[0]][to[1]] = temp;
	}
}