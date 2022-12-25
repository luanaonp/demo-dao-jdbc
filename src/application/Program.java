package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== TESTE 1: seller findByID ===");
		Seller seller = sellerDao.findByID(6);
		System.out.println(seller);
		
		System.out.println();
		
		System.out.println("=== TESTE 2: seller findByDepartment ===");
		Department department = new Department(2,null);
		List<Seller>list = sellerDao.findByDepartment(department);
		
		for(Seller obj:list) {
			System.out.println(obj);
		}
		
		System.out.println();
		
		System.out.println("=== TESTE 3: seller findAll ===");
		list = sellerDao.findAll();
		
		for(Seller obj:list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TESTE 4:: seller insert ===");
		Seller newSeller = new Seller(null, "Grey", "greg@gmail.com", new Date(), 4.000, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id= " + newSeller.getId());
		
		System.out.println("=== TESTE 5:: seller update ===");
		seller = sellerDao.findByID(1);
		seller.setName("Maria Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("=== TESTE 6:: seller delete===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		
		
		
	}

}
