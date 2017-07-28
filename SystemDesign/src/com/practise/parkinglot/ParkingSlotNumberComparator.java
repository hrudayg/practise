package com.practise.parkinglot;

import java.util.Comparator;

public class ParkingSlotNumberComparator implements Comparator<ParkingSlot>{

	@Override
	public int compare(ParkingSlot firstParkingSlot, ParkingSlot secondParkingSlot) {
		return firstParkingSlot.getNumber() - secondParkingSlot.getNumber();
	}

}
