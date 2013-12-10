package com.serie4it.sample.service;

import java.util.Collection;
import com.serie4it.sample.domain.Country;

public interface WorldService {

  public Collection<Country> getAllCountries();

  public Country getCountryById(int countryId);

  public Country getCountryByName(String countryName);

  public void saveCountry(Country country);

  public void deleteCountry(Country country);

}
