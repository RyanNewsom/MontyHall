package montyHall;

import java.util.ArrayList;

public class BoxHypoTester {
	private static boolean switchChoice;
	private static Data mData = new Data();
	private static Person mPerson = new Person();
	static Host mMontyHost = new Host();
	private static Box mBoxA;
	private static Box mBoxB;
	private static Box mBoxC;

	private static ArrayList<Box> mBoxes = new ArrayList<Box>();
    public static long[] results = new long[10];
	
	public static void main(String[] args){
		simulatePlay(100000);
	}

	/**
	 * Allows user to choose # of simulations to run and what type
	 */
	public static long[] simulatePlay(final long numberOfGames) {
		runSimulation(numberOfGames);
        results[0] = mData.getWinsKeep();
        results[1] = mData.getWinsSwitch();

        return results;
	}

	private static void runSimulation(long amount){
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

	/**
	 * Create boxes and the host places a prize inside it
	 */
	private static void setUpSingleSimulation() {
		mBoxA = new Box('a');
		mBoxB = new Box('b');
		mBoxC = new Box('c');
		mBoxes.clear();
		mBoxes.add(mBoxA);
		mBoxes.add(mBoxB);
		mBoxes.add(mBoxC);

		mBoxes = mMontyHost.setPrizeBox(mBoxes);
	}

	private static void runSingleSimulation(){
		//[TODO] pass the person the box they pick, a box shouldn't pick itself
		int boxPick = mPerson.pickBox();

		switch(boxPick){
		case 1:
			mBoxA.chooseBox();
			break;
		case 2:
			mBoxB.chooseBox();
			break;
		case 3:
			mBoxC.chooseBox();
			break;
		}

		//Removes a box that is not the prizebox at random

		Host monty = new Host();
		int selector = monty.revealEmpty();
		// [TODO] Change this so that the host removes the box's himself
		switch(selector){
		case 1:
			for(int i = 0; i < 3; i++){
				if(!mBoxes.get(i).getPrize() && !mBoxes.get(i).isChosen()){
					mBoxes.remove(i);
					break;
				}
			}
			break;

		case 2:
			for(int i = 2; i >= 0; i--){
				if(mBoxes.get(i).getPrize() != true && mBoxes.get(i).isChosen() != true){
					mBoxes.remove(i);
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
		Box currentBox = mBoxes.get(0);

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



}
