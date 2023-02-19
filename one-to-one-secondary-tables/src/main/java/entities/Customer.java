package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
@SecondaryTables(
        {
                @SecondaryTable(name = "address", pkJoinColumns = @PrimaryKeyJoinColumn(name = "customer")),
                @SecondaryTable(name = "orders", pkJoinColumns = @PrimaryKeyJoinColumn(name = "c_id"))
        }
)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    @Column(table = "address", name = "line_1")
    private String firstLine;

    @Column(table = "address", name = "pin_code")
    private String pinCode;

    @Column(table = "orders", name = "product_name")
    private String productName;

    public Customer(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public String getPinCode() {
        return pinCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
