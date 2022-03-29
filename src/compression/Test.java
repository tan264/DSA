package compression;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Test {

	public static void main(String[] args) {

//		testRle1();
//		testRle2();
//		testRle3();
//		testRle4();
//		testLz1();
//		testLz2();
//		testLz3();
//		testLz4();
//		testLz5();
	}

	public static String readData(String url) {
		StringBuilder sb = new StringBuilder();
		FileInputStream fis;
		try {
			fis = new FileInputStream(url);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			sb.append(br.readLine());
//			while(br.readLine() != null) {
//				sb.append(br.readLine());
//			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString();
	}

	public static void testRle1() {
		System.out.printf("testRle1 ");
		for (int[] line : Data.testsRle) {
			System.out.printf("%d ", RLE.length(line));
		}
		System.out.printf("done\n");
	}

	public static void testRle2() {
		System.out.printf("testRle2 ");
		for (int[] line : Data.testsRle) {
			int[] rle = RLE.compress(line);
			for (int i : rle)
				System.out.printf("%d ", i);
			System.out.printf("| ");
		}
		System.out.printf("done\n");
	}

	public static void testRle3() {
		System.out.printf("testRle3 ");
		for (int[] line : Data.testsRleInverse) {
			System.out.printf("%d ", RLE.lengthInverse(line));
		}
		System.out.printf("done\n");
	}

	public static void testRle4() {
		System.out.printf("testRle4 ");
		for (int[] line : Data.testsRleInverse) {
			int[] rle = RLE.decompress(line);
			for (int i : rle)
				System.out.printf("%d ", i);
			System.out.printf("| ");
		}
		System.out.printf("done\n");
	}

	public static void testLz1() {
		System.out.printf("testLz1 ");
		Occurrence o;
		o = LZ77.longestOccurrence(Data.testsLzOccurrence[0], 0, Data.windowSize);
		System.out.printf("%d %d | ", o.size, o.retour);
		o = LZ77.longestOccurrence(Data.testsLzOccurrence[1], 0, Data.windowSize);
		System.out.printf("%d %d | ", o.size, o.retour);
		o = LZ77.longestOccurrence(Data.testsLzOccurrence[2], 0, Data.windowSize);
		System.out.printf("%d %d | ", o.size, o.retour);
		o = LZ77.longestOccurrence(Data.testsLzOccurrence[2], 1, Data.windowSize);
		System.out.printf("%d %d | ", o.size, o.retour);
		o = LZ77.longestOccurrence(Data.testsLzOccurrence[3], 0, Data.windowSize);
		System.out.printf("%d %d | ", o.size, o.retour);
		o = LZ77.longestOccurrence(Data.testsLzOccurrence[3], 2, Data.windowSize);
		System.out.printf("%d %d | ", o.size, o.retour);
		o = LZ77.longestOccurrence(Data.testsLzOccurrence[4], 143, Data.windowSize);
		System.out.printf("%d %d | ", o.size, o.retour);
		o = LZ77.longestOccurrence(Data.testsLzOccurrence[4], 298, Data.windowSize);
		System.out.printf("%d %d | ", o.size, o.retour);
		System.out.printf("done\n");
	}

	public static void testLz2() {
		System.out.printf("testLz2 ");
		for (int[] line : Data.testsLz)
			System.out.printf("%d ", LZ77.length(line, Data.windowSize));
		System.out.printf("done\n");
	}

	public static void testLz3() {
		System.out.printf("testLz3 ");
		for (int[] line : Data.testsLz)
			LZ77.printCompression(LZ77.compress(line, Data.windowSize));
		System.out.printf("done\n");
	}

	public static void testLz4() {
		System.out.printf("testLz4 ");
		for (Element[] line : Data.testsLzInverse)
			System.out.printf("%d ", LZ77.lengthInverse(line));
		System.out.printf("done\n");
	}

	public static void testLz5() {
		System.out.printf("testLz5 ");
		for (Element[] line : Data.testsLzInverse)
			LZ77.printDecompression(LZ77.decompress(line));
		System.out.printf("done\n");
	}

}
