package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Adin Huric
 *
 */

class RabbitTest {

	@Test
	public void RabbitTest1() {
		
		Plain p = new Plain(2);
		
		
		Rabbit r = new Rabbit(p, 1 , 1 , 1);
		
		assertEquals(r.row,1);

		
	}
	@Test
	public void RabbitTest2() {
		
		Plain p = new Plain(2);
		
		
		Rabbit r = new Rabbit(p, 1 , 1 , 1);
		
		assertEquals(r.column,1);

		
	}
	@Test
	public void RabbitTest3() {
		
		Plain p = new Plain(2);
		
		
		Rabbit r = new Rabbit(p, 1 , 1 , 1);
		
		assertEquals(r.age,1);
	}
	@Test
	public void RabbitTest4() {
		
		Plain p = new Plain(2);
		
		
		Rabbit r = new Rabbit(p, 1 , 1 , 1);
		
		assertEquals(r.who(), State.RABBIT);
	}

}
