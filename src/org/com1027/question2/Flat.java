/**
 * 
 */
package org.com1027.question2;

import org.com1027.question2.ITenant;
import org.com1027.question2.Room;

/**
 * @author agossousara
 *
 */
public class Flat extends Property {
	private int floor = 0;
	public Flat(int number,String street,String city,String postCode,int numberOfRooms, int floor) {
		super(number, street, city, postCode, numberOfRooms);
		
			this.floor = floor;
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
			  occupiedPropertyInformations.append(((price*12)+500));
			  
		
		return occupiedPropertyInformations.toString();}
		
		public String toString() {
			StringBuffer flatInfo = new StringBuffer();
			flatInfo.append(super.toString());
			flatInfo.append("flat on ");
			flatInfo.append(this.floor + " floor :");
			flatInfo.append(super.getAvailableRooms());
			flatInfo.append(" available)");
			
			return flatInfo.toString();
		}
	

}
