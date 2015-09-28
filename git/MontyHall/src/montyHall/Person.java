package montyHall;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Person {

	private Box myBox;
	private boolean switchBoxStrategy;

	public ArrayList<Box> pickBox( ArrayList<Box> boxes) {
		Random rando = new Random();
		int boxPick = (rando.nextInt(boxes.size()) + 1);

		switch (boxPick) {
			case 1:
				myBox = boxes.get(0);
				boxes.remove(0);
				break;
			case 2:
				myBox = boxes.get(1);
				boxes.remove(1);
				break;
			case 3:
				myBox = boxes.get(2);
				boxes.remove(2);
				break;
		}
		return boxes;
	}

	public boolean openBox(){
		if(myBox.getPrize()){
			return true;
		}
		else {
			return false;
		}
	}

	public ArrayList<Box> switchBox(ArrayList<Box> boxes){
		Box temp = myBox;
		myBox = boxes.remove(0);
		boxes.add(temp);
		return boxes;
	}

	public void setSwitchBoxStrategy(Boolean switchBox){
		switchBoxStrategy = switchBox;
	}

	public boolean isSwitchingBox(){
		return switchBoxStrategy;
	}

}
