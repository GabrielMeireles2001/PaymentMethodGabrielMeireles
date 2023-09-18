package payment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {


	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyy");
		
		System.out.println("Digite o número do contrato:");
		int number = sc.nextInt();
		
		System.out.println("Digite a data do contrato:");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		
		System.out.println("Digite o valor total do contrato:");
		Double value = sc.nextDouble();
		
		System.out.println("Digite a quantidade de parcela do contrato");
		int installment = sc.nextInt();
		
		Contract obj = new Contract(number,value,date);
		
		ContractService service = new ContractService();
		
		System.out.println("Digite 1 para método Paypal \nDigite 2 para método MercadoPago");
		int x = sc.nextInt();
		
		if(x==1) service.processContract(obj, installment,new PaypalService());
		else service.processContract(obj, installment,new MercadoLivreService());
		
		System.out.println("\n\nContrato: "+obj.getNumber());
		
		for(int i=1;i<=installment;i++) {
			System.out.println("Parcela "+i+":");
			Double values = obj.ListValues(i-1);
			System.out.println(values);
			System.out.println("Vencimento: "+obj.getInstallmentList().get(i-1).getDueDate().format(fmt)+"\n");
		}
		
		
		
		
		sc.close();
		
	}

}
