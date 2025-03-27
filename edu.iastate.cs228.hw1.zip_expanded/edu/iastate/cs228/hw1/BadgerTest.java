package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * 
 * @author Adin Huric
 *
 */

public class BadgerTest {

	@Test
	public void BadgerTest1() {
		
		Plain p = new Plain(2);
		
		
		Badger b = new Badger(p, 1 , 1 , 1);
		
		assertEquals(b.row,1);

		
	}
	@Test
	public void BadgerTest2() {
		
		Plain p = new Plain(2);
		
		
		Badger b = new Badger(p, 1 , 1 , 1);
		
		assertEquals(b.column,1);

		
	}
	@Test
	public void BadgerTest3() {
		
		Plain p = new Plain(2);
				
		Badger b = new Badger(p, 1 , 1 , 1);
		
		assertEquals(b.age,1);
	}
	@Test
	public void BadgerTest4() {
		
		Plain p = new Plain(2);
				
		Badger b = new Badger(p, 1 , 1 , 1);
		
		assertEquals(b.who(),State.BADGER);
	}


}
