package montyHall;

public class Data {
	private long winsSwitch;
	private long lossesSwitch;
	private long winsKeep;
	private long lossesKeep;
	public long[] results;

	public void increaseWinsSwitch() {
		winsSwitch++;
	}
	public void increaseWinsKeep() {
		winsKeep++;
	}

	public void increaseLossesSwitch() {
		lossesSwitch++;
	}
	public void increaseLossesKeep() {
		lossesKeep++;
	}


	public long[] getResults() {
		results[0] = winsKeep;
		results[1] = winsSwitch;

		return results;
	}
	
}
