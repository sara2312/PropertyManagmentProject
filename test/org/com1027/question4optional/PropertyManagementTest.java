package org.com1027.question4optional;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;



public class PropertyManagementTest {

	@Test
	public void testAddProperty() {
		Agency estate = new Agency("Simple Lettings", "01234 567890");
		PropertyManagement pm = new PropertyManagement(estate);
		Property house = new House(1, "Percy Road", "Guildford", "GU2 7XH", 2);

		pm.addProperty(house);

		assertEquals("1 Percy Road, Guildford GU2 7XH (2 bedroom house :2 available)\n", pm.displayProperties());

	}

	@Test
	public void testAddTenant() {
		Agency estate = new Agency("Simple Lettings", "01234 567890");
		PropertyManagement pm = new PropertyManagement(estate);

		Property house1 = new House(1, "Percy Road", "Guildford", "GU2 7XH", 2);
		Property house2 = new House(1, "The Chase", "Guildford", "GU2 7UB", 5);

		Room room1 = new Room(900);
		Room room2 = new Room(1000);

		Tenant tenant1 = new Tenant("Alice", "Wonderland", 18, TenantType.STUDENT);
		Tenant tenant2 = new Tenant("Stella", "Kazamia", 50, TenantType.PROFESSIONAL);

		pm.addProperty(house1);
		pm.addProperty(house2);

		pm.addTenant(house1, room1, tenant1);

		assertEquals(
				"1 Percy Road, Guildford GU2 7XH (2 bedroom house :1 available)\n"
						+ "1 The Chase, Guildford GU2 7UB (5 bedroom house :5 available)\n" + "",
				pm.displayProperties());
	}

	@Test
	public void testDisplayHouses() {
		Agency estate = new Agency("Simple Lettings", "01234 567890");
		PropertyManagement pm = new PropertyManagement(estate);

		Property house1 = new House(1, "Percy Road", "Guildford", "GU2 7XH", 2);
		Property house2 = new House(1, "The Chase", "Guildford", "GU2 7UB", 5);

		Room room1 = new Room(900);
		Room room2 = new Room(1000);

		Tenant tenant1 = new Tenant("Alice", "Wonderland", 18, TenantType.STUDENT);
		Tenant tenant2 = new Tenant("Stella", "Kazamia", 50, TenantType.PROFESSIONAL);

		pm.addProperty(house1);
		pm.addProperty(house2);

		pm.addTenant(house1, room1, tenant1);
		pm.addTenant(house2, room2, tenant2);

		assertEquals("1 Percy Road, Guildford GU2 7XH (2 bedroom house :1 available)\n"
				+ "1 The Chase, Guildford GU2 7UB (5 bedroom house :4 available)\n", pm.displayProperties());
	}

