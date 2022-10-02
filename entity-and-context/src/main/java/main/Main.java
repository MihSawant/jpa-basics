package main;

import entities.Student;

import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var emf =
                Persistence.createEntityManagerFactory("my-persistence-unit");

        var em = emf.createEntityManager();

        Student student = new Student();
        student.setName("Mihir");
        student.setRollNo("A048");
        student.setSapId(1);

        Student student2 = new Student();
        student2.setName("Hari");
        student2.setRollNo("A024");
        student2.setSapId(2);

        Student student3 = new Student();
        student3.setName("Aayan");
        student3.setRollNo("A017");
        student3.setSapId(3);

        Student student4 = new Student();
        student4.setName("Suresh");
        student4.setRollNo("A007");
        student4.setSapId(4);

        Student student5 = new Student();
        student5.setName("Azirel");
        student5.setRollNo("A030");
        student5.setSapId(5);

        Student student6 = new Student();
        student6.setName("Shayan");
        student6.setRollNo("A066");
        student6.setSapId(6);

        Student student7 = new Student();
        student7.setName("Yash");
        student7.setRollNo("A010");
        student7.setSapId(7);


        var studentsList = List.of(student, student2,
                student3, student4, student5, student6, student7);

        // Wrap The operations inside a transaction and rollback if anything goes wrong
        try {
            em.getTransaction().begin();
            // add the instance or student object created into the context

            studentsList.forEach(em::persist);
           em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
