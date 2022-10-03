package main.strategy.identity_type;

import entities.Student;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var entityManagerFactory =
                Persistence.createEntityManagerFactory("my-persistence-unit");

        var entityManager = entityManagerFactory.createEntityManager();

        Student student = new Student();
        student.setName("Ram");
        student.setRollNo("R054");

        Student student2 = new Student();
        student2.setName("Shyam");
        student2.setRollNo("S041");


        List<Student> students = List.of(student, student2);
        try{
            entityManager.getTransaction().begin();
            students.forEach(s -> {
                entityManager.persist(s);
                System.out.println("Student: "+s.toString()+" Added");
            });
            entityManager.getTransaction().commit();

        }catch (Exception ex){
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }


    }
}
