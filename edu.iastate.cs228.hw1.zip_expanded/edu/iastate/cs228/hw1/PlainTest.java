package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 * @author Adin Huric
 *
 */

import org.junit.jupiter.api.Test;

class PlainTest {

	@Test
	void PlainTest1() {
		Plain p = new Plain(3);
		
		assertEquals(p.getWidth(), 3);
	}
}
