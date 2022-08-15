package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n;
		List<Employee> employees = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			
			System.out.println();
			System.out.println("Employee " + (i + 1) + ": ");
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			while (hasId(employees, id)) {
				System.out.print("This id alredy exists! Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			
			employees.add(emp);
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have the salary increased: ");
		int idAumento = sc.nextInt();
		
		//Integer pos = getPosition(employees, idAumento);
		Employee emp = employees.stream().filter(x -> x.getId() == idAumento).findFirst().orElse(null);
		
		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			emp.increaseSalary(percent);
		}
		
		System.out.println();
		System.out.println("List of employees: ");
		for (Employee e : employees) {
			System.out.println(e.toString());
		}
		
		sc.close();
	}
	
	public static Integer getPosition(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean hasId(List<Employee> employees, int id) {
		Employee emp = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
