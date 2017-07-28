package com.practise.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ParkingLot {
	
	private PriorityQueue<ParkingSlot> parkingSlots;
	
	private int numberOfSlots;
	
	private int currentNoOfSlotsFilled;
	
	public ParkingLot(int numOfSlots) {
		this.numberOfSlots = numOfSlots+1;
		parkingSlots = new PriorityQueue<>(numOfSlots+1, new ParkingSlotComparator());
	}


	public int getNumberOfSlots() {
		return numberOfSlots;
	}



	public void setNumberOfSlots(int numberOfSlots) {
		this.numberOfSlots = numberOfSlots;
	}



	public int getCurrentNoOfSlotsFilled() {
		return currentNoOfSlotsFilled;
	}



	public void setCurrentNoOfSlotsFilled(int currentNoOfSlotsFilled) {
		this.currentNoOfSlotsFilled = currentNoOfSlotsFilled;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParkingLot [parkingSlots=").append(parkingSlots).append(", numberOfSlots=")
				.append(numberOfSlots).append("]");
		return builder.toString();
	}


	
	public PriorityQueue<ParkingSlot> getParkingSlots() {
		return parkingSlots;
	}


	public void setParkingSlots(PriorityQueue<ParkingSlot> parkingSlots) {
		this.parkingSlots = parkingSlots;
	}


	public boolean isFull() {
		return currentNoOfSlotsFilled == numberOfSlots-1;
	}


}
