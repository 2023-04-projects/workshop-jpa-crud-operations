package com.khadri.crud.operations.main;

import java.util.Scanner;

import com.khadri.crud.operations.entity.Mobile;
import com.khadri.crud.operations.repository.MobileEntityManagerRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MobileEntityDriver {

	public static void main(String[] args) {

		MobileEntityDriver mobileEntity = new MobileEntityDriver();

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		MobileEntityManagerRepository repository = new MobileEntityManagerRepository(entityManagerFactory);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose Operation (ADD/MODIFY/SELECT/DELETE) value:");
		String OPERATION = scanner.next();
		Boolean isContinue = false;
		do {
			switch (OPERATION) {
			case "ADD": {
				System.out.println("Please enter mobile name to add");
				String name = scanner.next();
				;

				System.out.println("Please enter mobile phoneNum to add");
				Long phone = scanner.nextLong();

				System.out.println("Please enter mobile price to add");
				double price = scanner.nextDouble();
				Mobile mobile = mobileEntity.createMobile(null, name, phone, price);
				repository.insertMobile(mobile);
				break;
			}
			case "MODIFY": {
				System.out.println("Please enter mobile id to modify");
				Integer id = scanner.nextInt();

				System.out.println("Please enter mobile name to modify");
				String name = scanner.next();
				;

				System.out.println("Please enter mobile phoneNum to modify");
				Long phone = scanner.nextLong();

				System.out.println("Please enter mobile price to modify");
				double price = scanner.nextDouble();
				Mobile mobile = mobileEntity.createMobile(id, name, phone, price);
				Mobile updateMobile = repository.updateMobile(mobile);
				System.out.println("updateMobile");
				break;
			}
			case "SELECT": {
				System.out.println("Please enter mobile id to select");
				Integer id = scanner.nextInt();
				Mobile selectMobile = repository.selectMobile(id);
				System.out.println("selectMobile");

				break;
			}
			case "DELETE": {
				System.out.println("Please enter mobile id to delete");
				Integer id = scanner.nextInt();
				repository.deleteMobile(id);
				System.out.println("deleteMobile");
				break;
			}
			default:
				scanner.close();
				throw new IllegalArgumentException(
						"Please Pass The Operation (ADD/MODIFY/SELECT/DELETE) value :" + OPERATION);
			}
			System.out.println("Do You Want To Continue(YES/NO)?");
			String decision = scanner.next();

			if (isContinue = decision.equalsIgnoreCase("YES")) {
				isContinue = true;
			} else if (isContinue = decision.equalsIgnoreCase("NO")) {
				isContinue = false;
			}

		} while (isContinue);

		scanner.close();

	}

	private Mobile createMobile(Integer id, String name, Long phoneNumber, double price) {
		Mobile mobile = new Mobile();
		mobile.setId(id);
		mobile.setName(name);
		mobile.setPhoneNumber(phoneNumber);
		mobile.setPrice(price);
		return mobile;
	}

}
