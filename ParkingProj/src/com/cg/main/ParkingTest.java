package com.cg.main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import com.cg.exception.ParkException;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ParkingTest {
	
	ParkingImpl parking;
	HashMap<Integer, Car> slot;
	int lotSize;

	@BeforeEach
	public void setUp() throws Exception {
		
		lotSize = 6;
		slot= new HashMap<Integer, Car>(lotSize);
		parking = new ParkingImpl();
	}

	@AfterEach
	public void tearDown() throws Exception {
		parking = null;
		slot= null;
	}
	
	@Test
	void testAddCarToPark() throws ParkException {
		Car car= new Car("KA-01-HH-1234", "White");
		
		parking.addPark(lotSize, slot, car);
		assertEquals(slot.containsKey(1), true);
	}
	 @Test
	 void testRemoveCar() throws ParkException{
			Car car= new Car("KA-01-HH-1234", "White");
			
			parking.addPark(lotSize, slot, car);
			assertEquals(slot.containsKey(1), true);
			parking.leavePark(slot, 1);
			assertEquals(slot.containsKey(1), false);
	 }
	 
	 @Test
	 void testFindRegNobyColor() throws ParkException{
			Car car= new Car("KA-01-HH-1234", "White");
			
			parking.addPark(lotSize, slot, car);
			var res = parking.findRegNobyColor(lotSize, slot, "White");
			assertFalse(res.isEmpty());
	 }
	 @Test
	 void testFindSlotByColor() throws ParkException{
			Car car= new Car("KA-01-HH-1234", "White");
			
			parking.addPark(lotSize, slot, car);
			var res = parking.findSlotNobyColor(lotSize, slot, "White");
			assertEquals(res.get(0),1);
	 }
}
