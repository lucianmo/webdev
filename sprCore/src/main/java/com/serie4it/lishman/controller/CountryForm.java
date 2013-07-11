package com.serie4it.lishman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.serie4it.lishman.domain.Country;
import com.serie4it.lishman.domain.service.MockWorldService;
import com.serie4it.lishman.domain.service.WorldService;

@Controller
@RequestMapping("/countryForm.html")
@SessionAttributes("country")
public class CountryForm {
	
	private WorldService worldService = new MockWorldService();
	
	@RequestMapping(method = RequestMethod.GET)
	public Country setUpForm(@RequestParam(value="id", required = false) Integer countryId) {
		if (countryId == null) {
			return new Country();
		} else {
			return worldService.getCountryById(countryId);
		}
	}
	
	@RequestMapping(params = "create", method = RequestMethod.POST)
	public String create(Country country, BindingResult result, SessionStatus status) {
		return update(country, result, status);
	}
	
	/* The redirect: prefix triggers an HTTP redirect back to the browser. This is necessary when 
	 * delegating the response to another controller, rather than just rendering the view.
	 * 
	 */
	@RequestMapping(params = "update", method = RequestMethod.POST)
	public String update(Country country, BindingResult result, SessionStatus status) {
		worldService.saveCountry(country);
		status.setComplete();
		return "redirect:countryListCreate.html";
	}
	
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public String delete(Country country, BindingResult result, SessionStatus status) {
		worldService.deleteCountry(country);
		status.setComplete();
		return "redirect:countryListCreate.html";
	}	
}
