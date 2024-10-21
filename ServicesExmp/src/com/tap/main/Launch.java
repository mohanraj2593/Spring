package com.tap.main;

import com.tap.gov.Services;
import com.tap.service.IndianAirForce;
import com.tap.service.IndianArmy;
import com.tap.service.IndianNavy;

public class Launch {
public static void main(String args[]) {
	Services ia = new IndianArmy();
	ia.addressPm();
	Services in = new IndianNavy();
	in.addressPm();
	Services iaf = new IndianAirForce();
	iaf.addressPm();
}
}
