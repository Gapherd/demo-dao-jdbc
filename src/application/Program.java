package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args){

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("===seller findById===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("===seller findByDepartment===");
        Department department = new Department(2, null);
        List<Seller> sellerList = sellerDao.findByDepartment(department);
        for(Seller sel : sellerList){
            System.out.println(sel);
        }

        System.out.println("===seller findAll===");
        sellerList = sellerDao.findAll();
        for(Seller sel : sellerList){
            System.out.println(sel);
        }

        System.out.println("===seller insert===");
        Seller newSeller = new Seller(null, "Gabriela Souza", "gabriela@gmail.com", new Date(), 4500.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = "+newSeller.getId());

        System.out.println("===seller update===");
        seller = sellerDao.findById(1);
        seller.setName("Marta Aparecida");
        sellerDao.update(seller);
        System.out.println("Update completed!");
    }

}