	@Test
	public void testGetEstateAgency() {
		Agency estate = new Agency("Simple Lettings", "01234 567890");
		PropertyManagement pm = new PropertyManagement(estate);

		assertEquals("Agency: Simple Lettings, Phone Number: 01234 567890", pm.getEstateAgency());
	}

	
	@Test
	public void testPropertyManagement() {
		Agency estate = new Agency("Simple Lettings", "01234 567890");
		PropertyManagement pm = new PropertyManagement(estate);

		assertEquals("", pm.displayProperties());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveInvalidProperty() {
		Agency estate = new Agency("Simple Lettings", "01234 567890");
		PropertyManagement pm = new PropertyManagement(estate);

		Property house1 = new House(1, "Percy Road", "Guildford", "GU2 7XH", 2);

		pm.removeProperty(house1);
	}

	@Test
	public void testRemoveProperty() {
		Agency estate = new Agency("Simple Lettings", "01234 567890");
		PropertyManagement pm = new PropertyManagement(estate);

		Property house1 = new House(1, "Percy Road", "Guildford", "GU2 7XH", 2);
		Property house2 = new House(1, "The Chase", "Guildford", "GU2 7UB", 5);

		Room room1 = new Room(900);

		Tenant tenant1 = new Tenant("Alice", "Wonderland", 18, TenantType.STUDENT);

		pm.addProperty(house1);
		pm.addProperty(house2);

		pm.addTenant(house1, room1, tenant1);

		pm.removeProperty(house2);

		assertEquals("1 Percy Road, Guildford GU2 7XH (2 bedroom house :1 available)\n", pm.displayProperties());
	}


	/**
	 * testInfographic
	 * 
	 * 1. Create a new estate agency 
	 * 2. Create a property management object 
	 * 3. Create new different properties (2 houses, 3 flats) that: 
	 * a. All of them are of single occupancy 
	 * 4. Assign only students in the two houses (of ages 18 and 26 respectively) 
	 * 5. Assign only professionals in the three flats (of ages 27, 35 and 50
	 * respectively) 
	 * 6. Check that all properties are occupied 
	 * 7. Test whether the infographics returned match the expected output
	 * 
	 * Note: Infographics can be in the form of a histogram, summary of percentages
	 * for each age group, etc. You can also store the information to a file and 
	 * retrieve them. The purpose for this question is to give you some freedom in
	 * experimenting with advanced OOP concepts.
	 */

	@Test
	public void testInfographic() {
		
		Agency estate = new Agency("Simple Lettings", "01234 567890");  //creating an agency and a property management
		PropertyManagement pm = new PropertyManagement(estate);

		Property house1 = new House(1, "Percy Road", "Guildford", "GU2 7XH", 2);        //creating a house and a flat and adding them in the 
		Property flat1 = new Flat(30, "Silverthorne Drive", "Reading", "RG4 7NS",2,3);   //property management created
		Room room1 = new Room(900);
		pm.addProperty(house1);
		pm.addProperty(flat1);
        
		ITenant tenant1 = new Tenant("Alice", "Wonderland", 0, TenantType.STUDENT);
        ITenant tenant2 = new Tenant("Alice", "Wonderland", 12, TenantType.STUDENT);
        ITenant tenant3 = new Tenant("Alice", "Wonderland", 16, TenantType.STUDENT);
        ITenant tenant4 = new Tenant("Alice", "Wonderland", 17, TenantType.STUDENT);   //creating some tenants and adding them to both the house and the flat
        ITenant tenant5 = new Tenant("Alice", "Wonderland", 18, TenantType.STUDENT);
        ITenant tenant6 = new Tenant("Alice", "Wonderland", 26, TenantType.STUDENT);
        ITenant tenant7 = new Tenant("Alice", "Wonderland", 30, TenantType.STUDENT);
        ITenant tenant8 = new Tenant("Alice", "Wonderland", 49, TenantType.STUDENT);
        ITenant tenant9 = new Tenant("Alice", "Wonderland", 50, TenantType.STUDENT);
        ITenant tenant10 = new Tenant("Alice", "Wonderland", 51, TenantType.STUDENT);
        ITenant tenant11 = new Tenant("Alice", "Wonderland", 55, TenantType.STUDENT);
        ITenant tenant12 = new Tenant("Alice", "Wonderland", 60, TenantType.STUDENT);
        ITenant tenant13 = new Tenant("Alice", "Wonderland", 75, TenantType.STUDENT);

		
		
		pm.addTenant(flat1, room1, tenant1);
		pm.addTenant(flat1, room1, tenant2);
		pm.addTenant(flat1, room1, tenant7);
		pm.addTenant(flat1, room1, tenant8);
		pm.addTenant(flat1, room1, tenant9);
		pm.addTenant(flat1, room1, tenant13);
		
		pm.addTenant(house1, room1, tenant3);
		pm.addTenant(house1, room1, tenant4);
		pm.addTenant(house1, room1, tenant5);
		pm.addTenant(house1, room1, tenant6);
		pm.addTenant(house1, room1, tenant10);
		pm.addTenant(house1, room1, tenant11);
		pm.addTenant(house1, room1, tenant12);
		
		
		pm.testInfographics();
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
