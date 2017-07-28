package com.gojek;

public class ParkingSlot {
	
	private int number;
	
	private Vehicle vehicle;
	
	private long timeIn;
	
	private long timeOut;
	
	private boolean isEmpty = true;
	
	
	public ParkingSlot(int number, boolean isEmpty) {
		super();
		this.number = number;
		this.isEmpty = isEmpty;
	}

	public ParkingSlot(int number) {
		super();
		this.number = number;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public long getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(long timeIn) {
		this.timeIn = timeIn;
	}

	public long getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(long timeOut) {
		this.timeOut = timeOut;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public boolean isEmpty(){
		return isEmpty;
	}
	

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParkingSlot [number=").append(number).append(", vehicle=").append(vehicle).append(", isEmpty=")
				.append(isEmpty).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingSlot other = (ParkingSlot) obj;
		if (number != other.number)
			return false;
		return true;
	}
	
}
