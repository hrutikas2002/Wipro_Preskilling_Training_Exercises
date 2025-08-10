package com.wipro.hibernate.HibernateDemonstration1;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wipro.hibernate.HibernateDemonstration1.entity.Pan;
import com.wipro.hibernate.HibernateDemonstration1.entity.repo.PanRepo;
import com.wipro.hibernate.HibernateDemonstration1.util.HibernateUtil;

public class App 
{
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\n---- PAN MANAGEMENT SYSTEM ----");
	            System.out.println("1. Create PAN Record");
	            System.out.println("2. Update PAN Record");
	            System.out.println("3. Delete PAN Record");
	            System.out.println("4. View All PAN Records");
	            System.out.println("5. View All PAN Numbers");
	            System.out.println("6. Find PAN by Holder Name");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    PanRepo.createPan();
	                    break;
	                case 2:
	                    PanRepo.updatePan();
	                    break;
	                case 3:
	                    System.out.print("Enter PAN ID to delete: ");
	                    int idToDelete = sc.nextInt();
	                    Pan deleted = PanRepo.deleteById(idToDelete);
	                    if (deleted != null) {
	                        System.out.println("Deleted PAN: " + deleted.getPanholderName());
	                    } else {
	                        System.out.println("PAN not found with ID: " + idToDelete);
	                    }
	                    break;
	                case 4:
	                    List<Pan> all = PanRepo.findAll();
	                    System.out.println("--- All PAN Records ---");
	                    for (Pan pan : all) {
	                        System.out.println("ID: " + pan.getId() + ", Name: " + pan.getPanholderName() + ", PAN Number: " + pan.getPanNumber());
	                    }
	                    break;
	                case 5:
	                    List<String> numbers = PanRepo.findAllPanNumbers();
	                    System.out.println("--- All PAN Numbers ---");
	                    for (String number : numbers) {
	                        System.out.println("PAN Number: " + number);
	                    }
	                    break;
	                case 6:
	                    System.out.print("Enter PAN holder name to search: ");
	                    String name = sc.next();
	                    List<Pan> results = PanRepo.findByHolderName(name);
	                    if (results.isEmpty()) {
	                        System.out.println("No PAN records found for: " + name);
	                    } else {
	                        for (Pan p : results) {
	                            System.out.println("ID: " + p.getId() + ", Name: " + p.getPanholderName() + ", PAN Number: " + p.getPanNumber());
	                        }
	                    }
	                    break;
	                case 0:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice!");
	            }

	        } while (choice != 0);

	        sc.close();
	    }
}
