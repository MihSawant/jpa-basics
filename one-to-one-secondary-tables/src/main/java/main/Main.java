package main;

import entities.Student;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Student s1 = new Student();
            s1.setName("Mihir");
            s1.setCourseName("MCA");


           Student s2 = new Student();
           s2.setName("Hari");
           s2.setCourseName("MCA");

           Student s3 = new Student();
           s3.setName("Soumesh");
           s3.setCourseName("MBA-TECH");

            List.of(s2, s3).forEach(em::persist);

            em.getTransaction().commit();
            em.close();
        }catch (Exception ex){
            System.out.println("Something Went wrong "+ex.getMessage());
            em.getTransaction().rollback();
        }
    }
}
