package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		List<Employee> list = new ArrayList<>();

		for(int i=0; i<n; i++) {
			System.out.println("");
			System.out.println("Employee #" + (i+1) + ":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			while(employee.hasId(list, id)) {
				System.out.println(" This Id is already been used! Try again");
				System.out.print("Id: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			list.add(new Employee(id, name, salary));
		}
		
		System.out.println("");
		System.out.print("Enter the employee id that will have a salary increase: ");
		int id = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if(emp == null) {
			System.out.println("This Id doesn't exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.percentageIncrease(percentage);
		}
		
		System.out.println("");
		System.out.println("List of employees: ");
		for (Employee person : list) {
			System.out.println(person);
		}
		
		sc.close();
	}
}
