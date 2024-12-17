package com.khadri.crud.operations.main;

import java.util.Scanner;

import com.khadri.crud.operations.entity.Employee;
import com.khadri.crud.operations.repository.EmployeeEntityManagerRepsitory;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmployeeDriver {

	public static void main(String[] args) {
		EmployeeDriver empDriver = new EmployeeDriver();

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		EmployeeEntityManagerRepsitory repository = new EmployeeEntityManagerRepsitory(entityManagerFactory);

		Scanner scanner = new Scanner(System.in);
		Boolean isContinue = false;
		do {

			System.out.println("Please Choose Operation (ADD/MODIFY/SELECT/DELETE) values: ");
			String OPERATION = scanner.next();

			switch (OPERATION) {
			case "ADD": {
				System.out.println("Please enter employee name to add  ");
				String empName = scanner.next();

				System.out.println("Please enter employee phoneNumber to add  ");
				Long empPhone = scanner.nextLong();

				Employee employee = empDriver.createEmployee(null, empName, empPhone);
				repository.insertEmployee(employee);
				break;
			}
			case "MODIFY": {
				System.out.println("Please enter employee empId to modify ");
				Integer empId = scanner.nextInt();

				System.out.println("Please enter employee empName to modify ");
				String empName = scanner.next();

				System.out.println("Please enter employee empPhone to modify ");
				Long empPhone = scanner.nextLong();

				Employee employee = empDriver.createEmployee(empId, empName, empPhone);
				Employee updateEmployee = repository.updateEmployee(employee);
				System.out.println("########## Update Employee ##########");
				System.out.println(updateEmployee);
				break;
			}
			case "SELECT": {

				System.out.println("Please enter employee empId to SELECT ");
				Integer empId = scanner.nextInt();

				Employee selectEmployee = repository.selectEmployee(empId);
				System.out.println("########## selectEmployee ##########");
				System.out.println(selectEmployee);
				break;
			}
			case "DELETE": {

				System.out.println("Please enter employee empId to DELETE");
				Integer empId = scanner.nextInt();

				repository.deleteEmployee(empId);
				System.out.println("########## deleteEmployee ##########");
				break;
			}
			default:
				scanner.close();
				throw new IllegalStateException("Invalid operation!!!");

			}
			System.out.println("Do you want to continue (YES/NO)? ");
			String continueChoice = scanner.next();

			if (continueChoice.equalsIgnoreCase("YES")) {
				isContinue = true;
			} else if (continueChoice.equalsIgnoreCase("NO")) {

				isContinue = false;
			}
		} while (isContinue);

		scanner.close();

	}

	private Employee createEmployee(Integer empId, String empName, Long empPhone) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setEmpName(empName);
		employee.setEmpPhone(empPhone);
		return employee;
	}

}
