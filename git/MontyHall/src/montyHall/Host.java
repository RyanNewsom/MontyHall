package montyHall;

import java.util.ArrayList;
import java.util.Random;

public class Host {
	
	public ArrayList<Box> setPrizeBox(ArrayList<Box> boxes){

		// set prize box randomly
		Random rando = new Random();
		int selector = (rando.nextInt(3) + 1);
		switch(selector) {
			case 1:
				boxes.get(0).setPrize();
				break;
			case 2:
				boxes.get(1).setPrize();
				break;
			case 3:
				boxes.get(2).setPrize();
				break;
		}
		return boxes;

	}
	
	public ArrayList<Box> revealEmpty(ArrayList<Box> boxes) {
		//Removes a box that is not the prizebox at random.
		Random rando = new Random();
		int selector = (rando.nextInt(2) + 1);
		switch(selector){
			case 1:
				for(int i = 0; i < 2; i++){
					if(!boxes.get(i).getPrize()){
						boxes.remove(i);
						break;
					}
				}
				break;

			case 2:
				for(int i = 1; i >= 0; i--){
					if(boxes.get(i).getPrize() != true){
						boxes.remove(i);
						break;
					}
				}
				break;
		}
		return boxes;
	}
}
