package com.khadri.crud.operations.main;

import java.util.Scanner;

import com.khadri.crud.operations.pharmacy.Tablet;
import com.khadri.crud.operations.repository.TabletEntityManagerRepsoitory;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TabletDriver {
	public static void main(String[] args) {
		TabletDriver tabletDriver = new TabletDriver();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
		TabletEntityManagerRepsoitory tabletEntityManagerRepsoitory = new TabletEntityManagerRepsoitory(
				entityManagerFactory);

		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		do {

			System.out.println("Place Enter Operation Type (ADD/MODIFY/SELECT/DELETE) Value: ");
			String operation = scanner.next();
			switch (operation) {
			case "ADD": {
				System.out.println("Place Enter TabletName to add");
				String tabletName = scanner.next();
				System.out.println("Place Enter TabletQty to add");
				int tabletQty = scanner.nextInt();
				System.out.println("Place Enter TabletPrice to add");
				double tabletPrice = scanner.nextDouble();

				Tablet tablet = tabletDriver.createTablet(null, tabletName, tabletQty, tabletPrice);
				tabletEntityManagerRepsoitory.insertTablet(tablet);
				break;

			}
			case "MODIFY": {
				System.out.println("Place Enter Tablet Id to Modify");
				Integer id = scanner.nextInt();
				System.out.println("Place Enter Tablet Name to Modify");
				String name = scanner.next();
				System.out.println("Place Enter Tablet Qty to Modify");
				int qty = scanner.nextInt();
				System.out.println("Place Enter Tblet Price to Modify");
				double tabletPrice = scanner.nextDouble();

				Tablet tablet = tabletDriver.createTablet(id, name, qty, tabletPrice);
				Tablet updateTablet = tabletEntityManagerRepsoitory.updateTablet(tablet);
				System.out.println("UPDATED TABLET ");
				System.out.println(updateTablet);
				break;
			}
			case "SELECT": {
				System.out.println("Please enter customer id to select ");
				Integer id = scanner.nextInt();
				Tablet tablet = tabletEntityManagerRepsoitory.viewTablet(id);
				System.out.println("============= Selected Customer =============");
				System.out.println(tablet);
				break;
			}
			case "DELETE": {
				System.out.println("Please enter customer id to delete");
				Integer id = scanner.nextInt();
				tabletEntityManagerRepsoitory.deleteTablet(id);
				break;
			}
			default:
				scanner.close();
				throw new IllegalArgumentException(
						"Please pass the operations (ADD/MODIFY/SELECT/DELETE) value: " + operation);

			}

			
			System.out.println("Do you want to continue(yes/no)? ");
			String decision = scanner.next();
			isContinue = decision.equalsIgnoreCase("yes") ? true : decision.equalsIgnoreCase("no") ? false : false;
		}while(isContinue);

	scanner.close();

	}
	private Tablet createTablet(Integer id, String tabletName, int tabletQty, double tabletPrice) {

		Tablet tablet = new Tablet();
		tablet.setTabletName(tabletName);
		tablet.setTabletQty(tabletQty);
		tablet.setTabletPrice(tabletPrice);
		return tablet;

	}

  }

