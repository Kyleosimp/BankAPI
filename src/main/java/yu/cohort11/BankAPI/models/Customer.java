package yu.cohort11.BankAPI.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_id")
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private  String last_name;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "Customer_id")
//    @OrderBy
//    private Set <Address> address;


    public Customer() {
    }

    public Customer(Long id, String first_name, String last_name
                    //, Set<Address> address
    ) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
       // this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

//    public Set<Address> getAddress() {
//        return address;
//    }
//
//    public void setAddress(Set<Address> address) {
//        this.address = address;
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                //", address=" + address +
                '}';
    }
}
