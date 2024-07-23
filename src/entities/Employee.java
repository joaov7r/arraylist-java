package entities;

import java.util.List;

public class Employee {

	private String name;
	private int id;
	private double salary;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	public boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	
	public void percentageIncrease(double percentage) {
		salary += salary * percentage / 100.0;
	}
	
	public String toString() {
		return id + ", " + name + ", " +String.format("%.2f", salary);
	}
}
