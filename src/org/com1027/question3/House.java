/**
 * 
 */
package org.com1027.question3 ;

import org.com1027.question3.ITenant;
import org.com1027.question3.Room;


/**
 * @author agossousara
 *
 */
public class House extends Property {
	
	public House(int number,String street,String city,String postCode,int numberOfRooms) {
		super(number, street, city, postCode, numberOfRooms);
	}

	@Override
	public void occupyRoom(Room room, ITenant tenant) {
		super.rooms.put(room,tenant);
		
	}

	@Override
	public boolean isAvailable() {
		 boolean availiability = false;
		  if(this.getAvailableRooms() > 0) {
			  availiability = true;}
		  return availiability;
			
	}

	@Override
	public String displayOccupiedProperty() {
		StringBuffer occupiedPropertyInformations = new StringBuffer();
		double price = 0;
		occupiedPropertyInformations.append(this.toString());
		occupiedPropertyInformations.append("\n");
		for(Room room : rooms.keySet()) {
			price += room.getPrice();
			 occupiedPropertyInformations.append("\tRoom: ");
			 occupiedPropertyInformations.append(room.getPrice());
			 occupiedPropertyInformations.append("\n");
			  
		}
		occupiedPropertyInformations.append("\tTotal: £");
		occupiedPropertyInformations.append(String.format("%.2f",(price*12)));
		occupiedPropertyInformations.append(" (Council Tax: £");
		occupiedPropertyInformations.append(super.councilTax + ")" + "\n");
		return occupiedPropertyInformations.toString();
	}
	
	public String toString() {
		StringBuffer houseInfo = new StringBuffer();
		houseInfo.append(super.toString());
		houseInfo.append("house :");
		houseInfo.append(super.getAvailableRooms());
		houseInfo.append(" available)");
		
		return houseInfo.toString();
	}
	

}
 