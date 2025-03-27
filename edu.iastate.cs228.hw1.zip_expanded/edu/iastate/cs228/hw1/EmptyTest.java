package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Adin Huric
 *
 */

class EmptyTest {

	@Test
	void EmptyTest1() {
		
		Plain p = new Plain(2);
		
		
		Empty e = new Empty(p, 1 , 1);
		
		assertEquals(e.row,1);
	}
	@Test
	void EmptyTest2() {
		Plain p = new Plain(2);
		
		
		Empty e = new Empty(p, 1 , 1);
		
		assertEquals(e.row,1);
	}
	@Test
	void EmptyTest3() {
		Plain p = new Plain(2);
		
		
		Empty e = new Empty(p, 1 , 1);
		
		assertEquals(e.row,1);
		
	}
	@Test
	void EmptyTest4() {
		Plain p = new Plain(2);
		
		
		Empty e = new Empty(p, 1 , 1);
		
		assertEquals(e.who(),State.EMPTY);
		
	}

}
