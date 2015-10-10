package montyHall;

public class Box {
	private char id;
	private boolean containsPrize;

	public Box(char id) {
		this.id = id;
	}

	public boolean getPrize(){
		return containsPrize;
	}
	
	public void setPrize() {
		containsPrize = true;
	}
}
