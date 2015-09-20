package montyHall;

import java.util.Random;

public class Person {

	private String name;
	private boolean winner;
	private boolean switchedChoice;
	
	public int pickBox(){
		// random generator to pick box
		Random rando = new Random();
		int selector = (rando.nextInt(3) + 1);
		
		return selector;
	}
	
	public void changeBox() {
		
	}

}
