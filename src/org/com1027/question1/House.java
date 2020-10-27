/**
 * 
 */
package org.com1027.question1;
import java.io.*;
import java.util.Map;
import java.util.HashMap;

/**
 * @author agossousara
 *
 */
public class House {
	                                     //fields declaration
	private int houseNumber = 0;
	private String street = null;
	private String City = null;
	private String postCode = null;
	private int numberOfRooms = 0;
	private Map<Room, ITenant> rooms = null;
	private static final String STREET_REGEX = "[A-Z]{1}[a-z]*\\s[A-Z]{1}[a-z]*" ;
	private static final String POST_CODE_REGEX = "([A-Z]{2}[0-9]{1}[A-Z_0-9]{1}\\s[0-9]{1}[A-Z]{2})|([A-Z]{1}[0-9]{1}\\s[0-9]{1}[A-Z]{2})";
	private static final String CITY_REGEX = "[A-Z]{1}[a-z A-Z \\s]*";
	
	
	/**
	 * parametrised constructor
	 * @param houseNumber
	 * @param street
	 * @param City
	 * @param postCode
	 * @param numberOfRooms
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	public House(int houseNumber,String street,String City,String postCode,int numberOfRooms) {
		super();
		
		this.rooms = new HashMap<Room, ITenant>();
		
		if(houseNumber > 0) {
			this.houseNumber = houseNumber;
		}
		else {
			throw new NullPointerException("The house number cannot be 0");
		}
		if(street.matches(STREET_REGEX)) {
			this.street = street;
		}
		else {
			throw new IllegalArgumentException("The street is invalid");
		}
		
		if(City != null) {
			this.City = City;
		}
		else {
			throw new NullPointerException ("The City cannot be left empty");
		}
	   
		   this.postCode = postCode;
	  
	   if(numberOfRooms >0) {
		   this.numberOfRooms = numberOfRooms;
	   }
	   else {
		   throw new NullPointerException("The  number of rooms cannot be 0");
	   }
	}
	                                                      //methods declaration
	
	  /**
	   *  
	   * @return the number of available rooms in the house
	   */
	   public int getAvailableRooms() {
		   int numberOfAvailableRooms = 0;
		   if(rooms.isEmpty()) {
			   numberOfAvailableRooms = this.numberOfRooms;}
		   else { 
		   numberOfAvailableRooms = this.numberOfRooms - this.rooms.size();
			 }
		   return numberOfAvailableRooms;  
	   }
	   /**
	    * 
	    * @return
	    */
	  public double getPrice() {
		  double price = 0;
		  for(Room room : rooms.keySet()) {
			  price += room.getPrice();
		  }
		  return price;
		  
	  }
	  /**
	   * 
	   * @return true or false depending on if he house has available rooms or not
	   */
	  public boolean isAvailable() {
		  boolean availiability = false;
		  if(this.getAvailableRooms() > 0) {
			  availiability = true;}
		  return availiability;
	  }
	  /**
	   * 
	   * @param room
	   * @param tenant
	   */
	  public void occupyRoom(Room room , ITenant tenant){
		   rooms.put(room ,tenant);
			   }
	  /**
	   * @return the informations of a house
	   */
	  @Override
	  public String toString() {
		  
		  StringBuffer houseInformations = new StringBuffer();
		  houseInformations.append(this.houseNumber);
		  houseInformations.append(" "+ this.street + ",");
		  houseInformations.append(" "+ this.City+" ");
		  houseInformations.append(this.postCode);
		  houseInformations.append(" "+"(");
		  houseInformations.append(this.numberOfRooms + " ");
		  houseInformations.append("bedroom house :");
		  houseInformations.append(this.getAvailableRooms());
		  houseInformations.append(" available)");
		  
		  return houseInformations.toString();
	  }
	  /**
	   * 
	   * @param city
	   * @return  true or false depending on if the the city is valid or not
	   */
		public boolean validateCity(String city) {
			boolean validateCity = false;
			if (city.matches(CITY_REGEX)) {
				validateCity = true;
			}
			
			return validateCity;
		}
		/**
		 * 
		 * @param postCode
		 * @return true or false depending on if the the postcode is valid or not
		 */
		public boolean validatePostCode(String postCode) {
			boolean validatePostCode =false;
			if(postCode.matches(POST_CODE_REGEX)) {
				validatePostCode = true;}
			
			return validatePostCode;
		}
		
		
	}
	
	
	


