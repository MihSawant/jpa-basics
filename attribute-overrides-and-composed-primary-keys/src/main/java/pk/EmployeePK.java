package pk;

import java.io.Serializable;

public class EmployeePK implements Serializable {

    private Integer id;
    private String empCode;

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
}
