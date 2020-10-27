package org.com1027.question1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TenantTest {
	
	@Test
	public void testTenant() {
		Tenant validTenant = new Tenant("Michelle","Obama",55, TenantType.PROFESSIONAL);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidTenant1() {
		Tenant invalidTenant1 = new Tenant("donald", "Trump",4, TenantType.STUDENT);
	}
	
	@Test(expected =IllegalArgumentException.class)
	public void testInvalidTenant2() {
		Tenant invalidTenant2 = new Tenant("Karl","Lagerfeld",-10,TenantType.PROFESSIONAL);
	}

	@Test
	public void testGetType() {
		Tenant nana = new Tenant("Naomi","Campbell",49, TenantType.PROFESSIONAL);
		assertEquals(TenantType.PROFESSIONAL, nana.getType());
	}

	@Test
	public void testToString() {
		Tenant tenant1 = new Tenant("Beyonce","Knowles",38,TenantType.PROFESSIONAL);
		assertEquals("Beyonce Knowles", tenant1.toString());
	}

}
