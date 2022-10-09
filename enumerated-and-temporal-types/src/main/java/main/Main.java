package main;

import entities.Shoe;
import entities.enums.Currency;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        var entityManagerFactory =
                Persistence.createEntityManagerFactory("my-persistence-unit");

        var entityManager = entityManagerFactory.createEntityManager();

        Shoe s1 = new Shoe();
        s1.setBrand("Nike");
        s1.setPrice(3450.13);
        s1.setCurrency(Currency.INR);

        Shoe s2 = new Shoe();
        s2.setBrand("Adidas");
        s2.setPrice(75.00);
        s2.setCurrency(Currency.USD);

        try{
            entityManager.getTransaction().begin();
            entityManager.persist(s1);
            entityManager.persist(s2);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            entityManager.getTransaction().rollback();
            System.out.println(ex.getMessage());
        }finally {
            entityManager.close();
        }
    }
}
