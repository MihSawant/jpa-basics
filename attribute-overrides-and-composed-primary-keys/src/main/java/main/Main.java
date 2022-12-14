package main;

import entities.Employee;
import jakarta.persistence.Persistence;
import pk.EmployeePK;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        var entityManagerFactory =
                Persistence.createEntityManagerFactory("my-persistence-unit");

        var entityManager = entityManagerFactory.createEntityManager();

//        Student st1 = new Student();
//        st1.setName("Suresh");
//        st1.setSapId(1234);
//        st1.setAddress(new Address());
//
//        st1.getAddress().setCty("Mumbai");
//        st1.getAddress().setFlatNumber("4F-west");
//        st1.getAddress().setStreet("First");
//
//        Student st2 = new Student();
//        st2.setName("Hari");
//        st2.setSapId(3331);
//        st2.setAddress(new Address());
//
//        st2.getAddress().setCty("Thrissur");
//        st2.getAddress().setFlatNumber("103D");
//        st2.getAddress().setStreet("8-avenue");
//
//        Student st3 = new Student();
//        st3.setName("Shayan");
//        st3.setSapId(6121);
//        st3.setAddress(new Address());
//
//        st3.getAddress().setCty("Delhi");
//        st3.getAddress().setFlatNumber("20A");
//        st3.getAddress().setStreet("star-park");
//
//        Student st4 = new Student();
//        st4.setName("Madhuram");
//        st4.setSapId(5162);
//        st4.setAddress(new Address());
//
//        Address st4Address = st4.getAddress();
//        st4Address.setCty("Jodhpur");
//        st4Address.setStreet("NWRoad");
//        st4Address.setFlatNumber("H01");

        AtomicInteger autoInt = new AtomicInteger();

        try{
            entityManager.getTransaction().begin();

           
            EmployeePK emp1PK = new EmployeePK();
            emp1PK.setId(autoInt.incrementAndGet());
            emp1PK.setEmpCode("AAAA");

            EmployeePK emp2PK = new EmployeePK();
            emp2PK.setId(autoInt.incrementAndGet());
            emp2PK.setEmpCode("BBBB");

            Employee emp1 = new Employee();
            emp1.setName("Tomy");
            emp1.setEmployeePK(emp1PK);
            

            Employee emp2 = new Employee();
            emp2.setName("Marry");
            emp2.setEmployeePK(emp2PK);

            entityManager.persist(emp1);
            entityManager.persist(emp2);


            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
}
