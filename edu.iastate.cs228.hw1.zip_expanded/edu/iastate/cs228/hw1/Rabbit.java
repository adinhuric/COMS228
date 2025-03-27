package edu.iastate.cs228.hw1;

/**
 * 
 * @author Adin Huric
 *
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal {
	/**
	 * Creates a Rabbit object.
	 * 
	 * @param p: plain
	 * @param r: row position
	 * @param c: column position
	 * @param a: age
	 */
	public Rabbit(Plain p, int r, int c, int a) {
		plain = p;
		row = r;
		column = c;
		age = a;
	}

	// Rabbit occupies the square.
	public State who() {
		return State.RABBIT;
	}

	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a
	 * fox.
	 * 
	 * @param pNew plain of the next cycle
	 * @return Living new life form occupying the same square
	 */
	public Living next(Plain pNew) {

		int population[] = new int[NUM_LIFE_FORMS];
		census(population);

		// if rabbit reaches the max age return empty
		if (age == RABBIT_MAX_AGE) {
			return new Empty(pNew, row, column);
		}
		// if there is no grass return empty
		else if (population[GRASS] == 0) {
			return new Empty(pNew, row, column);
		}
		//if there are more fox than badger or if there are more fox + badger than
		// rabbits return a fox
		else if ((population[FOX] > population[BADGER])
				&& (population[FOX] + population[BADGER]) >= population[RABBIT]) {
			return new Fox(pNew, row, column, 0);
		}
		//if there are more badgers than rabbits return badger
		else if(population[BADGER] > population[RABBIT]) {
			return new Badger(pNew, row, column, 0);
		}
		// if none of the above then stays as rabbit and increments age by 1
		else return new Rabbit(pNew, row, column, age + 1);
		// See Living.java for an outline of the function.
		// See the project description for the survival rules for a rabbit.
	}
}
