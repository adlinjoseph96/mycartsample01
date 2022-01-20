package com.mycart.bean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.apache.camel.Exchange;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mycart.db.Client;
import com.mycart.model.Item;

@Named("querybuilder")
@Client


public class Bean {
	
	/*
	public static void findByCategory(String categoryId){
		
		
		String findquery="db.item.find.(${categoryId})";

	}
}
*/
 
	/*public static void findByCategory(String categoryId){
		
		
		myCursor = "db.item.find({categoryId: "${categoryId}"})";
		
		/*while (myCursor.hasNext()) {
    	print(tojson(myCursor.next()));
			}
	
		}
}	
*/		
	

 
	/*
		public static void findByCategory() throws UnknownHostException {
			MongoClient m1 = new MongoClient("localhost");
			DB db = m1.getDB("myCart");
			DBCollection col = db.getCollection("item");

			
			DBObject query = new BasicDBObject("categoryId", cat1);
			// /result stored in cursor using find() method
			DBCursor itemCursor1 = col.find(query);
			System.out.println("нннннн");
			try {
				while (itemCursor1.hasNext()) {
					System.out.println(itemCursor1.next());
				}
			} finally {
				itemCursor1.close();
			}
		}

	
}
	
*/
	
	
	
	
	
	
	
	 public  void findByCategory(final Exchange exchange) {
		   String catId = exchange.getIn().getHeader("categoryId", String.class);
	        BasicDBObject whereQuery = new BasicDBObject();
	        whereQuery.put("categoryId", catId);
	      exchange.getIn().setBody(whereQuery);
	    }
	
	
}
	
	
/*		
	String findquery=	 "db.item.find.(${categoryId})";
	
	 List<ItemDetails> items = new ArrayList();
		 ItemDetails i = new ItemDetails();
		// i.set_id(_id);
		 i.setItemName(itemName);
		 items.add(i);
		 return items;
		// i.setCategoryId("cat4");
		 //i.setLastUpdateDate("lastUpdateDate");
	//	 i.setSpecialProduct("specialProduct");
	//	i.getCategoryId();
		// items.add(i);
		// return items;
	}
}	
	
	
	
	/*public  List<ItemDetails> addItems(){
		 List<ItemDetails> items = new ArrayList();
		 ItemDetails i = new ItemDetails();
		 i.set_id("item4");
		 i.setItemName("table Fan");
		 i.setCategoryId("cat4");
		 //i.setLastUpdateDate("lastUpdateDate");
	//	 i.setSpecialProduct("specialProduct");
	//	i.getCategoryId();
		 items.add(i);
		 return items;
	}	

 */

