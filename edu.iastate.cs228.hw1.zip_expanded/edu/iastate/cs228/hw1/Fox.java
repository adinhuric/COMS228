package edu.iastate.cs228.hw1;

/**
 *  
 * @author Adin Huric
 *
 */

/**
 * A fox eats rabbits and competes against a badger. 
 */
public class Fox extends Animal 
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Fox (Plain p, int r, int c, int a) 
	{
		plain = p;
		row = r;
		column = c;
		age = a;
	}
		
	/**
	 * A fox occupies the square. 	 
	 */
	public State who()
	{
		return State.FOX; 
	}
	
	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior badgers. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		int population[] = new int[NUM_LIFE_FORMS];
		census(population);
		
		//if fox reaches the max age return empty
		if(age == FOX_MAX_AGE) {
			return new Empty(pNew, row, column);
		}
		//if there are more badgers than foxes return badger
		else if(population[BADGER] > population[FOX]) {
			return new Badger(pNew, row, column, 0);
		}
		//if badger and fox out number the number of rabbits return empty
		else if((population[BADGER] + population[FOX]) > population[RABBIT]) {
			return new Empty(pNew, row, column);
		}
		//if none of the above then stays as fox and increments age by 1
		else return new Fox(pNew, row, column, age + 1);
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a fox. 
	}
}
