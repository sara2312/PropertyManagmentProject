/**
 * 
 */
package org.com1027.question3;
import java.util.*;
import java.io.*;

/**
 * @author agossousara
 *
 */
public class PropertyManagement {
	 
	
	private Agency estateAgency = null;                   //fields declaration 
	private List<Property> properties = null; 
	
	/**
	 * 
	 * @param estateAgency
	 */
	
	public PropertyManagement(Agency estateAgency) {
		super();
		this.estateAgency =estateAgency;
		this.properties = new ArrayList<Property>();
	}
	
	
	/**
	 * 
	 * @param property
	 */
	
	public void addProperty(Property property) {
		this.properties.add(property);
	}
	/**
	 * 
	 * @param property
	 * @throws IllegalArgumentException
	 */
	public void removeProperty(Property property) throws IllegalArgumentException{
		if(this.properties.contains(property)) {
			
			this.properties.remove(property);
		}
		else {
			throw new IllegalArgumentException("This house is not in the records ");}
		}
	/**
	 * 
	 * @param property
	 * @param room
	 * @param tenant
	 */
	public void addTenant(Property property, Room room, ITenant tenant) {
		property.occupyRoom(room, tenant);
		
	}
	/**
	 * 
	 * @return a list of all the properties
	 */
	
	public String displayProperties() {
		String property = "";
		if(this.properties.size()>0){
			for(Property houseOrFlat : this.properties) {
				
				if(houseOrFlat.isAvailable()) {
					property += (houseOrFlat.toString()+ "\n");}
					
			
				else if(!houseOrFlat.isAvailable()) {
					property += (houseOrFlat.displayOccupiedProperty());
					}
					
				}
		}
		
		return property;
	}
	
	/**
	 * 
	 * @return the informations of an agency
	 */
	
	public String getEstateAgency() {
		return this.estateAgency.toString();
	}
	/**
	 * return the percentage of exempt houses
	 * */
	public double percentageCouncilTaxExemption() {
		double percentageConcilTaxExemptions = 0;
		int numberOfexempts = 0;
		for(Property property: this.properties) {
			if (property.councilTax ==0 && !property.isAvailable()) {
				numberOfexempts++;
			}   }
			percentageConcilTaxExemptions = (numberOfexempts * 100)/properties.size();
		return percentageConcilTaxExemptions;
		}
	
	public String displayAllCouncilTaxExemptProperties() {
		String display = null;
	for(Property property: this.properties) {
		if(property.councilTax == 0 && !property.isAvailable()) {
			display= property.displayOccupiedProperty();
		}
		
		
	}
	
	return display;
	}
	

}
	
	
	


