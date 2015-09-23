package montyHall;

public class Box {
	private char id;
	private boolean containsPrize;
	private boolean isChosen;
	
	public Box(char id) {
		this.id = id;
	}

	public boolean getPrize(){
		return containsPrize;
	}
	
	public void setPrize() {
		containsPrize = true;
	}

	/**
	 *
	 * @return - True if box is chosen
	 */
	public boolean isChosen(){
		return isChosen;
	}
	
	public void chooseBox(){
		isChosen = true;
	}
	
	public void removeChosen(){
		isChosen = false;
	}

}
