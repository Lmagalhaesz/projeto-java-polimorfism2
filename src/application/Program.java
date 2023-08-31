package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers:" );
		Integer n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			System.out.println("Tax payer #" + i+1 + " data:");
			
			System.out.print("Individual or company (i/c)?");
			char res = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.next();
			
			System.out.print("Anual Income: ");
			Double anualIncome = sc.nextDouble();
			
			if(res == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}
			if(res == 'c') {
				System.out.print("Number of employees: ");
				Integer numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		
		System.out.println("TAXES PAID: ");
		double sum = 0.0;
		for(TaxPayer tax : list) {
			System.out.println(tax.getName() + ": $" + tax.tax());
			sum += tax.tax();
		}
		
		System.out.println("TOTAL TAXES: $" + sum);
		
		sc.close();

	}

}
