package entities;

import embedded.Address;
import jakarta.persistence.*;

@Table(name = "students")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "sap_id")
    private Integer sapId;

    @Embedded
    @AttributeOverride(name = "flatNumber", column = @Column(name = "flat_no"))
    @AttributeOverride(name = "cty", column = @Column(name = "city"))
    private Address address;

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

    public Integer getSapId() {
        return sapId;
    }

    public void setSapId(Integer sapId) {
        this.sapId = sapId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
