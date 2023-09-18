package payment;

public class MercadoLivreService implements OnlinePaymentService{

	public Double paymentFee(Double amount) {
		Double fee;
		fee = amount * 0.05;
		return fee;
	}

	public Double interest(Double amount, int month) {
		Double result;
		result = amount*0.02*month;
		return result;
	}

}
