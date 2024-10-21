package com.tap.factory;

import com.tap.classes.Bike;
import com.tap.classes.Car;
import com.tap.classes.Lorry;
import com.tap.interfaces.Vehicle;

public class VehicleFactory {
public static Vehicle CreateVehicle(String VehicleType) {
	if(VehicleType.equalsIgnoreCase("black")) {
		return new Bike();
	}
	else if(VehicleType.equalsIgnoreCase("green")){
		return new Car();
	}
	else if(VehicleType.equalsIgnoreCase("blue")) {
		return new Lorry();
	}
	else {
		return null;
	}
}
}
