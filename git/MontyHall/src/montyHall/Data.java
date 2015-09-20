package montyHall;

public class Data {
	private int wins;
	private int losses;
	private String typeOfSimulation;
	public static final String KEEP_ORIGINAL = "Keep_Original";
	public static final String SWITCH = "Switch";
	public static final String RANDOM = "Random";
	
	
	public int getWins() {
		return wins;
	}
	public void increaseWins() {
		wins++;
	}
	public int getLosses() {
		return losses;
	}
	public void increaseLosses() {
		losses++;
	}
	public String getTypeOfSimulation() {
		return typeOfSimulation;
	}
	public void setTypeOfSimulation(String typeOfSimulation) {
		this.typeOfSimulation = typeOfSimulation;
	}
	
	
	
	
	
	
}
