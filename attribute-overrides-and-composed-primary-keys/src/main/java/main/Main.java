package main;

import embedded.Address;
import entities.Student;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        var entityManagerFactory =
                Persistence.createEntityManagerFactory("my-persistence-unit");

        var entityManager = entityManagerFactory.createEntityManager();

        Student st1 = new Student();
        st1.setName("Suresh");
        st1.setSapId(1234);
        st1.setAddress(new Address());

        st1.getAddress().setCty("Mumbai");
        st1.getAddress().setFlatNumber("4F-west");
        st1.getAddress().setStreet("First");

        Student st2 = new Student();
        st2.setName("Hari");
        st2.setSapId(3331);
        st2.setAddress(new Address());

        st2.getAddress().setCty("Thrissur");
        st2.getAddress().setFlatNumber("103D");
        st2.getAddress().setStreet("8-avenue");

        Student st3 = new Student();
        st3.setName("Shayan");
        st3.setSapId(6121);
        st3.setAddress(new Address());

        st3.getAddress().setCty("Delhi");
        st3.getAddress().setFlatNumber("20A");
        st3.getAddress().setStreet("star-park");


        try{
            entityManager.getTransaction().begin();




//            entityManager.persist(st1);
//            entityManager.persist(st2);
            entityManager.persist(st3);

            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
}
