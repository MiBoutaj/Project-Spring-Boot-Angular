package com.example.demo.model;


import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "email_id")
    private String email;
    @Column(name = "image_url")
    private String imageUrl;

    public Employee() {

    }

    public Employee(String firstName, String lastname, String email, String imageUrl) {
        super();
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



}
