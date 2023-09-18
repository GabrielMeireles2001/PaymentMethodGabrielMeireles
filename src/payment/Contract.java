package payment;

import java.time.LocalDate;
import java.util.ArrayList;

public class Contract {
	
	private int number;
	private Double totalValue;
	private LocalDate date;
	private ArrayList<Installment> InstallmentList;

	
	public Contract(int number, Double value, LocalDate date) {
		this.number=number;
		this.totalValue = value;
		this.date = date;
		InstallmentList = new ArrayList<>();
	}
	
	public void ListInsertion(Installment installment) {
		InstallmentList.add(installment);
	}
	
	public Double ListValues(int pos) {
		Double installment;
		installment = InstallmentList.get(pos).getAmount();
		return installment;
	}
	
	public ArrayList<Installment> getInstallmentList() {
		return InstallmentList;
	}


	public void setInstallmentList(ArrayList<Installment> installmentList) {
		InstallmentList = installmentList;
	}



	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	public Double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
