package com.cg.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import com.cg.main.Car;
import com.cg.main.Parking;

public class UIClass {

	public static void main(String[] args) throws Exception{
		
		Parking parking= new ParkingImpl();
		File file = new File("C:\\Users\\kaaanand\\Downloads\\Training\\ParkingTest.txt");
		  
		  HashMap<Integer, Car> slot= new HashMap<Integer, Car>();
		  BufferedReader br = new BufferedReader(new FileReader(file));
		  
		  String st;
		  int lotSize=0;
		  if((st=br.readLine()) != null) {
			  String[] firstLine = st.split(" ");
			  lotSize= Integer.parseInt(firstLine[1]);
			  parking.createParkingLot(lotSize);
		  }
		  
		  
		  while ((st = br.readLine()) != null) {
		    // get command
			String[] lineElements= st.split(" ");
		    String cmd=lineElements[0];
		    
		    switch(cmd) {
		    	
		    	case "park" :
		    		Car car= new Car(lineElements[1], lineElements[2]);
		    		parking.addPark(lotSize, slot, car);
		    		
		    	break;
		    	
		    	case "leave" :
		    		int emptiedIdx= Integer.parseInt(lineElements[1]);
		    		parking.leavePark(slot, emptiedIdx);
		    	break;
		    	
		    	case "status" :
		    		parking.status(lotSize, slot);
		    		
		    	break;
		    	case "registration_numbers_for_cars_with_colour" :
		    		String colorToFind= lineElements[1];
		    		parking.findRegNobyColor(lotSize, slot, colorToFind);
		    		
		    	break;
		    	
		    	case "slot_numbers_for_cars_with_colour" :
		    		String colorToFind1= lineElements[1];
		    		parking.findSlotNobyColor(lotSize, slot, colorToFind1);
		    		
		    	break;
		    	
		    	case "slot_number_for_registration_number" :
		    		String regNoToFind= lineElements[1];
		    		parking.findSlotNobyRegNo(lotSize, slot, regNoToFind);
		    		
		    	break;
		    }
		    
		  }
		br.close();
	}

}
