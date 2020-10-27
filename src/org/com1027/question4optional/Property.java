/**
 * 
 */
package org.com1027.question4optional;

import java.util.HashMap;
import java.util.Map;

import org.com1027.question4optional.ITenant;
import org.com1027.question4optional.Room;

/**
 * @author agossousara
 *
 */
public abstract class Property {
    //fields declaration
private int number = 0;
private String street = null;
private String city = null;
private String postCode = null;
private int numberOfRooms = 0;
protected Map<Room, ITenant> rooms = null;
private static final String STREET_REGEX = "[A-Z][a-z]+[\\s]*[A-Z a-z \\s]*" ;
private static final String POST_CODE_REGEX = "([A-Z]{2}[0-9]{1}[A-Z_0-9]{1}\\s[0-9]{1}[A-Z]{2})|([A-Z]{1}[0-9]{1}\\s[0-9]{1}[A-Z]{2})";
private static final String CITY_REGEX = "[A-Z]{1}[a-z A-Z \\s]*";
protected double councilTax=0;
//[A-Z]{1}[a-z]*[\\s-A-Z-a-z]*"


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
public Property(int number,String street,String city,String postCode,int numberOfRooms) {
super();

this.rooms = new HashMap<Room, ITenant>();

if(number > 0) {
this.number = number;
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

if(city != null) {
this.city = city;
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



//abstract methods
 
public abstract void occupyRoom(Room room, ITenant tenant);

public abstract boolean isAvailable();

public abstract String displayOccupiedProperty();



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
* @return the informations of a house
*/
@Override
public String toString() {

StringBuffer houseInformations = new StringBuffer();
houseInformations.append(this.number);
houseInformations.append(" "+ this.street + ",");
houseInformations.append(" "+ this.city+" ");
houseInformations.append(this.postCode);
houseInformations.append(" "+"(");
houseInformations.append(this.numberOfRooms + " ");
houseInformations.append("bedroom ");


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
/**
 *@param councilTax
 * */
public void setCouncilTax(double councilTax) {
	int numberOfProfessionals = 0;
	for(ITenant tenant :rooms.values()) {
		if (tenant.getType() == TenantType.PROFESSIONAL) {numberOfProfessionals++;}
	}
	if(numberOfProfessionals == 0) {
		this.councilTax = 0;
	}
	
	else if(numberOfProfessionals ==1 && rooms.size()==1) {
		this.councilTax = (councilTax -(councilTax* 0.25));
	}
	else if(numberOfProfessionals ==1 && rooms.size()>1) {
		this.councilTax = (councilTax -(councilTax* 0.25));
	}
	else if(numberOfProfessionals == rooms.size()) {
		this.councilTax = councilTax;
	}
	else {this.councilTax = councilTax;}
}
	
	

}


