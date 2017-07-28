package com.practise.parkinglot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * This is the utility class for execution of parking lot code.
 * 
 */

public class ParkingLotUtil {

	private Map<String, List<ParkingSlot>> colorParkingSlotMap;

	private Map<String, List<Vehicle>> colorVehicleMap;

	private Map<Vehicle, ParkingSlot> vehicleParkingSlotMap;
	
	private Map<Integer, ParkingSlot> slotParkingSlotMap;

	private ParkingLot parkingLot;

	public static void main(String[] args) {
		
		ParkingLotUtil parkingLotUtil = new ParkingLotUtil();
		if (args.length == 0) {
			// Run from the command line commands
			Scanner sc = new Scanner(System.in);
			while (true) {
				String commandEntered = sc.nextLine();
				if (!commandEntered.equalsIgnoreCase("exit")) {
					String result = parkingLotUtil.readCommandAndExecute(commandEntered);
					if(result != null && !result.isEmpty()){
						System.out.println(result);
					}
				} else {
					break;
				}
			}
		} else {
			System.out.println("hihihihihihi "+Arrays.toString(args));
			// Read from the file and execute the commands
			parkingLotUtil.readFromTheFile(args);
		}
		
		/*ParkingSlot parkingSlot1 = new ParkingSlot(1, false);
		ParkingSlot parkingSlot2 = new ParkingSlot(2, true);
		ParkingSlot parkingSlot3 = new ParkingSlot(3, false);
		ParkingSlot parkingSlot4 = new ParkingSlot(4, true);
		ParkingSlot parkingSlot5 = new ParkingSlot(5, false);
		ParkingSlot parkingSlot6 = new ParkingSlot(6, false);
		ParkingSlot parkingSlot7 = new ParkingSlot(7, true);
		
		PriorityQueue<ParkingSlot> parkingSlots = new PriorityQueue<>(new ParkingSlotComparator());
		parkingSlots.add(parkingSlot1);
		parkingSlots.add(parkingSlot2);
		parkingSlots.add(parkingSlot3);
		parkingSlots.add(parkingSlot4);
		parkingSlots.add(parkingSlot5);
		parkingSlots.add(parkingSlot6);
		parkingSlots.add(parkingSlot7);

		
		System.out.println(parkingSlots.poll());
		System.out.println(parkingSlots.poll());
		System.out.println(parkingSlots.poll());
		System.out.println(parkingSlots.poll());
		System.out.println(parkingSlots.poll());
		System.out.println(parkingSlots.poll());
		System.out.println(parkingSlots.poll());*/
		

	}
	
	/*
	 * Read from the input file and process the each command and output to the output file.
	 * 
	 */
	private void readFromTheFile(String[] args) {
		if (args.length == 3) {
			String inputFile = args[0];
			String command = args[1];
			String outputFile = args[2];
			System.out.println(Arrays.toString(args));
			if (command.equals(">")) {
				readFromFileAndProcess(inputFile, outputFile);
			}
		} else {
			System.out.println("Please check the command you have entered , It should be inputFile > outputFile");
		}
	}

