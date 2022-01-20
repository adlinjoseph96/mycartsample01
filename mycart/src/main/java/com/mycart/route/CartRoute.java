 
package com.mycart.route;

import java.net.HttpURLConnection;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.model.dataformat.JsonLibrary;
import com.mycart.exception.DataNotFoundException;
import com.mycart.exception.BadRequestException;
import com.mycart.exception.NotElegibleException;


//@ContextName("com.mycart.route")
public class CartRoute {// extends RouteBuilder {
	
	/*@Override
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

		from("direct:getItemById")
				.log(LoggingLevel.DEBUG, "The request for getting item by id is invalid")
				//.log(LoggingLevel.INFO, "calling :: CartService->getCreditScore()")
				//.bean("loanBrokerCrediBureauService")
				.log(LoggingLevel.INFO, "calling :: responseBuilder->buildResponse()")
				.bean("responseBuilder")
				.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
				.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(HttpURLConnection.HTTP_OK));

	}*/

}

