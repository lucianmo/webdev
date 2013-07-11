package com.serie4it.lishman.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.serie4it.lishman.domain.Country;
import com.serie4it.lishman.domain.service.MockWorldService;
import com.serie4it.lishman.domain.service.WorldService;

/*
 * The @Controller annotation designates an arbitrary (POJO) class as a web controller. 
 * Spring can automatically detect controller classes using class path scanning, and make them available 
 * to receive requests from end users.
 */
@Controller
public class CountryController {

	//The application will make use of the WorldService business service facade.
	@Autowired
	private WorldService worldService;
	
	/* The @RequestMapping annotation maps web requests to Java classes and methods. 
	 * The above example maps the URL paths /countryList.html and /countryDetails.html to the getCountries() and getCountry() methods respectively.
		
	 * The @ModelAttribute annotation binds the return value of a method to a named attribute in the model. 
	 * The getCountries() method returns a collection of Country JavaBeans, and the @ModelAttribute annotation 
	 * binds it to an attribute called "countries", for subsequent retrieval by the view.  
	 */
	@RequestMapping("/countryList.html")
	@ModelAttribute("countries")
	public Collection<Country> getCountries() {
		return worldService.getAllCountries();
		//The Logical View Name to inform Spring which particular view is to be displayed.
		//By default, this is derived from the URL path of our request. For example: /countryList.html produces a view name of countryList
	}

	@RequestMapping("/countryListCreate.html")
	@ModelAttribute("countries")
	public Collection<Country> getCountriesCreate() {
		return worldService.getAllCountries();
		//The Logical View Name to inform Spring which particular view is to be displayed.
		//By default, this is derived from the URL path of our request. For example: /countryList.html produces a view name of countryList
	}
	
	/* The getCountry() method also returns a Country object into the model, but this time no @ModelAttribute annotation is specified. 
	 * In this case, Spring uses the non-qualified class name, country, as the attribute name. 
	 * for consistency and clarity, we could include @ModelAttribute("country") on the getCountry() method, 
	 * but this is purely a matter of choice. 
	 */
	@RequestMapping("/countryDetails.html")
	public Country getCountry(@RequestParam(value="id", required=true) int countryId) {
		return worldService.getCountryById(countryId);
	}	
	
	/* The @RequestParam annotation binds HTTP request parameters to method arguments in the controller. 
	 * In our example, the getCountry() method needs to know the identifier of the country that it is to be returned. 
	 * The @RequestParam annotation takes the 'id' request parameter from the URL, and maps it to the countryId parameter
	 * of the method. The parameter is mandatory so the URL must look like this /countryDetails.html?id=53, or an exception will be thrown.
	 */
	
	@RequestMapping("/countryDetailsCreate.html")
	public Country getCountryCreate(@RequestParam(value="id", required=true) int countryId) {
		return worldService.getCountryById(countryId);
	}		
}
