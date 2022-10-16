package entities;

import jakarta.persistence.*;
import pk.EmployeePK;

@Table(name = "employees")
@Entity
public class Employee {

    @EmbeddedId
    @AttributeOverride(name = "empCode", column = @Column(name="emp_code"))
    private EmployeePK employeePK;

    private String name;

    public EmployeePK gEmployeePK(){
        return employeePK;
    }

    public void setEmployeePK(EmployeePK employeePK){
        this.employeePK = employeePK;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
