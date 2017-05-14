package aud.a04;

public class Occupancy {
	
	protected int numbersOfKeys;
	protected int arraySize;
	protected final double MAX_OCCUPANCY_PERCENT = 45.0;
	
	public Occupancy(int arraySize) {
		this.arraySize = arraySize;
	}
	
	public void addKey() {
		numbersOfKeys++;
	}
	
	public void removeKey() {
		numbersOfKeys--;
	}
	
	public boolean maxOccupancyExceeded() {
		return (getOccupancyRateInPercent() > MAX_OCCUPANCY_PERCENT) ? true : false;
	}
	
	public double getOccupancyRateInPercent() {
		return (double)numbersOfKeys/arraySize * 100;
	}
	
	public void extendArraySizeTo(int newArraySize){
		arraySize = newArraySize;
		numbersOfKeys = 0;
	}

	@Override
	public String toString() {
		return String.format("Occupancy Rate of the HashTable [%%]: %5.2f", getOccupancyRateInPercent());
	}
}
