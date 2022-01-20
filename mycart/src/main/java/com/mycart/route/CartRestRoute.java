package com.mycart.route;


import java.net.HttpURLConnection;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.PropertyInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;

import com.mongodb.client.model.Filters;
import com.mycart.bean.Bean;
import com.mycart.exception.DataNotFoundException;
import com.mycart.exception.NotElegibleException;
import com.mycart.model.Item;




public class CartRestRoute extends RouteBuilder {
	
	public static final String APPLICATION_JSON="application/json";
	public static final String TEXT_PLAIN="text/plain";
	
	@PropertyInject("mycart.mongo.dbname")
	private String dbname;
	@Override
	public void configure() throws Exception {
		
		onException(DataNotFoundException.class).handled(true)
		.log(LoggingLevel.ERROR, " >> ${property." + Exchange.EXCEPTION_CAUGHT + "}")
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(HttpURLConnection.HTTP_NOT_FOUND))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json")).bean("responseBuilder")
		.marshal().json(JsonLibrary.Jackson);

		onException(NotElegibleException.class).handled(true)
		.log(LoggingLevel.ERROR, " >> ${property." + Exchange.EXCEPTION_CAUGHT + "}")
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(HttpURLConnection.HTTP_NOT_ACCEPTABLE))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json")).bean("responseBuilder")
		.marshal().json(JsonLibrary.Jackson);

		onException(Throwable.class).handled(true)
		.log(LoggingLevel.ERROR, " >> ${property." + Exchange.EXCEPTION_CAUGHT + "}")
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(HttpURLConnection.HTTP_INTERNAL_ERROR))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json")).bean("responseBuilder")
		.marshal().json(JsonLibrary.Jackson);
		
		restConfiguration()
		.host("localhost").port("8081")
		.component("servlet").bindingMode(RestBindingMode.json)
		.jsonDataFormat("json-jackson")
		.endpointProperty("servletName","CamelServlet");
		
		rest("/iteminfo")
			.get().produces(APPLICATION_JSON).to("direct:getAllItem")
			.get("{_id}").produces(APPLICATION_JSON).to("direct:getItemById")
			.post("/insert").produces(TEXT_PLAIN).to("direct:putItem");
		
		
		from("direct:getAllItem")
		 .to("mongodb:mydb?database=myCart&collection=ItemDetails&operation=findAll")
		// .to("mongodb:mydb?database={{mycart.mongo.dbname}}&collection={{mycart.mongo.collection.item.name}}&operation=findAll")
		 //.to("mongodb:mongoC?database="+dbname+"&collection=item&operation=findAll")
		//.convertBodyTo(String.class)
		.setHeader(Exchange.CONTENT_TYPE,simple(APPLICATION_JSON));
		
		
		from("direct:getItemById")
		.setBody(simple("${header.id}"))
		.to("mongodb:mongoC?database="+dbname+"&collection=ItemDetails&operation=findById")
		//.to("mongodb:mongoC?database="+dbname+"&collection={{mycart.mongo.collection.item.name}}&operation=findAll")
		//.to("mongodb:mydb?database=myCart&collection=ItemDetails&operation=findById")
		//.convertBodyTo(String.class)
		.setHeader(Exchange.CONTENT_TYPE,simple(APPLICATION_JSON));
		
		from("direct:putItem")
        .to("mongodb:myDb?database=myCart&collection=ItemDetails&operation=insert");
		//System.out.println("Item added successfully");
		 			
		
		
	
	}
}


	


