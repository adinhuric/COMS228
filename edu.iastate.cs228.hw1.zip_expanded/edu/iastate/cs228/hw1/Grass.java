package edu.iastate.cs228.hw1;

/**
 *  
 * @author Adin Huric
 *
 */

/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	public Grass (Plain p, int r, int c) 
	{
		plain = p;
		row = r;
		column = c;
	}
	
	public State who()
	{
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast enough to take over Grass.
	 */
	public Living next(Plain pNew)
	{

		int population[] = new int[NUM_LIFE_FORMS];
		census(population);
		
		//if 3 times rabbits is greater than amount of grass return empty
		if((population[RABBIT]) >= (population[GRASS] * 3)) {
			return new Empty(pNew, row, column);
		}
		//if at least 3 rabbits return rabbit
		else if(population[RABBIT] >= 3) {
			return new Rabbit(pNew, row, column, 0);
		}
		//if none of the above then stays as grass
		else return new Grass(pNew, row, column);
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for grass. 
	}
}
