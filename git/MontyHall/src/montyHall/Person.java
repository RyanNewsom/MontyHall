package montyHall;

import java.util.Random;

public class Person {
	
	public int pickBox(){
		// random generator to pick box
		Random rando = new Random();
		int selector = (rando.nextInt(3) + 1);
		
		return selector;
	}

}
