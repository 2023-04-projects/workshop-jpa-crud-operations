package com.khadri.crud.operations.main;

import java.util.Scanner;

import com.khadri.crud.operations.entity.Product;
import com.khadri.crud.operations.repository.ProductEntityManagerRepsoitory;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductEntityDriver {

    public static void main(String[] args) {
        ProductEntityDriver entityDriver = new ProductEntityDriver();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT");
        ProductEntityManagerRepsoitory productEntityManagerRepsoitory = new ProductEntityManagerRepsoitory(entityManagerFactory);

        Scanner sc = new Scanner(System.in);
        boolean decision = false;

        do {
            System.out.println("Please Choose Operation (ADD/MODIFY/SELECT/DELETE): ");
            String OPERATION = sc.next();

            switch (OPERATION) {
                case "ADD": {
                    System.out.println("Please Enter Product Name to Add: ");
                    String prodName = sc.next();

                    System.out.println("Please Enter Qty to Add: ");
                    int qty = sc.nextInt();

                    System.out.println("Please Enter price to Add: ");
                    Double price = sc.nextDouble();

                    Product product = entityDriver.productCreation(null, prodName, qty, price);
                    productEntityManagerRepsoitory.insertProduct(product);
                    break;
                }

                case "MODIFY": {
                    System.out.println("Please Enter Product ID to Update: ");
                    int prodId = sc.nextInt();

                    System.out.println("Please Enter New Product Name to Update: ");
                    String prodName = sc.next();

                    System.out.println("Please Enter New Qty to Update: ");
                    int qty = sc.nextInt();

                    System.out.println("Please Enter New Price: ");
                    double price = sc.nextDouble();

                    Product product = entityDriver.productCreation(prodId, prodName, qty, price);
                    Product updatedProduct = productEntityManagerRepsoitory.updateProduct(product);

                    System.out.println("Updated Product: " + updatedProduct.getProdName() + ", qty: " + updatedProduct.getQty()
                            + " Price: " + updatedProduct.getPrice());
                    break;
                }

                case "SELECT": {
                    System.out.println("Please Enter Product ID to Fetch: ");
                    int prodId = sc.nextInt();

                    Product selectedProduct = productEntityManagerRepsoitory.selectProductById(prodId);
                    System.out.println("Product found: ");
                    System.out.println("Product ID: " + selectedProduct.getProdId());
                    System.out.println("Product Name: " + selectedProduct.getProdName());
                    System.out.println("Quantity: " + selectedProduct.getQty());
                    System.out.println("Price: " + selectedProduct.getPrice());
                    break;
                }

                case "DELETE": {
                    System.out.println("Please Enter Product ID to Delete: ");
                    int prodId = sc.nextInt();

                    productEntityManagerRepsoitory.deleteProductById(prodId);
                    System.out.println("Product with ID " + prodId + " has been deleted.");
                    break;
                }

                default:
                    throw new IllegalArgumentException("Unexpected value: " + OPERATION);
            }

            // Ask user if they want to continue
            System.out.println("Do you want to continue? (YES/NO)");
            String wish = sc.next();

            if (wish.equalsIgnoreCase("YES")) {
                decision = true;
            } else if (wish.equalsIgnoreCase("NO")) {
                decision = false;
            }

        } while (decision);  // Repeat the loop if the user wants to continue
    }

    private Product productCreation(Integer prodId, String prodName, Integer qty, Double price) {
        Product product = new Product();
        product.setProdId(prodId);
        product.setProdName(prodName);
        product.setQty(qty);
        product.setPrice(price);
        return product;
    }
}
