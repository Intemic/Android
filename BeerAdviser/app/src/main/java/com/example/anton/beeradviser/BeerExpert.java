package com.example.anton.beeradviser;

/**
 * Created by Anton on 22.11.2017.
 */

import java.util.*;

public class BeerExpert {
  public static List<String> getBrands(String color) {
    List<String> brands = new ArrayList<String>();
      if (color.equals("светлое")) {
          brands.add("Jack Amber");
          brands.add("Red Moose");
      } else {
          brands.add("Jail Pale Ale");
          brands.add("Gout Stout");
      }
      return brands;
  }
}
