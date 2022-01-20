package com.mycart.model;
/*package com.mycart.item.model;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.json.JSONArray;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class MongoBean {

		private MongoClient mongoClient;
		private MongoCollection mycartCollection;
		
		public MongoBean() {
			super();
			setup();
		}

		private void setup() {
			String mongoURI="mongodb://localhost:27017/mycart";
			String dbname="mycart";
			
			//connect to mongo
			MongoClientURI connectionString= new MongoClientURI(mongoURI);
			mongoClient=new MongoClient(connectionString);
			
			MongoDatabase db=mongoClient.getDatabase(dbname);
			if(db==null){
				System.out.println("ERROR: mongodb handle is null");
				
			}
			else{
				this.mycartCollection=db.getCollection("item");
				//this.mycartCollection=db.getCollection("category");
				
				if(mycartCollection==null){
					System.out.println("ERROR: collections are null");
				}
			}
			
			
			
		}
		
		public  List<ItemDetails> findAllItems(){
		 List<ItemDetails> items = new ArrayList();
		 ItemDetails i = new ItemDetails();
		 i.set_id("1");
i.setItemName("simple");
items.add(i);
		/* JSONArray results=new JSONArray();
			FindIterable<Document> search=this.mycartCollection.find();
			for(Document d: search){
				d.remove("_id");
				results.put(d);
			}
			return results;
			*/
/*
return items;
			
		}
		
		
		

		/*public JSONArray findItemById(){
			
			JSONArray results=new JSONArray();
			FindIterable<Document> search=this.mycartCollection
					.find(new BasicDBObject(id));
			
			return results;
			
		}*/
		
	/*	
		private MongoCollection getCartCollection(){
			setup();
			return this.mycartCollection;
			
		}
		
		private void cleanup(){
			mongoClient.close();
		}
		
		
}*/
