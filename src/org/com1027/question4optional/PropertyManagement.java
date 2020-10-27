/**
 * 
 */
package org.com1027.question4optional;
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
	
	/**
	 * this method will for each property in the list of properties display on the screen an attempted barchart 
	 * made of (*) representing for each age category one tenamt of that age 
	 *  */
	
	public void testInfographics() {
		StringBuffer age0to16Info = new StringBuffer();
		StringBuffer age17to25Info = new StringBuffer();
		StringBuffer age26to35Info = new StringBuffer();
		StringBuffer age36to49Info = new StringBuffer();
		StringBuffer age50to60Info = new StringBuffer();
		StringBuffer ageMoreThan60Info = new StringBuffer();
		StringBuffer barChart = new StringBuffer();
		
		
			for (int i = 0; i< properties.size(); i++) {
			Property property = properties.get(i);
			for(Room room : property.rooms.keySet() ) {
				ITenant tenant  = property.rooms.get(room);
				 int tenantAge = ((Tenant)tenant).getAge();
				 
				if (0<= tenantAge && tenantAge<= 16) {
					age0to16Info.append("*");
				}
					else if(17<= tenantAge && tenantAge<= 25) {
						age17to25Info.append("*");
				}
					else if(26<= tenantAge && tenantAge<= 35) {
						age26to35Info.append("*");
				}
					else if(36<= tenantAge && tenantAge<= 49) {
						age36to49Info.append("*");
				}
					else if(50<= tenantAge && tenantAge<= 60) {
						age50to60Info.append("*");
					}
					else if(tenantAge> 60) {
						ageMoreThan60Info.append("*");}
			}
				
			}
			
			barChart.append("Tenants aged 0 to 16:\t"+age0to16Info.toString() + "\n");
			barChart.append("Tenants aged 17 to 25:\t"+age17to25Info.toString() + "\n");
			barChart.append("Tenants aged 26 to 35:\t"+age26to35Info.toString() + "\n");
			barChart.append("Tenants aged 36 to 49:\t"+age36to49Info.toString() + "\n");
			barChart.append("Tenants aged 50to 60:\t"+age50to60Info.toString() + "\n");
			barChart.append("Tenants aged more than 60:\t"+ageMoreThan60Info.toString() + "\n");
			
			System.out.println(barChart.toString());
		
		}
	

}
	
	
	


