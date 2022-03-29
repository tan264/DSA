package compression;

public class LZ77 {
	/**
	 * This function takes an input array t, the current position in the array, and
	 * the size of the window. It returns the largest Occurrence found in the
	 * window. Don't forget that the current character is not in the window.
	 * 
	 * @param t
	 * @param currentPosition
	 * @param windowSize
	 * @return an occurrence
	 */
	public static Occurrence longestOccurrence(int[] t, int currentPosition, int windowSize) {
		// TODO: Your code here
		Occurrence longestOccurrence = new Occurrence(0, 0);
		int start = currentPosition - windowSize;
		if (start < 0) {
			start = 0;
		}
		int index;
		int size;
		int retour;
		for (int i = start; i < currentPosition; ++i) {
			size = 0;
			index = currentPosition;
			retour = currentPosition - i;
			if (i == currentPosition - 1 && t[i] == t[index]) {
				size++;
			} else if (t[i] == t[index]) {
				size++;
				for (int j = i + 1; j < currentPosition; ++j) {
					index++;
					if (index >= t.length)
						break;
					if (t[j] == t[index]) {
						size++;
					} else {
						break;
					}
				}
			}
			if (size > longestOccurrence.size) {
				longestOccurrence.size = size;
				longestOccurrence.retour = retour;
			}

		}

		return longestOccurrence;
	}

	/**
	 * Computes the length of the compressed array.
	 * 
	 * @param t
	 * @param windowSize
	 * @return the length of the compressed array.
	 */
	public static int length(int[] t, int windowSize) {
		// TODO: Your code here
		Occurrence occurrence = null;
		int count = 0;
		int currentIndex = 0;
		while (true) {
			occurrence = longestOccurrence(t, currentIndex, windowSize);
			currentIndex += occurrence.size + 1;
			count++;
			if (currentIndex == t.length) {
				break;
			}
		}

		return count;
	}

	/**
	 * Compresses an array t.
	 * 
	 * @param t
	 * @param windowSize
	 * @return an array of Element.
	 */
	public static Element[] compress(int[] t, int windowSize) {
		// TODO: Your code here
		Element[] result = new Element[length(t, windowSize)];
		Occurrence occurrence = null;
		int count = 0;
		int currentIndex = 0;
		while (true) {
			occurrence = longestOccurrence(t, currentIndex, windowSize);
			result[count] = new Element(occurrence, t[currentIndex + occurrence.size]);
			currentIndex += occurrence.size + 1;
			count++;
			if (currentIndex == t.length) {
				break;
			}
		}

		return result;
	}

	/**
	 * Prints out the compression array.
	 * 
	 * @param t
	 */
	public static void printCompression(Element[] t) {
		StringBuilder sb = new StringBuilder(1024);
		for (Element e : t) {
			sb.append(e.toString());
		}
		System.out.println(sb);
	}

	/**
	 * Computes the length of the decompressed data, given the compressed data.
	 * 
	 * @param t
	 * @return a length
	 */
	public static int lengthInverse(Element[] t) {
		int len = 0;
		for (Element e : t) {
			len += e.o.size;
		}
		return len + t.length; // plus length of t since we count next character in the compressed data
	}

	/**
	 * Decompresses data.
	 * 
	 * @param t
	 * @return an array representing decompressed data
	 */
	public static int[] decompress(Element[] t) {
		// TODO: Your code here
		int[] result = new int[lengthInverse(t)];
		int currentIndex = 0;
		Element element = null;
		for (int i = 0; i < t.length; ++i) {
			element = t[i];
			blit(result, result, currentIndex - element.o.retour, element.o.size, currentIndex);
			result[currentIndex + element.o.size] = element.s;
			currentIndex += element.o.size + 1;
		}

		return result;
	}

	/**
	 * Copy the characters of array t1, going from start1 to start1 + len - 1 to the
	 * array t2, starting from position start2.
	 * 
	 * @param t1
	 * @param t2
	 * @param start1
	 * @param len
	 * @param start2
	 */
	static void blit(int[] t1, int[] t2, int start1, int len, int start2) {
		// TODO: Your code here
		int index = start2;
		for (int i = start1; i <= start1 + len - 1; ++i) {
			t2[index] = t1[i];
			index++;
		}
	}

	public static void printDecompression(int[] t) {
		for (int i : t) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}
}

class Element {
	Occurrence o;
	int s;

	Element(Occurrence o, int s) {
		this.o = o;
		this.s = s;
	}

	@Override
	public String toString() {
		return o.toString() + s;
	}
}

class Occurrence {
	int retour;
	int size;

	Occurrence(int retour, int size) {
		this.retour = retour;
		this.size = size;
	}

	@Override
	public String toString() {
		return "(" + retour + "," + size + ")";
	}
}
