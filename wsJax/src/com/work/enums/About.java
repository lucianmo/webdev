package com.work.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * http://javarevisited.blogspot.ca/2011/08/enum-in-java-example-tutorial.html
 * http://javarevisited.blogspot.sg/2011/12/convert-enum-string-java-example.html
 *
 */
public class About {
	   
	   public static void main(String[] args) {
		   System.out.println("Enum value (CONSTANT) for code 3 is: "+Number.get("3"));
		   
		   System.out.println("Code for enum constant THREE is: "+ Number.THREE.getCode());
		   /* Enum value (CONSTANT) for code 3 is: THREE
		    * Code for enum constant THREE is: 3
		    */		   
		   
		   //Convert String to Enum.
		   Country myCountry = Country.fromValue("CANADA");
		   System.out.println(myCountry);
		   
		   //Convert "enum" to String.
		   System.out.println(Country.CANADA.value());
		   
	   }

}

/**
 * The "enum" CONSTANTS are named "values". Ex: ONE, TWO, THREE 
 * The String associated with each "value" is named " code" Ex: "1","2","3"
 * ONE - value ; "1" - code 
 * Each enum value (ONE, TWO, THREE) is an object, he have their own instance variable. ("1","2","3")
 * Then we assign those values at the time the enum is initialized, by passing a value (code "01") to the enum constructor.
 * 
 */
enum Number {
	ONE("1"), // the arguments ("1") after the enum value are "passed" as code to the constructor.
	TWO("2"), 
	THREE("3");
		
	private String code; // an instance variable each enum values has
	
	// This constructor is mandatory when a value is associated for each CONSTANT.
	private Number (String code){
		this.code = code;
	}

	// get code from an enum value (CONSTANT). Ex: Number.THREE.getCode()
	public String getCode() {
		return code;
	}
	
	// For a given code (Ex: "3") the method return an enum value (CONSTNAT) associated. Ex: THREE
	// the argument "String value" must be "1","2","3"
	public static Number get(String value) {
		
		for (Number enumconstant : values()) {
			if(enumconstant.getCode().equals(value)) return enumconstant;
		}
		
		if (StringUtils.isNotBlank(value))
			System.out.println("Number '" + value + "' is not found");
			
		return null;
	}
	
}

/* http://javarevisited.blogspot.ca/2011/08/enum-in-java-example-tutorial.html
 * http://javarevisited.blogspot.sg/2011/12/convert-enum-string-java-example.html
 */
enum Country {
	CANADA("ca"),
	ENGLAND("en"),
	FRANCE("fr");
	
	private String code;
	
	private Country (String code) {
		this.code = code;
	}
	
	//Convert "enum" to String. Use the predefined method name(). Ex: Country.
	public String value() {
		return name();
	}
	
	//Convert String to Enum. 
	public static Country fromValue(String v) {
		 return valueOf(v);
	}
}