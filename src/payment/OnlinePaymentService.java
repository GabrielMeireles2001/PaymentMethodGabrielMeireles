package payment;

public interface OnlinePaymentService {
	
	Double paymentFee(Double amount);
	
	Double interest(Double amount,int months);

}
