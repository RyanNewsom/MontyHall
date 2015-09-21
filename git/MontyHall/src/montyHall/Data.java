package montyHall;

public class Data {
	private long winsSwitch;
	private long lossesSwitch;
	private long winsKeep;
	private long lossesKeep;
	private String typeOfSimulation;
	public static final String KEEP_ORIGINAL = "Keep_Original";
	public static final String SWITCH = "Switch";
	public static final String RANDOM = "Random";

	public long[] results;
	
	
	public long getWinsSwitch() {
		return winsSwitch;
	}
	public void increaseWinsSwitch() {
		winsSwitch++;
	}
	public long getWinsKeep() {
		return winsKeep;
	}
	public void increaseWinsKeep() {
		winsKeep++;
	}

	public long getLossesSwitch() {
		return lossesSwitch;
	}
	public void increaseLossesSwitch() {
		lossesSwitch++;
	}
	public long getLossesKeep() {
		return lossesKeep;
	}
	public void increaseLossesKeep() {
		lossesKeep++;
	}

	public String getTypeOfSimulation() {
		return typeOfSimulation;
	}
	public void setTypeOfSimulation(String typeOfSimulation) {
		this.typeOfSimulation = typeOfSimulation;
	}

	public long[] getResults() {
		results[0] = winsKeep;
		results[1] = winsSwitch;

		return results;
	}
	
}
