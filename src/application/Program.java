package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

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
    }

}
