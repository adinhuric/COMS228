package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Adin Huric
 *
 */

class FoxTest {

	@Test
	void FoxTest1() {
		
		Plain p = new Plain(2);
		
		
		Fox f = new Fox(p, 1 , 1, 1);
		
		assertEquals(f.row,1);
	}
	@Test
	void FoxTest2() {
		Plain p = new Plain(2);
		
		
		Fox f = new Fox(p, 1 , 1, 1);
		
		assertEquals(f.column,1);
	}
	@Test
	void FoxTest3() {
		Plain p = new Plain(2);
		
		
		Fox f = new Fox(p, 1 , 1, 1);
		
		assertEquals(f.age,1);
		
	}
	@Test
	void FoxTest4() {
		Plain p = new Plain(2);
		
		
		Fox f = new Fox(p, 1 , 1, 1);
		
		assertEquals(f.who(),State.FOX);
		
	}
}
