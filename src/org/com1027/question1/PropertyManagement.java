 /**
 * 
 */
package org.com1027.question1;
import java.util.*;
import java.io.*;

/**
 * @author agossousara
 *
 */
public class PropertyManagement {
	 
	
	private Agency estateAgency = null;                   //fields declaration 
	private List<House> properties = null; 
	
	/**
	 * 
	 * @param estateAgency
	 */
	
	public PropertyManagement(Agency estateAgency) {    //parametrised constructor
		super();
		this.estateAgency =estateAgency;
		this.properties = new ArrayList<House>();
	}
	
	
	/**
	 * 
	 * @param property
	 */
	
	public void addProperty(House property) { //puts a property in the list of properties
		this.properties.add(property);
	}
	/**
	 * 
	 * @param property
	 * @throws IllegalArgumentException
	 */
	public void removeProperty(House property) throws IllegalArgumentException{
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
	public void addTenant(House property, Room room, Tenant tenant) {
		property.occupyRoom(room, tenant);     //adds a tenant and a room in a given property
		
	}
	/**
	 * 
	 * @return a list of all the properties
	 */
	
	public String displayProperties() {
		String property = "";                        //displays all the properties in a property management 
		if(this.properties.size()>0){
			for(int i = 0 ; i< this.properties.size(); i++) {
			property += (properties.get(i).toString()+ "\n");}
		}
		return property;}
	
	/**
	 * 
	 * @return the informations of an agency
	 */
	
	public String getEstateAgency() {
		return this.estateAgency.toString();
	}
	
	
	
	

}
