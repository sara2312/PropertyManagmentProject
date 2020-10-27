/**
 * 
 */
package org.com1027.question4optional;

import org.com1027.question4optional.ITenant;
import org.com1027.question4optional.Room;

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
		occupiedPropertyInformations.append(this.toString());
		for(Room room : rooms.keySet()) {
			 occupiedPropertyInformations.append("Room: ");
			 occupiedPropertyInformations.append(room.getPrice());
			  occupiedPropertyInformations.append("/n");}
			  double price = 0;
			  for(Room Room : rooms.keySet()) {
				  price += Room.getPrice();
			  }
			  occupiedPropertyInformations.append("Total: £");
			  occupiedPropertyInformations.append(price*12);
			  
		
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
 