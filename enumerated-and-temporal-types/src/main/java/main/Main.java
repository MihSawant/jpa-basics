package main;

import entities.Shoe;
import entities.enums.Currency;
import jakarta.persistence.Persistence;

import java.util.List;

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

        Shoe s3 = new Shoe();
        s3.setBrand("Puma");
        s3.setPrice(7999.00);
        s3.setCurrency(Currency.INR);

        Shoe s4 = new Shoe();
        s4.setBrand("Reebok");
        s4.setPrice(85.00);
        s4.setCurrency(Currency.USD);

        Shoe s5 = new Shoe();
        s5.setBrand("Nike");
        s5.setPrice(164.95);
        s5.setCurrency(Currency.EUR);

        List<Shoe> shoes = List.of(s3, s4);


        try{
            entityManager.getTransaction().begin();
//            entityManager.persist(s1);
//            entityManager.persist(s2);
//            shoes.forEach(entityManager::persist);
            entityManager.persist(s5);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            entityManager.getTransaction().rollback();
            System.out.println(ex.getMessage());
        }finally {
            entityManager.close();
        }
    }
}
