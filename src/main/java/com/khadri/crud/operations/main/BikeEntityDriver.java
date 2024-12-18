package com.khadri.crud.operations.main;

import java.util.Scanner;

import com.khadri.crud.operations.entity.Bike;
import com.khadri.crud.operations.repository.BikeEntityManagerRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BikeEntityDriver {

	public static void main(String[] args) {
		BikeEntityDriver driver = new BikeEntityDriver();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		BikeEntityManagerRepository repository = new BikeEntityManagerRepository(entityManagerFactory);
		Scanner sc = new Scanner(System.in);
		Boolean isContinue = false;
		do {
			System.out.println("please choose operation (add/modify/select/delete)");
			String operation = sc.next();
			switch (operation) {
			case "add": {
				System.out.println("please enter bike name");
				String name = sc.next();
				System.out.println("please enter bike company");
				String company = sc.next();
				Bike bike = driver.createBike(null, name, company);
				repository.insertBike(bike);
				System.out.println(bike + "Bike inserted successfully!");

			}
				break;
			case "modify": {
				System.out.println("please enter bike id");
				Integer id = sc.nextInt();
				System.out.println("please enter bike name");
				String name = sc.next();
				System.out.println("please enter bike company");
				String company = sc.next();
				Bike bike = driver.createBike(id, name, company);
				Bike updateBike = repository.updateBike(bike);
				System.out.println(updateBike + "Bike updated successfully!");

			}
				break;
			case "select": {
				System.out.println("please enter bike id");
				Long id = sc.nextLong();
				repository.selectBike(id);
			}
				break;
			case "delete": {
				System.out.println("Please enter bike id:");
				Integer id = sc.nextInt();
				repository.deleteBike(id);
				System.out.println("Bike deleted successfully!");
			}

			default:
				System.out.println("please choose correct operation");
				break;
			}
			System.out.println("Do you want to continue ?(YES/NO) ");
			String wish = sc.next();
			if (wish.equalsIgnoreCase("YES")) {
				isContinue = true;
			} else if (wish.equalsIgnoreCase("NO")) {
				isContinue = false;
			}

		} while (isContinue);
		sc.close();

	}

	public Bike createBike(Integer id, String name, String company) {
		Bike bike = new Bike();
		bike.setId(id);
		bike.setName(name);
		bike.setCompany(company);
		return bike;
	}

}
