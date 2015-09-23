package montyHall;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class BoxHypoTester {
	private static boolean switchChoice;
	private static Data mData = new Data();
	private static Person mPerson = new Person();
	private static Box box1;
	private static Box box2;
	private static Box box3;

	private static ArrayList<Box> boxes = new ArrayList<Box>();
    public static long[] results = new long[10];
	
	public static void main(String[] args){
		simulatePlay(100000); // error thrown here ... ???
	}

	/**
	 * Allows user to choose # of simulations to run and what type
	 */
	private static long[] simulatePlay(final long numberOfGames) {
		// Create gui and let user decide how many times they wish to run the simulation
//		createGui();
//
//		JOptionPane pane = new JOptionPane();
//		String amount = pane.showInputDialog("Enter the amount of simulations you wish to run");
//		if(amount != null) {
//			try {
//				runSimulation(Integer.parseInt(amount));
//			} catch(Exception e){
//
//			}
//
//		}
		// runSimulation

		runSimulation(numberOfGames);

//		return mData.getResults(); // error was thrown here, fixed it

        

        results[0] = mData.getWinsKeep();
        results[1] = mData.getWinsSwitch();

        return results;
	}

	public static void runSimulation(long amount){
		//runs a series of single simulations depending on how many times
		//the simulation is to be ran
		switchChoice = true;
		for(int i = 0; i < amount; i++) {
			setUpSingleSimulation();
			runSingleSimulation();
		}
		switchChoice = false;
		for(int i = 0; i < amount; i++) {
			setUpSingleSimulation();
			runSingleSimulation();
		}

        System.out.println("When the player kept their original box they won " + mData.getWinsKeep() + " out of "
                + amount + " times");
        System.out.println("When the player switched their box choice they won " + mData.getWinsSwitch() + " out of "
				+ amount + " times");

	}

	public static void runSingleSimulation(){
		boxes.clear();
		boxes.add(box1);
		boxes.add(box2);
		boxes.add(box3);
		//run a scenario where the person chooses a box
		int boxPick = mPerson.pickBox();

		switch(boxPick){
		case 1: 
			box1.chooseBox();
			break;
		case 2: 
			box2.chooseBox();
			break;
		case 3: 
			box3.chooseBox();
			break;
		}
		
		//Removes a box that is not the prizebox at random

		Host monty = new Host();
		int selector = monty.revealEmpty();

		switch(selector){
		case 1:
			for(int i = 0; i < 3; i++){
				if(!boxes.get(i).getPrize() && !boxes.get(i).isChosen()){
					boxes.remove(i);
					break;
				}
			}
			break;

		case 2:
			for(int i = 2; i >= 0; i--){
				if(boxes.get(i).getPrize() != true && boxes.get(i).isChosen() != true){
					boxes.remove(i);
					break;
				}
			}
			break;
		}

		determineWinner();

	}

	/**
	 * Determines whether the person has won or not
	 */
	private static void determineWinner() {
		Box currentBox = boxes.get(0);

		if(switchChoice) {
			switchBoxChoice(currentBox);
		}
		if(!switchChoice) {
			keepOriginalBox(currentBox);
		}
	}

	private static void switchBoxChoice(Box currentBox) {
		if(currentBox.isChosen()){
            if(currentBox.getPrize()){
                mData.increaseLossesSwitch();
            }
            else{
                mData.increaseWinsSwitch();
            }
        }
        else{
            if(currentBox.getPrize()){
                mData.increaseWinsSwitch();
            }
            else{
                mData.increaseLossesSwitch();
            }
        }
	}

	private static void keepOriginalBox(Box currentBox) {
		if(currentBox.isChosen()){
            if(currentBox.getPrize()){
                mData.increaseWinsKeep();
            }
            else{
                mData.increaseLossesKeep();
            }
        }
        else{
            if(currentBox.getPrize()){
                mData.increaseLossesKeep();
            }
            else{
                mData.increaseWinsKeep();
            }
        }
	}


	public static void setUpSingleSimulation() {

		// create box objects
		box1 = new Box(1);
		box2 = new Box(2);
		box3 = new Box(3);

		// set prize box randomly
		Host monty = new Host();
		int selector = monty.setPrizeBox();

		switch(selector) {
			case 1:
				box1.setPrize();
				break;
			case 2:
				box2.setPrize();
				break;
			case 3:
				box3.setPrize();
				break;
		}
	}
}
