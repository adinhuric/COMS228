package edu.iastate.cs228.hw2;

import java.io.File;

/**
 * 
 * @author Adin Huric
 *
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * This class sorts all the points in an array of 2D points to determine a
 * reference point whose x and y coordinates are respectively the medians of the
 * x and y coordinates of the original points.
 * 
 * It records the employed sorting algorithm as well as the sorting time for
 * comparison.
 *
 */
public class PointScanner {
	private Point[] points;

	private Point medianCoordinatePoint; // point whose x and y coordinates are respectively the medians of
											// the x coordinates and y coordinates of those points in the array
											// points[].
	private Algorithm sortingAlgorithm;

	protected long scanTime; // execution time in nanoseconds.

	/**
	 * This constructor accepts an array of points and one of the four sorting
	 * algorithms as input. Copy the points into the array points[].
	 * 
	 * @param pts input array of points
	 * @throws IllegalArgumentException if pts == null or pts.length == 0.
	 */
	public PointScanner(Point[] pts, Algorithm algo) throws IllegalArgumentException {
		if (pts == null || pts.length == 0) {
			throw new IllegalArgumentException("Points is null");
		}
		sortingAlgorithm = algo;
		points = new Point[pts.length];
		for (int i = 0; i < pts.length; i++) {
			points[i] = new Point(pts[i]);
		}

	}

	/**
	 * This constructor reads points from a file.
	 * 
	 * @param inputFileName
	 * @throws FileNotFoundException
	 * @throws InputMismatchException if the input file contains an odd number of
	 *                                integers
	 */
	protected PointScanner(String inputFileName, Algorithm algo) throws FileNotFoundException, InputMismatchException {
		File file = new File(inputFileName);
		Scanner sc = new Scanner(file);
		Scanner scan = new Scanner(file);

		int i = 0;
		int count = 0;
		while (sc.hasNextInt()) {
			count++;
		}
		if (count % 2 == 1) {
			sc.close();
			scan.close();
			throw new InputMismatchException("Odd number of integers");
		}

		while (scan.hasNextInt()) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			points[i] = new Point(x, y);
			i++;
		}
		sc.close();
		scan.close();

	}

	/**
	 * Carry out two rounds of sorting using the algorithm designated by
	 * sortingAlgorithm as follows:
	 * 
	 * a) Sort points[] by the x-coordinate to get the median x-coordinate. b) Sort
	 * points[] again by the y-coordinate to get the median y-coordinate. c)
	 * Construct medianCoordinatePoint using the obtained median x- and
	 * y-coordinates.
	 * 
	 * Based on the value of sortingAlgorithm, create an object of SelectionSorter,
	 * InsertionSorter, MergeSorter, or QuickSorter to carry out sorting.
	 * 
	 * @param algo
	 * @return
	 */
	public void scan() {

		AbstractSorter aSorter = null;

		if (sortingAlgorithm == Algorithm.SelectionSort) {
			aSorter = new SelectionSorter(points);
		} else if (sortingAlgorithm == Algorithm.InsertionSort) {
			aSorter = new InsertionSorter(points);
		} else if (sortingAlgorithm == Algorithm.MergeSort) {
			aSorter = new MergeSorter(points);
		} else if (sortingAlgorithm == Algorithm.QuickSort) {
			aSorter = new QuickSorter(points);
		}

		int xMid;
		int yMid;
		aSorter.setComparator(0);

		long start = System.nanoTime();
		aSorter.sort();

		xMid = aSorter.getMedian().getX();

		aSorter.setComparator(1);
		aSorter.sort();
		yMid = aSorter.getMedian().getY();

		medianCoordinatePoint = new Point(xMid, yMid);
		
		long time = System.nanoTime() - start;


		scanTime = time;
	}

	/**
	 * Outputs performance statistics in the format:
	 * 
	 * <sorting algorithm> <size> <time>
	 * 
	 * For instance,
	 * 
	 * selection sort 1000 9200867
	 * 
	 * Use the spacing in the sample run in Section 2 of the project description.
	 */
	public String stats() {
		return sortingAlgorithm + "	" + points.length + " " + scanTime;
	}

	/**
	 * Write MCP after a call to scan(), in the format "MCP: (x, y)" The x and y
	 * coordinates of the point are displayed on the same line with exactly one
	 * blank space in between.
	 */
	@Override
	public String toString() {
		String pts = null;
		for (int i = 0; i < points.length; i++) {
			pts += "MCP: (" + points[i].getX() + ", " + points[i].getY() + ")" + "\n";
		}
		return pts;
	}

	/**
	 * 
	 * This method, called after scanning, writes point data into a file by
	 * outputFileName. The format of data in the file is the same as printed out
	 * from toString(). The file can help you verify the full correctness of a
	 * sorting result and debug the underlying algorithm.
	 * 
	 * @throws FileNotFoundException
	 */
	public void writeMCPToFile() throws FileNotFoundException {
		try {
			String outputFileName = sortingAlgorithm + ".txt";
			File file = new File(outputFileName);
			PrintWriter output = new PrintWriter(file);
			output.print(toString());
			output.close();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("File not found");
		}

	}

}
