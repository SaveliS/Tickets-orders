package com.saveli.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("customer")
public class Customer {
    @Id
    @Column("idcustomer")
    private int idCustomer;
    @Column("name")
    private String name;
    @Column("email")
    private String email;
    @Column("isverified")
    private boolean IsVerified;

    public Customer(){

    }

    public Customer(int idCustomer, String name, String email, boolean isVerified) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.email = email;
        this.IsVerified = isVerified;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
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

    public boolean isIsVerified() {
        return IsVerified;
    }

    public void setIsVerified(boolean isVerified) {
        IsVerified = isVerified;
    }

    @Override
    public String toString() {
        return "Customer [idCustomer=" + idCustomer + ", name=" + name + ", email=" + email + ", IsVerified="
                + IsVerified + "]";
    }
}
