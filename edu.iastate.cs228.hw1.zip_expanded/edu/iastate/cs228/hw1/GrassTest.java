package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Adin Huric
 *
 */

class GrassTest {


	@Test
	void GrassTest1() {
		
		Plain p = new Plain(2);
		
		
		Grass grass = new Grass(p, 1 , 1);
		
		assertEquals(grass.row,1);
	}
	@Test
	void GrassTest2() {
		Plain p = new Plain(2);
		
		
		Grass grass = new Grass(p, 1 , 1);
		
		assertEquals(grass.column,1);
	}
	@Test
	void GrassTest3() {
		Plain p = new Plain(2);
		
		
		Grass grass = new Grass(p, 1 , 1);
		
		assertEquals(grass.who(),State.GRASS);
		
	}


}
