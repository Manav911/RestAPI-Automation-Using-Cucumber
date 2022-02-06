package com.testing.resources;

import java.util.ArrayList;

import com.testing.model.AddPlace;
import com.testing.model.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayLoad()
	{
		AddPlace addPlace = new AddPlace();
		Location location = new Location();
		
		addPlace.setAccuracy(50);
		addPlace.setAddress("3,Vallabh Nagar");
		addPlace.setLanguage("Gujrati");
		addPlace.setPhone_number("123456789");
		addPlace.setWebsite("https://rahulshettyacademy.com");
		addPlace.setName("Shri Hari");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("ABC");
		arrayList.add("DEF");
		addPlace.setTypes(arrayList);
		location.setLat(12.12);
		location.setLng(55.55);
	    addPlace.setLocation(location);
	    
	    return addPlace;
	  
	}

}
