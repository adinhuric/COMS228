package edu.iastate.cs228.hw1;

/**
 *  
 * @author Adin Huric
 *
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.Random; 

/**
 * 
 * The plain is represented as a square grid of size width x width. 
 *
 */
public class Plain 
{
	private int width; // grid size: width X width 
	
	public Living[][] grid; 
	
	/**
	 *  Default constructor reads from a file 
	 */
	public Plain(String inputFileName) throws FileNotFoundException
	{		
		// 
		File file = new File(inputFileName);
		Scanner scan = new Scanner(file);
		Scanner scnr = new Scanner(file);

		String line;
		// Assumption: The input file is in corr2ect format. 
		// 
		// You may create the grid plain in the following steps: 
		// 
		// 1) Reads the first line to determine the width of the grid.
		// 
		//each animal/empty/grass has 3 characters so divide by 3 to get width
		line = scan.nextLine();
		width = line.length() / 3;
		// 2) Creates a grid object. 
		// 
		grid = new Living[width][width];
		// 3) Fills in the grid according to the input file. 
		// 
			for(int i = 0; i < width; i ++) {
				for(int j = 0; j < width; j++) {
					
					String animal = scnr.next();
					
					
					
					if(animal.charAt(0) == 'B') {
						int age = Character.getNumericValue(animal.charAt(1));
						grid[i][j] = new Badger(this, i, j, age);
					}
					else if(animal.charAt(0) == 'E') {
						grid[i][j] = new Empty(this, i, j);
					}
					else if(animal.charAt(0) == 'F') {
						int age = Character.getNumericValue(animal.charAt(1));
						grid[i][j] = new Fox(this, i, j, age);
					}
					else if(animal.charAt(0) == 'G') {
						grid[i][j] = new Grass(this, i, j);
					}else if(animal.charAt(0) == 'R'){
						int age = Character.getNumericValue(animal.charAt(1));
						grid[i][j] = new Rabbit(this, i, j, age);	
					}
				}
			}
		scan.close();
		scnr.close();
		
		// Be sure to close the input file when you are done. 
	}
	
	/**
	 * Constructor that builds a w x w grid without initializing it. 
	 * @param width  the grid 
	 */
	public Plain(int w)
	{
		width = w;
		grid = new Living[width][width];
	}
	
	
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Initialize the plain by randomly assigning to every square of the grid  
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random(); 
		
		for(int i =0; i < width; i ++) {
			for(int j = 0; j < width; j ++) {
				
				//makes random number that correlates to a specific animal
				//then creates the random animal at that location 
				int number = generator.nextInt(5);

				if(number == 0) {
					grid[i][j] = new Badger(this ,i, j, 0);
				}
				else if(number == 1) {
					grid[i][j] = new Empty(this ,i, j);
				}
				else if(number == 2) {
					grid[i][j] = new Fox(this ,i, j, 0);
				}
				else if(number == 3) {
					grid[i][j] = new Grass(this ,i, j);
				}
				else if(number == 4) {
					grid[i][j] = new Rabbit(this ,i, j, 0);
				}	
			}
		}
	}
	
	
	/**
	 * Output the plain grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		String gridString = "";
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < width; j++) {
				
				if(grid[i][j].who() == State.BADGER) {
					gridString += "B" + ((Badger) grid[i][j]).myAge() + " ";
				}
				else if(grid[i][j].who() == State.EMPTY) {
					gridString += "E  ";
				}
				else if(grid[i][j].who() == State.FOX) {
					gridString += "F" + ((Fox) grid[i][j]).myAge() +  " ";
				}
				else if(grid[i][j].who() == State.GRASS) {
					gridString += "G  ";
				}
				else if(grid[i][j].who() == State.RABBIT) {
					gridString += "R" + ((Rabbit) grid[i][j]).myAge() + " ";
				}
				
				
			}
			//skips a line
			gridString += "\n";
		}
		return gridString;
	}
	

	/**
	 * Write the plain grid to an output file.  Also useful for saving a randomly 
	 * generated plain for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		// 
		// 1. Open the file. 
		// 
		File file = new File(outputFileName);
		PrintWriter output = new PrintWriter(file);
		
		// 2. Write to the file. The five life forms are represented by characters 
		//    B, E, F, G, R. Leave one blank space in between. Examples are given in
		//    the project description. 
		// 
		
		output.print(toString());

		
		// 3. Close the file. 
		output.close();

	}			
}
