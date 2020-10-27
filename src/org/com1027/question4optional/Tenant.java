/**
 * 
 */
package org.com1027.question4optional;
import java.io.*;

/**
 * @author agossousara
 *
 */
public class Tenant implements ITenant {
	
	
	private String name = null;
	private String surname = null;        //fields declaration
	private int age = 0;
	private TenantType type = null;
	private static final String NAME_REGEX = "[A-Z]{1}[a-z]*";
	
	/**
	 * @param name
	 * @param surname 
	 * @param age  
	 * @param type 
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 * */
	public Tenant(String name,String surname,int age,TenantType type ) throws IllegalArgumentException        //parametrised constructor
	, NullPointerException 
	{
		
		super();
		if(name.matches(NAME_REGEX) && surname.matches(NAME_REGEX)) {
			this.name = name;
			this.surname = surname; 
			}
		else {
			throw new IllegalArgumentException("the tenant's name is invalid");
		}
		
		
		if(age >=0) {
			this.age = age;
		}
		else {
		throw new NullPointerException("the tenant's age cannot be null");}
		
		this.type = type;
		
	}
	
	                                                                                                            //methods declaration 
	/**
	 * @return the type of a tenant
	 */
	@Override
	public TenantType getType() {
		return this.type;
	}
	
	/**
	 * @return the informations of a tenant
	 */
	
	@Override
	public String toString() {
		StringBuffer tenantInformations = new StringBuffer();
		tenantInformations.append(this.name+ " ");
		tenantInformations.append(this.surname);
		
		return tenantInformations.toString();
	}
	/**
	 * @return the age of a tenant
	 * */
	public int getAge() {
		return this.age;
	}

}
