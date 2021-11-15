package com.example.demo.entitites;

import javax.persistence.*;

@Entity
@Table(name="login")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;

    @OneToOne(targetEntity=Address.class, cascade=CascadeType.ALL)
    @JoinColumn(name="address")
    private Address address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="username")
    String username;

    @Column(name="password")
    String password;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
