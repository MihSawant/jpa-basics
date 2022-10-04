package main.strategy.table_type.entities.main;

import jakarta.persistence.Persistence;
import main.strategy.table_type.entities.Sweet;

public class Main {
    public static void main(String[] args) {
        var entityManagerFactory =
        Persistence.createEntityManagerFactory("my-persistence-unit");

        var entityManager = entityManagerFactory.createEntityManager();

        Sweet sweet1 = new Sweet();
        sweet1.setName("Kesar Barfi");
        sweet1.setCostPerKg(900);

        Sweet sweet2 = new Sweet();
        sweet2.setName("Gulab-Jamun");
        sweet2.setCostPerKg(850);

        try{
            entityManager.getTransaction().begin();
//            entityManager.persist(sweet1);
            entityManager.persist(sweet2);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

    }
}
