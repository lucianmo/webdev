package com.serie4it.sample.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.serie4it.sample.domain.Country;
import com.serie4it.sample.service.WorldService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
* The @Controller annotation designates an arbitrary (POJO) class as a web controller.
* Spring can automatically detect controller classes using class path scanning, and make them available
* to receive requests from end users.
*/
@Controller
public class CountryController {
      static final Logger LOG = LoggerFactory.getLogger(CountryController.class);
      
      static final String URL_COUNTRY_LIST = "/countryList";
      static final String VIEW_COUNTRY_LIST = "/lishman/countryList";
      static final String URL_COUNTRY_DETAILS = "/countryDetails";
      static final String VIEW_COUNTRY_DETAILS = "/lishman/countryDetails";  
      
     //The application will make use of the WorldService business service facade.
     @Autowired
     private WorldService worldService;
     
     /* The @RequestMapping annotation maps web requests to Java classes and methods.
      * The above example maps the URL paths /countryList and /countryDetails to the 
      * getCountries() and getCountry() methods respectively. */        

        /*  Mapped to http://localhost:8080/templateSpring/countryListCreate */
        @RequestMapping(value=URL_COUNTRY_LIST)
        public String getCountriesCreate(Model myModel) {
           LOG.info("Trace getCountriesCreate /lishman/countryList");
           
           Collection<Country> allCountry = worldService.getAllCountries();
           myModel.addAttribute("countries", allCountry);
           return VIEW_COUNTRY_LIST;
        }
                
        /* The @RequestParam annotation binds HTTP request parameters to method arguments in the controller.
         * In our example, the getCountry() method needs to know the identifier of the country that it is to be returned.
         * The @RequestParam annotation takes the 'id' request parameter from the URL, and maps it to the countryId parameter
         * of the method. The parameter is mandatory so the URL must look like this /countryDetails?id=53, or an exception will be thrown.
         */
        /*  Mapped to http://localhost:8080/templateSpring/countryDetailsCreate */
        @RequestMapping(value=URL_COUNTRY_DETAILS)
        public String getCountryCreate(@RequestParam(value="id", required=true) int countryId, Model myModel) {
           Country myCountry = worldService.getCountryById(countryId);
           myModel.addAttribute("country", myCountry);
           return VIEW_COUNTRY_DETAILS;
        }                
}