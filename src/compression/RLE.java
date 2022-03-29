package compression;

public class RLE {
	
	/**
	 * Computes the length of the compression array.
	 * @param t a binary array
	 * @return an integer.
	 */
	public static int length(int[] t) {
		// TODO: Your code here
		if (t == null) {
			throw new IllegalArgumentException();
		} else if (t.length == 0) {
			return 0;
		} else {
			int count = 1;
			for (int i = 0; i < t.length - 1; ++i) {
				if (t[i] != t[i + 1]) {
					count++;
				}
			}

			return count * 2;
		}
	}

	/**
	 * Compresses an array in RLE format and return the result.
	 * @param t
	 * @return compressed array.
	 */
	public static int[] compress(int[] t) {
		// TODO: Your code here
		int[] result = new int[length(t)];
		if (result.length == 0) {
			return result;
		}
		result[0] = t[0];
		int pos = 0;
		int key = t[0];
		for (int i = 0; i < t.length; ++i) {
			if (t[i] != key) {
				pos += 2;
				key = t[i];
				result[pos] = key;
				result[pos + 1]++;
			} else {
				result[pos + 1]++;
			}
		}

		return result;
	}

	/**
	 * Computes the length of the decompressed array.
	 * @param t
	 * @return an integer.
	 */
	public static int lengthInverse(int[] t) {
		// TODO: Your code here
		int result = 0;
		for (int i = 0; i < t.length; ++i) {
			if (i % 2 != 0) {
				result += t[i];
			}
		}

		return result;
	}
	
	/**
	 * Decompresses the array.
	 * @param t
	 * @return an array
	 */
	public static int[] decompress(int[] t) {
		int[] result = new int[lengthInverse(t)];
		if (result.length == 0) {
			return result;
		}
		int pos = 0;
		int key = t[1];
		for (int i = 0; i < result.length; ++i) {
			if (key > 0) {
				result[i] = t[pos];
				key--;
			} else {
				pos += 2;
				result[i] = t[pos];
				key = t[pos + 1];
				key--;
			}
		}

		return result;
	}
}
