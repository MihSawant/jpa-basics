package main;

import entities.Customer;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Customer c1 = new Customer();
            c1.setName("hari");
            c1.setFirstLine("Malad East");
            c1.setPinCode("1234");

            Customer c2 = new Customer();
            c2.setName("yash");
            c2.setFirstLine("Kandivali East");
            c2.setPinCode("2201");

            em.persist(c1);
            em.persist(c2);
            em.getTransaction().commit();
            em.close();
        }catch (Exception ex){
            System.out.println("Something Went wrong "+ex.getMessage());
            em.getTransaction().rollback();
        }
    }
}
