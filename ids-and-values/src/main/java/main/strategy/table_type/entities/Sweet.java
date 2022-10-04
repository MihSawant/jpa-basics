package main.strategy.table_type.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sweets")
public class Sweet {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
    private Integer id;

    private String name;

    @Column(name = "cost_per_kg")
    private double costPerKg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCostPerKg() {
        return costPerKg;
    }

    public void setCostPerKg(double costPerKg) {
        this.costPerKg = costPerKg;
    }

    @Override
    public String toString() {
        return "Sweet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", costPerKg=" + costPerKg +
                '}';
    }
}
