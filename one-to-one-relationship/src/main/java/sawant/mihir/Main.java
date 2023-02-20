package sawant.mihir;

import entities.Card;
import entities.Student;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();
        try{

            em.getTransaction().begin();

            Student s1 = new Student();
            s1.setName("shayan");
            s1.setRollNo("a066");

            em.persist(s1);


            Card c1 = new Card();
            c1.setCode(UUID.randomUUID().toString());
            c1.setStudent(s1);

            em.persist(c1);
            em.getTransaction().commit();

        }catch (PersistenceException ex){
            em.getTransaction().rollback();
            System.out.println(ex.getMessage());
        }
    }
}