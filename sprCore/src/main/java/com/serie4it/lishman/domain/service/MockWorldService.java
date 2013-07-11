package com.serie4it.lishman.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.serie4it.lishman.domain.Country;

public class MockWorldService implements WorldService {

	static Map<Integer, Country> allCountris = new HashMap<Integer, Country>();
	static {
		allCountris.put(14, new Country(14, "Germany", 125485, 5416564L, parseDate("30-nov-2008"), "euro"));
		allCountris.put(48,   new Country(48, "Ghana", 92098,    23837000L,  null, "Cedi"));
		allCountris.put(53,   new Country(53,   "Australia",    2966200,  21884000L,  parseDate("04-sep-2009"),   "Australian Dollar"));
		allCountris.put(73,   new Country(73,   "Greece",       50949,    11257285L,  parseDate("1-jan-2009"),    "Euro"));
		allCountris.put(122,  new Country(122,  "Georgia",      26900,    4382100L,   parseDate("1-jan-2009"),    "Lari"));
		allCountris.put(123,  new Country(123,  "New Zealand",  104454,   4320300L,   parseDate("4-sep-2009"),    "New Zealand Dollar"));
		allCountris.put(147,  new Country(147,  "Gambia",       4361,     1705000L,   null,                       "Dalasi"));
		allCountris.put(149,  new Country(149,  "Gabon",        103347,   1475000L,   null,                       "CFA franc"));		
		
	}
	private static int nextCountryId = 200;
	
	public Collection<Country> getAllCountries() {
		return allCountris.values();
	}

	private static Date parseDate(String textDate) {
		try {
		return new SimpleDateFormat("dd-MMM-yyyy").parse(textDate);
		} catch (ParseException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
		}
	}
	
	public Country getCountryById(int countryId) {
		// Returns a new object and not just a reference
		// to an object in the collection.
		Country returnedCountry = allCountris.get(countryId);		
		return new Country (returnedCountry.getId(),
							returnedCountry.getName(),
							returnedCountry.getArea(),
							returnedCountry.getPopulation(),
							returnedCountry.getPopulationLastUpdated(),
							returnedCountry.getCurrency()
							);
	}

	public Country getCountryByName(String countryName) {
		/* Returns a reference
		 * to an object in the collection
		 */
		Country returnedCountry = null;
		for (Country countryCol : allCountris.values()) {
			if (countryCol.getName().equalsIgnoreCase(countryName)) {
				returnedCountry = countryCol;
			}
		}
		return returnedCountry;		
	}

	public void saveCountry(Country country){
		if (country.isNewcountry())  {
			nextCountryId++;
			country.setId(nextCountryId);
			allCountris.put(nextCountryId, country);
		} else {
			allCountris.put(country.getId(), country);
		}
	}

	public void deleteCountry(Country country){
		allCountris.remove(country.getId());
	}
	  
}
