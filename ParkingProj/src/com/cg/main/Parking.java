package com.cg.main;
import com.cg.main.Car;
import java.util.HashMap;
import java.util.List;

import com.cg.exception.ParkException;

public interface Parking {
	
	public void createParkingLot(int lotSize) throws ParkException;
	
	public void addPark(int lotSize, HashMap<Integer, Car> slot, Car car) throws ParkException;
	
	public void leavePark(HashMap<Integer, Car> slot, int emptiedIdx) throws ParkException;
	
	public void status(int lotSize, HashMap<Integer, Car> slot) throws ParkException;
	
	public List<String> findRegNobyColor(int lotSize, HashMap<Integer, Car> slot, String colorToFind) throws ParkException;
	
	public List<Integer> findSlotNobyColor(int lotSize, HashMap<Integer, Car> slot, String colorToFind) throws ParkException;
	
	public int findSlotNobyRegNo(int lotSize, HashMap<Integer, Car> slot, String regNo) throws ParkException;
	
	
}
