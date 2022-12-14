package main;

import entities.Employee;
import entities.Meeting;
import entities.Shoe;
import entities.enums.Currency;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var entityManagerFactory =
                Persistence.createEntityManagerFactory("my-persistence-unit");

        var entityManager = entityManagerFactory.createEntityManager();

//        Shoe s1 = new Shoe();
//        s1.setBrand("Nike");
//        s1.setPrice(3450.13);
//        s1.setCurrency(Currency.INR);
//
//        Shoe s2 = new Shoe();
//        s2.setBrand("Adidas");
//        s2.setPrice(75.00);
//        s2.setCurrency(Currency.USD);
//
//        Shoe s3 = new Shoe();
//        s3.setBrand("Puma");
//        s3.setPrice(7999.00);
//        s3.setCurrency(Currency.INR);
//
//        Shoe s4 = new Shoe();
//        s4.setBrand("Reebok");
//        s4.setPrice(85.00);
//        s4.setCurrency(Currency.USD);
//
//        Shoe s5 = new Shoe();
//        s5.setBrand("Nike");
//        s5.setPrice(164.95);
//        s5.setCurrency(Currency.EUR);
//
//        List<Shoe> shoes = List.of(s3, s4);



        try{
            entityManager.getTransaction().begin();
//            entityManager.persist(s1);
//            entityManager.persist(s2);
//            shoes.forEach(entityManager::persist);
//            entityManager.persist(s5);

//            var emp2JoinDate = LocalDate.of(2015, 4, 21);

//            Employee emp1 = new Employee();
//            emp1.setName("Tom");
//            emp1.setJoiningDate(LocalDate.now());
//
//            Employee emp2 = new Employee();
//            emp2.setName("Jerry");
//            emp2.setJoiningDate(emp2JoinDate);
//
//            entityManager.persist(emp1);
//             entityManager.persist(emp2);

            Meeting meeting1 = new Meeting();
            meeting1.setStartTime(ZonedDateTime.now().minusDays(5).minusMinutes(20).minusSeconds(50).plusMinutes(1));

            Meeting meeting2 = new Meeting();
            meeting2.setStartTime(ZonedDateTime.now().minusDays(2).plusHours(5).plusSeconds(21).plusMinutes(10));

            Meeting meeting3 = new Meeting();
            meeting3.setStartTime(ZonedDateTime.now(ZoneId.of("Australia/Sydney")));
//            entityManager.persist(meeting1);
//            entityManager.persist(meeting2);

            Meeting meeting4 = new Meeting();
            meeting4.setStartTime(ZonedDateTime.now(ZoneId.of("America/Chicago")));


//            entityManager.persist(meeting3);
            entityManager.persist(meeting4);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            entityManager.getTransaction().rollback();
            System.out.println(ex.getMessage());
        }finally {
            entityManager.close();
        }
    }
}
