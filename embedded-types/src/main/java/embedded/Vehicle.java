package embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Vehicle {

    @Column(name = "no_plate")
    private String noPlate;


    private String color;

    private int tyres;

    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNoPlate() {
        return noPlate;
    }

    public void setNoPlate(String noPlate) {
        this.noPlate = noPlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTyres() {
        return tyres;
    }

    public void setTyres(int tyres) {
        this.tyres = tyres;
    }
}
