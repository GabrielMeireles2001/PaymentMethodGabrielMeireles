package payment;

public class PaypalService implements OnlinePaymentService {
	
	public PaypalService() {
		
	}
	
	public Double paymentFee(Double amount) {
		Double fee;
		fee = amount * 0.02;
		return fee;
	}
	
	public Double interest(Double amount, int month) {
		Double result;
		result = amount * 0.01 * month;
		return result;
	}


}
