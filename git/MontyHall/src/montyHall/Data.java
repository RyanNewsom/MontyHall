package montyHall;

public class Data {
	private long winsSwitch;
	private long lossesSwitch;
	private long winsKeep;
	private long lossesKeep;

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
