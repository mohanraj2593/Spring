package com.tap.gov;

public class PrimeMinister {
public String name="Namo";
private static PrimeMinister pm = new PrimeMinister();
private  PrimeMinister() {
	
}
 public  static PrimeMinister getPm() {
	return pm;
}

}
