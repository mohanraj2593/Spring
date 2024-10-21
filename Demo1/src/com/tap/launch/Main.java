package com.tap.launch;
import com.tap.classes.Bike;
import com.tap.classes.Car;
import com.tap.classes.Lorry;
import com.tap.factory.VehicleFactory;
import com.tap.interfaces.Vehicle;

public class Main {
	

	

	
	public static  void main(String args[]) {
		Vehicle vehicle1=VehicleFactory.CreateVehicle("black");
		vehicle1.drive();
		Vehicle vehicle2=VehicleFactory.CreateVehicle("green");
		vehicle2.drive();
		Vehicle vehicle3=VehicleFactory.CreateVehicle("blue");
		vehicle3.drive();
	}
	}


