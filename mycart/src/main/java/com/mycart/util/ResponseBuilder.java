package com.mycart.util;

import javax.inject.Named;

import org.apache.camel.Exchange;

import com.mycart.model.MyCartResponse;
import com.mycart.model.Item;
//import com.loanbroker.creditbureau.model.CreditScore;

@Named("responseBuilder")
public class ResponseBuilder {
	public void buildResponse(Exchange exchange) {

		MyCartResponse resp = new MyCartResponse();

		if (null != exchange.getProperty(Exchange.EXCEPTION_CAUGHT)) {
			resp.setStatus("Request Failed");
			Throwable exe = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
			resp.setErrMsg(exe.getMessage());
		} else {
			resp.setStatus("Request Success");
			Item i = exchange.getIn().getBody(Item.class);
			resp.setItem(i);
		}
		exchange.getIn().setBody(resp);
	}

}
