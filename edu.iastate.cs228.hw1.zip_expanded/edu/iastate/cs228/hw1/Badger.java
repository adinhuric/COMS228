package edu.iastate.cs228.hw1;

/**
 *  
 * @author Adin Huric
 *
 */

/**
 * A badger eats a rabbit and competes against a fox. 
 */
public class Badger extends Animal
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Badger (Plain p, int r, int c, int a) 
	{
		plain = p;
		row = r;
		column = c;
		age = a;
	}
	
	/**
	 * A badger occupies the square. 	 
	 */
	public State who()
	{
		return State.BADGER; 
	}
	
	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a group of foxes. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		int population[] = new int[NUM_LIFE_FORMS];
		census(population);
		
		//if badger reaches its max age return empty
		if(age == BADGER_MAX_AGE) {
			return new Empty(pNew, row, column);
		}
		// if fox is more than 1 and badger is at 1 return fox
		else if(population[FOX] > 1 && population[BADGER] == 1) {
			return new Fox(pNew, row, column, 0);
		}
		//if badgers and foxes out number the rabbit return empty
		else if((population[BADGER] + population[FOX]) > population[RABBIT]) {
			return new Empty(pNew, row, column);
		}
		//if none of the above then stays as badger and increases age by 1
		else return new Badger(pNew, row, column, age + 1);
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a badger. 
	}
}
