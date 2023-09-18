package payment;

import java.time.LocalDate;

public class ContractService {
	
	private OnlinePaymentService paymentService;
	
	public ContractService() {
	}
	
	public void processContract(Contract contract, int months,OnlinePaymentService paymentService) {
		Double totalValue = contract.getTotalValue()/months;
		Double interest,fee,auxValue;
		this.setPaymentService(paymentService);
		
		
		for(int i=1;i<=months;i++) {
			LocalDate auxDate = contract.getDate().plusMonths(i);
			interest = paymentService.interest(totalValue, i);
			auxValue = totalValue+interest;
			fee = paymentService.paymentFee(auxValue);
			
			auxValue = auxValue+fee;
			
			Installment installment = new Installment(auxDate,auxValue);
			contract.ListInsertion(installment);
		}
		
		
	}

	public OnlinePaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	

}
