package montyHall;

import java.util.Random;

public class Host {
	
	public int setPrizeBox() {

		// set prize box randomly
		Random rando = new Random();
		int selector = (rando.nextInt(3) + 1);

		return selector;
	}
	
	public int revealEmpty() {
		//Removes a box that is not the prizebox at random.
		Random rando = new Random();
		int selector = (rando.nextInt(2) + 1);

		return selector;
	}
}
