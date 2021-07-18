package com.cg.main;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import com.cg.exception.ParkException;


public class ParkingImpl implements Parking{

	
	public ParkingImpl() {
	}

	@Override
	public void createParkingLot(int lotSize) throws ParkException {
		System.out.println("Created a parking lot with "+lotSize+" slots");
		return;
	}
	
	@Override
	public void addPark(int lotSize, HashMap<Integer, Car> slot, Car car) throws ParkException {
		for(int i=0; i<lotSize; i++) {
			if(!slot.containsKey(i+1) && (i+1)<= lotSize) {			
				slot.put(i+1, car);
				System.out.println("Allocated slot number "+(i+1));
				return;
			}
		}
		System.out.println("Sorry, parking lot is full");
		return;
	}

	@Override
	public void leavePark(HashMap<Integer, Car> slot, int emptiedIdx) throws ParkException {
		
		if(slot.containsKey(emptiedIdx)) {
			slot.remove(emptiedIdx);
			System.out.println("Slot number"+emptiedIdx+"is free");
		}
		return;
	}

	@Override
	public void status(int lotSize, HashMap<Integer, Car> slot) throws ParkException {
		
		System.out.println("Slot no.\tRegistration No.\tColour");
		for(int i=0; i<lotSize; i++) {
			if(slot.containsKey(i+1)) {
				System.out.println((i+1)+"\t"+slot.get(i+1).getRegNo()+"\t"+slot.get(i+1).getColor());
			}
		}
		return;
	}

	@Override
	public List<String> findRegNobyColor(int lotSize, HashMap<Integer, Car> slot, String colorToFind) throws ParkException {
		List<String> cars= new ArrayList<String>();
		for(int i=0; i<lotSize; i++) {
			if(slot.containsKey(i+1)) {
				if(colorToFind.equals(slot.get(i+1).getColor())) {
					System.out.print(slot.get(i+1).getRegNo()+", ");
					cars.add(slot.get(i+1).getRegNo());
				}
			}
		}
		System.out.println();
		
		return cars;
	}

	@Override
	public List<Integer> findSlotNobyColor(int lotSize, HashMap<Integer, Car> slot, String colorToFind) throws ParkException {
		var cars= new ArrayList<Integer>();
		for(int i=0; i<lotSize; i++) {
			if(slot.containsKey(i+1)) {
				if(colorToFind.equals(slot.get(i+1).getColor())) {
					System.out.println(i+1);
					cars.add(i+1);
					break;
				}
			}
		}
		return cars;
	}

	@Override
	public int findSlotNobyRegNo(int lotSize, HashMap<Integer, Car> slot, String regNo) throws ParkException {
		for(int i=0; i<lotSize; i++) {
			if(slot.containsKey(i+1)) {
				if(regNo.equals(slot.get(i+1).getRegNo())) {
					System.out.println(i+1);
					break;
				}
			}
		}
		return 0;
	}

}
