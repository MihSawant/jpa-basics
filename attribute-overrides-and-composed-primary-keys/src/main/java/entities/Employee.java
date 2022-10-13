package entities;

import jakarta.persistence.*;
import pk.EmployeePK;

@Table(name = "employees")
@Entity
@IdClass(EmployeePK.class)
public class Employee {

    @Id
    private Integer id;

    @Id
    @Column(name = "emp_no")
    private String empCode;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
