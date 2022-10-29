package main;

import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        try{
            em.getTransaction().begin();


            em.getTransaction().commit();
        }catch (Exception ex){
            System.out.println("Something Went wrong "+ex.getMessage());
            em.getTransaction().rollback();
        }
    }
}
