package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Adin Huric
 *
 */

class LivingTest {

	protected static final int BADGER = 0; 
	protected static final int EMPTY = 1; 
	protected static final int FOX = 2; 
	protected static final int GRASS = 3; 
	protected static final int RABBIT = 4; 
	@Test
	public void CensusTest() throws FileNotFoundException {

			Plain p = new Plain(2);
			p.grid[0][0] =new Badger(p, 0,0,0);
			p.grid[0][1] =new Grass(p, 0,1);
			p.grid[1][0] =new Empty(p, 1,0);
			p.grid[1][1] =new Fox(p, 1,1,1);

	
			
			int population[] = new int[5];
			p.grid[0][0].census(population);
			
			assertEquals(population[0] , 1);
			assertEquals(population[3] , 1);
			assertEquals(population[1] , 1);
			assertEquals(population[2] , 1);
			
	}
	
	
	@Test
	public void CensusTest1() throws FileNotFoundException {
		
		int population[] = new int[5];

		Plain p1 = new Plain("public1-3x3.txt");
		p1.grid[2][1].census(population);
		
		assertEquals(population[FOX] , 3);
		assertEquals(population[RABBIT] , 1);
		assertEquals(population[EMPTY] , 1);
		assertEquals(population[GRASS] , 1);


	}
	

	@Test
	public void NextTest() throws FileNotFoundException {
		
			Plain p = new Plain("public1-3x3.txt");
		
			Plain p1 = new Plain(3);
			
			Living next = p.grid[0][1].next(p1);
			assertEquals(next.who(), State.FOX);

		
	}
	

}
