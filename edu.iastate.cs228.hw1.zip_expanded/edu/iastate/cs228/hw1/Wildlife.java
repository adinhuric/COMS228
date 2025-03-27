package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author Adin Huric
 *
 */

/**
 * 
 * The Wildlife class performs a simulation of a grid plain with
 * squares inhabited by badgers, foxes, rabbits, grass, or none. 
 *
 */
public class Wildlife 
{
	/**
	 * Update the new plain from the old plain in one cycle. 
	 * @param pOld  old plain
	 * @param pNew  new plain 
	 */
	//goes through the grid and sets the location on the new grid
	//with the new living after .next is called on the old grid
	public static void updatePlain(Plain pOld, Plain pNew)
	{

		// For every life form (i.e., a Living object) in the grid pOld, generate  
		// a Living object in the grid pNew at the corresponding location such that 
		// the former life form changes into the latter life form. 
		// 
		for(int i = 0; i < pOld.getWidth(); i++) {
			for(int j = 0; j < pOld.getWidth(); j++) {
					pNew.grid[i][j] = pOld.grid[i][j].next(pNew);			
			}
			
		}
		// Employ the method next() of the Living class. 
	}
	
	/**
	 * Repeatedly generates plains either randomly or from reading files. 
	 * Over each plain, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		Scanner sc = new Scanner(System.in);
		
		int number = 0;
		int width = 0;
		int cycles = -1;
		Plain odd = null;
		Plain even = null;
		int trial = 0;
		
		// 
		// Generate wildlife simulations repeatedly like shown in the 
		// sample run in the project description. 
		// 
		// 1. Enter 1 to generate a random plain, 2 to read a plain from an input
		//    file, and 3 to end the simulation. (An input file always ends with 
		//    the suffix .txt.)
		// 
		// 2. Print out standard messages as given in the project description. 
		// 
		while(trial <= 4) {
			
			System.out.println("Trial: " + 1);

			System.out.println("Enter 1 to generate a random plain");
			System.out.println("2 to read a plain from an input file");
			System.out.println("3 to end the simulation");
			
			

				number = sc.nextInt();
				
				while(number != 1 || number != 2|| number != 3) {
					
					if(number == 1) {
						System.out.print("Width of the plain:");
						width = sc.nextInt();
						
						odd = new Plain(width);
						even = new Plain(width);
						odd.randomInit();
					}
					else if(number == 2) {
						System.out.print("File: ");
						String inputFile = sc.next();
						odd = new Plain(inputFile); 
						even = new Plain(odd.getWidth());
					}
					else if(number == 3) {
						sc.close();
						System.out.println("Ended the Simulation");
						trial = 5;
						break;
					}
					
					
					
					while(cycles < 0) {
						
						System.out.print("Number of cycles:");
						cycles = sc.nextInt();
					}

					System.out.println("Initial Plain: \n" + odd);
					
					if(cycles == 0) {
						System.out.println("Final Plain: \n" + odd);
						break;
					}
					
					for(int i = 0; i < cycles; i++) {
						
						if(i % 2 == 0) {
							updatePlain(odd,even);

						}
						else {
							updatePlain(even,odd);
						}


					}

					if (cycles % 2 == 1) {
						System.out.println("Final Plain: \n" + even);

					}
					else {
						System.out.println("Final Plain: \n" + odd);
					}		
					cycles = -1;
					break;
				}

				
				
			trial++;
		}
		
		// 3. For convenience, you may define two plains even and odd as below. 
		//    In an even numbered cycle (starting at zero), generate the plain 
		//    odd from the plain even; in an odd numbered cycle, generate even 
		//    from odd. 
		
		
		// 4. Print out initial and final plains only.  No intermediate plains should
		//    appear in the standard output.  (When debugging your program, you can 
		//    print intermediate plains.)
		// 
		// 5. You may save some randomly generated plains as your own test cases. 
		// 
		// 6. It is not necessary to handle file input & output exceptions for this 
		//    project. Assume data in an input file to be correctly formated. 
	}
}
