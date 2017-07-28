package com.practise.parkinglot;

public enum PARKING_LOT_COMMANDS {

	CREATE_PARKING_LOT(1, "create_parking_lot"),
	PARK(2, "park"),
	LEAVE(3, "leave"),
	STATUS(4, "status"),
	REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR(5, "registration_numbers_for_cars_with_colour"),
	SLOT_NUMBERS_FOR_CARS_WITH_COLOUR(6, "slot_numbers_for_cars_with_colour"),
	SLOT_NUMBER_FOR_REGISTRATION_NUMBER(7, "slot_number_for_registration_number");
	
	
	private String value;
	
	private int index;
	
	public String getValue() {
        return value;
    }

	@Override
    public String toString() {
        return getValue();
    }

    private PARKING_LOT_COMMANDS(int index, String value) {
    	this.index = index;
        this.value = value;
    }
	
}
