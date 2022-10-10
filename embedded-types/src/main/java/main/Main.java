package main;

import embedded.Vehicle;
import entities.Car;
import enumerated.CarType;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        var emf =
                Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        /*
            Creating Objects to persist them
         */
        Vehicle v1 = new Vehicle();
        v1.setColor("Blue");
        v1.setNoPlate("AP-10-BD-1R");
        v1.setCompany("Honda");
        v1.setTyres(4);

        Car c1 = new Car();
        c1.setCarType(CarType.HATCH_BACK);
        c1.setVehicle(v1);

        Car c2 = new Car();
        c2.setVehicle(new Vehicle());
        c2.setCarType(CarType.SUV);

        Vehicle v2 = c2.getVehicle();
        v2.setCompany("Mahindra");
        v2.setColor("Red");
        v2.setTyres(4);
        v2.setNoPlate("HR-12-GH-5C");



        try{
           em.getTransaction().begin();

//           em.persist(c1);
            em.persist(c2);
           em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}
