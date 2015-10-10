package montyHall;

import java.util.ArrayList;

public class BoxHypoTester {
	private static Data mData = new Data();
	private static Person mPerson = new Person();
	private static Host mMontyHost = new Host();
	private static Box mBoxA;
	private static Box mBoxB;
	private static Box mBoxC;

	private static ArrayList<Box> mBoxes = new ArrayList<Box>();
    public static long[] results = new long[10];
	
//	public static void main(String[] args){
//		simulatePlay(100000);
//	}

	/**
	 * Allows user to choose # of simulations to run and what type
	 */
	public static long[] simulatePlay(final long numberOfGames) {
		runSimulation(numberOfGames);

        return mData.getResults();
	}

	/**
	 * Will set up a simulation and run it until the amount desired is reached
	 * @param amount - amount to run the simulation
	 */
	private static void runSimulation(long amount){
		for(int i = 0; i < amount; i++) {
			setUpSingleSimulation();
			runSingleSimulation();
		}
		for(int i = 0; i < amount; i++) {
			mPerson.setSwitchBoxStrategy(true);
			setUpSingleSimulation();
			runSingleSimulation();
		}
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
		mBoxes = mPerson.pickBox(mBoxes);
		mBoxes = mMontyHost.revealEmpty(mBoxes);
		determineWinner();
	}

	/**
	 * Determines whether the person has won or not
	 */
	private static void determineWinner() {
		if(mPerson.isSwitchingBox()){
			mBoxes = mPerson.switchBox(mBoxes);
			Boolean winner = mPerson.openBox();
			if(winner){
				mData.increaseWinsSwitch();
			}
			else{
				mData.increaseLossesSwitch();
			}
		}
		else{
			Boolean winner = mPerson.openBox();
			if(winner){
				mData.increaseWinsKeep();
			}
			else{
				mData.increaseLossesKeep();
			}
		}

	}
}
