package com.practise.parkinglot;

import java.util.Comparator;

public class ParkingSlotComparator implements Comparator<ParkingSlot>{

	@Override
	public int compare(ParkingSlot firstParkingSlot, ParkingSlot secondParkingSlot) {
		boolean isFirstParkingSlotEmpty = firstParkingSlot.isEmpty();
		boolean isSecondParkingSlotEmpty = secondParkingSlot.isEmpty();
		if((isFirstParkingSlotEmpty && isSecondParkingSlotEmpty) || (!isFirstParkingSlotEmpty && !isSecondParkingSlotEmpty)){
			return firstParkingSlot.getNumber() - secondParkingSlot.getNumber();
		}
		if(!isFirstParkingSlotEmpty && isSecondParkingSlotEmpty){
			return 201;
		}
		if(isFirstParkingSlotEmpty && !isSecondParkingSlotEmpty){
			return -101;
		}
		System.out.println("returning 0");
		return 0;
		
	}
	
}
