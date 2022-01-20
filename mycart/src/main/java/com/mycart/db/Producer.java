package com.mycart.db;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.apache.camel.PropertyInject;
import org.apache.log4j.Logger;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Named
@ApplicationScoped
public class Producer {


	@PropertyInject("mycart.mongo.host.url")
	private String mongodbEndpoints;
    private MongoClient connectionBean;
    //private Document document;
    Logger log = Logger.getLogger(Producer.class);
    
    @Produces
    @Client
    @Named("mydb")
    public MongoClient getMongoClient() {
        return connectionBean;
    }

    @PostConstruct
    public void createConnection() {
        if (connectionBean == null) {
        	
        	log.info("*************************"+mongodbEndpoints+"*******************");
        	String mongoURI="mongodb://localhost:27017/myCart";
			String dbname="myCart";
			//connect to mongo
			MongoClientURI connectionString= new MongoClientURI(mongoURI);
			connectionBean=new MongoClient(connectionString);
             }
    }
    
  /*  @PropertyInject("mycart.mongo.host.url")
	private String mongodbEndpoints;
	@PropertyInject("mycart.mongo.dbname")
	private String dbname;
	
    private MongoClient connectionBean;
    //private Document document;

    @Produces
    @Client
    @Named("mydb")
    public MongoClient getMongoClient() {
        return connectionBean;
    }

    @PostConstruct
    public void createConnection() {
        if (connectionBean == null) {
        	
        	String mongoURI=mongodbEndpoints;
			String dbname="myCart";
			//connect to mongo
			MongoClientURI connectionString= new MongoClientURI(mongoURI);
			connectionBean=new MongoClient(connectionString);
			
        	
        	
             }
            
    } */


}

