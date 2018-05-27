package co.sovan.entity;


import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;
@Entity
public class Employee {
    @Id
    private String id;
    private String name;
    private String email;
    private int salary;
    @OneToOne(cascade = {CascadeType.ALL})
    private Address address;

    public Employee(){
        this.id = UUID.randomUUID().toString();
    }

   /* public Employee(String name, String email, int salary) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.salary = salary;
    }*/

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
