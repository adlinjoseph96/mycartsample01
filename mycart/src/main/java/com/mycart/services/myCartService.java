/*package com.mycart.services;

import javax.inject.Named;

import com.loanbroker.creditbureau.dao.CustomerDetailsDAO;
import com.loanbroker.creditbureau.exception.DataNotFoundException;
import com.loanbroker.creditbureau.exception.NotElegibleException;
import com.loanbroker.creditbureau.model.CreditBureauRequest;
import com.loanbroker.creditbureau.model.CreditScore;
import com.loanbroker.creditbureau.model.CustomerDetails;

@Named("myCartService")
public class myCartService {
	public CreditScore getCreditScore(CreditBureauRequest bureauRequest) throws DataNotFoundException, NotElegibleException {
		CustomerDetailsDAO dao = new CustomerDetailsDAO();
		
		CustomerDetails details = dao.getCustomerDetailsByPanNo(bureauRequest.getPanNO());
		
		if(null == details || !details.getName().equals(bureauRequest.getName())) {
			throw new DataNotFoundException("The requested information is not correct");
		}
		
		if( details.getNumberOfLoansTaken() > 2 && details.getNumberOfLoansFinished() == 0){
			throw new NotElegibleException("This customer not elegble for availing a loan");
		}
		
		// need to use this details and find the score.		
		CreditScore c = new CreditScore(bureauRequest.getPanNO(), bureauRequest.getName(), bureauRequest.getAmount(),
				bureauRequest.getYears());
		return c;
	}

}
*/