	/*
	 * process the each file and print output
	 * 
	 */
	private void readFromFileAndProcess(String inputFile, String outputFile) {
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String sCurrentLine = "";
			while ((sCurrentLine = br.readLine()) != null && !"exit".equalsIgnoreCase(sCurrentLine)) {
				String result = readCommandAndExecute(sCurrentLine);
				try (FileWriter fw = new FileWriter(outputFile, true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter out = new PrintWriter(bw)) {
					out.println(result);
				} catch (IOException e) {
					// exception handling left as an exercise for the reader
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Please check whether the file exists or not");
		} catch (IOException ioe) {
			System.out.println("exception while reading the file");
			ioe.printStackTrace();
		}
	}
	
	/*
	 * Executes the command accoring to the command entered
	 * 
	 */
	private String readCommandAndExecute(String commandEntered) {
		String result = "";
		String[] commandStr = commandEntered.split(" ");
		String command = commandStr[0];
		PARKING_LOT_COMMANDS parkingLotCommand = null;
		try {
			parkingLotCommand = PARKING_LOT_COMMANDS.valueOf(command.toUpperCase());
		} catch (IllegalArgumentException e) {
			return "Sorry :: No Command Found";
		}

		if (parkingLotCommand != null) {
			switch (parkingLotCommand) {
			case CREATE_PARKING_LOT:
				int noOfSlots = Integer.parseInt(commandStr[1]);
				ParkingLot parkingLot = createParkingLot(noOfSlots);
				if (parkingLot != null) {
					this.parkingLot = parkingLot;
					result = "Created a parking lot with "+noOfSlots+ " slots";
				}
				break;
			case PARK:
				int slotAlloted = parkVehicle(commandStr);
				if (slotAlloted == -1) {
					result = "Sorry, parking lot is full";
				} else {
					findFirstEmptySlot();
					result = "Allocated slot number : " + slotAlloted;
				}
				break;
			case LEAVE:
				result = leaveSlot(commandStr);
				break;
			case STATUS:
				result = printStatus();
				break;
			case REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR:
				result = printRegistrationNumbersForCarsWithColor(commandStr);
				break;
			case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
				result = printSlotNumberForRegistrationNumber(commandStr);
				break;
			case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
				result = printSlotNumbersForCarsWithColor(commandStr);
				break;
			default:
				break;
			}
		}
		return result;
	}

	/*
	 * Gets the first empty slot and saves that index in the firstEmptySlot.
	 * So that the retrieving is in constant time.
	 * 
	 * We could have used priorityQueue to maintain the sorted order - Please refer to the ParkingSlotComparator Class.
	 * 
	 */
	private void findFirstEmptySlot() {
		/*for (int i = 1; i < parkingLot.getNumberOfSlots(); i++) {
			ParkingSlot parkingSlot = parkingLot.getParkingSlots().poll();
			if (parkingSlot.isEmpty()) {
				this.firstEmptySlot = parkingSlot.getNumber();
				return;
			}
		}*/
	}

	private String printSlotNumbersForCarsWithColor(String[] commandStr) {
		if (commandStr.length == 2) {
			String color = commandStr[1].toLowerCase();
			List<ParkingSlot> parkingSlots = colorParkingSlotMap.get(color.trim().toLowerCase());

			if (parkingSlots != null) {
				StringBuilder sb = new StringBuilder();
				for (ParkingSlot parkingSlot : parkingSlots) {
					sb.append(parkingSlot.getNumber() + " , ");
				}
				return sb.toString().trim().substring(0, sb.length() - 2);
			}
		} else {
			return "Please check the Command again " + Arrays.toString(commandStr);
		}
		return "";
	}

	private String printSlotNumberForRegistrationNumber(String[] commandStr) {
		if (commandStr.length == 2) {
			String registrationNumber = commandStr[1];
			Vehicle vehicle = new Vehicle(registrationNumber);
			ParkingSlot parkingSlot = vehicleParkingSlotMap.get(vehicle);
			if (parkingSlot != null) {
				return String.valueOf(parkingSlot.getNumber());
			} else {
				return "The vehicle number you are searching for is not available please check the registration number";
			}
		} else {
			return "Please check the Command again " + Arrays.toString(commandStr);
		}
	}

	private String printRegistrationNumbersForCarsWithColor(String[] commandStr) {
		if (commandStr.length == 2) {
			String color = commandStr[1].toLowerCase();
			List<Vehicle> vehicleList = colorVehicleMap.get(color.trim().toLowerCase());
			StringBuilder sb = new StringBuilder();
			for (Vehicle vehicle : vehicleList) {
				sb.append(vehicle.getRegistrationNumber() + " , ");
			}
			String appendedString = sb.toString().trim().substring(0, sb.length() - 2);
			return appendedString;
		} else {
			return "Please check the Command again";
		}
	}

	/*
	 * This method is used to print the status of the parking lot.
	 * Used Java 8 features of streams , collectors and lambda expressions
	 * 
	 */
	private String printStatus() {
		StringBuilder sb = new StringBuilder();
		sb.append("*******************************************************\n");
		String heading = String.format("%10s%20s%16s\n", "Slot No", "Registration Number", "Color");
		sb.append(heading);
		List<ParkingSlot> parkingSlotList = new ArrayList(parkingLot.getParkingSlots());
		parkingSlotList.sort(new ParkingSlotNumberComparator());
		parkingSlotList.stream().filter(parkingSlot -> !parkingSlot.isEmpty()).collect(Collectors.toList())
				.forEach(parkingSlot -> sb.append(String.format("%10d%20s%16s\n", parkingSlot.getNumber(),
						parkingSlot.getVehicle().getRegistrationNumber(), parkingSlot.getVehicle().getColor())));
		sb.append("*******************************************************");
		return sb.toString();
	}

	private String leaveSlot(String[] commandStr) {
		if (commandStr.length == 2) {
			int slotNumber = Integer.parseInt(commandStr[1]);
			int totalNoOfSlots = parkingLot.getNumberOfSlots();
			if (slotNumber <= totalNoOfSlots) {
				ParkingSlot parkingSlot = slotParkingSlotMap.get(slotNumber);
				if(parkingSlot != null){
					parkingLot.getParkingSlots().remove(parkingSlot);
					long startTime = parkingSlot.getTimeIn();
					long outTime = System.currentTimeMillis();
					System.out.println("Time for which vehicle is presennt : " + (outTime - startTime) / 1000 + " secs");
					Vehicle vehicle = parkingSlot.getVehicle();
					if(vehicle != null){
						colorParkingSlotMap.get(vehicle.getColor().toLowerCase()).remove(parkingSlot);
						colorVehicleMap.get(vehicle.getColor().trim().toLowerCase()).remove(vehicle);
						parkingSlot.setVehicle(null);
						parkingSlot.setEmpty(true);
						vehicleParkingSlotMap.remove(vehicle);
						parkingLot.setCurrentNoOfSlotsFilled(parkingLot.getCurrentNoOfSlotsFilled() - 1);
						parkingLot.getParkingSlots().add(parkingSlot);
					}
					return "Slot number " + slotNumber + " is free";
				}else{
					System.out.println("There is no vehicle parked at that slot");
				}
				
			} else {
				System.out.println("Please check the slot number to be emptied");
			}
		}
		return null;
	}

	private int parkVehicle(String[] commandEntered) {
		if (parkingLot != null) {
			if (!parkingLot.isFull()) {
				if (commandEntered.length == 3) {
					String vehicleRegNumber = commandEntered[1];
					String color = commandEntered[2];
					Vehicle vehicle = createVehicle(vehicleRegNumber, color);
					ParkingSlot parkingSlot = createParkingSlot(vehicle);

					List<ParkingSlot> parkingSlotList = colorParkingSlotMap.get(color.trim().toLowerCase());
					if (parkingSlotList == null) {
						parkingSlotList = new ArrayList<>();
					}
					parkingSlotList.add(parkingSlot);
					colorParkingSlotMap.put(color.toLowerCase(), parkingSlotList);

					List<Vehicle> vehicleList = colorVehicleMap.get(color.trim().toLowerCase());
					if (vehicleList == null) {
						vehicleList = new ArrayList<>();
					}
					vehicleList.add(vehicle);
					colorVehicleMap.put(color.trim().toLowerCase(), vehicleList);
					vehicleParkingSlotMap.put(vehicle, parkingSlot);
					slotParkingSlotMap.put(parkingSlot.getNumber(), parkingSlot);
					return parkingSlot.getNumber();
				} else {
					System.out.println("Please check the Park Command you have entered.");
				}
				String vehicleRegNum = commandEntered[1];
			} else {
				return -1;
			}

		} else {
			System.out.println("Parking lot is under construction please come later");
		}

		return -1;
	}

	private ParkingSlot createParkingSlot(Vehicle vehicle) {
		PriorityQueue<ParkingSlot> parkingSlots = parkingLot.getParkingSlots();
		ParkingSlot parkingSlot = parkingSlots.poll();
		parkingSlot.setVehicle(vehicle);
		parkingSlot.setTimeIn(System.currentTimeMillis());
		parkingSlot.setEmpty(false);
		parkingLot.setCurrentNoOfSlotsFilled(parkingLot.getCurrentNoOfSlotsFilled() + 1);
		parkingSlots.add(parkingSlot);
		return parkingSlot;
	}

	private Vehicle createVehicle(String vehicleRegNumber, String color) {
		Vehicle vehicle = new Vehicle();
		vehicle.setColor(color);
		vehicle.setRegistrationNumber(vehicleRegNumber);
		return vehicle;
	}

	private ParkingLot createParkingLot(int numberOfSlots) {
		ParkingLot parkingLot = new ParkingLot(numberOfSlots);
		colorParkingSlotMap = new HashMap<>();
		colorVehicleMap = new HashMap<>();
		vehicleParkingSlotMap = new HashMap<>();
		slotParkingSlotMap = new HashMap<>();
		PriorityQueue<ParkingSlot> parkingSlots = parkingLot.getParkingSlots();
		for (int i = 0; i <= numberOfSlots; i++) {
			ParkingSlot parkingSlot = null;
			if(i==0){
				parkingSlot = new ParkingSlot(Integer.MAX_VALUE);
			}else{
				parkingSlot = new ParkingSlot(i);
			}
			parkingSlots.add(parkingSlot);
		}
		return parkingLot;
	}

}
