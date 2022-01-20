package com.mycart.db;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.apache.camel.component.properties.PropertiesComponent;

public class PropertiesComponentProducer {
	@Produces
	@Named("properties")
	public PropertiesComponent propertiesComponent() {
		
	PropertiesComponent pc = new PropertiesComponent();

	pc.setLocation("file:C:\\Users\\Jiji\\Desktop\\mycart.properties");
	return pc;
	}
	

}
