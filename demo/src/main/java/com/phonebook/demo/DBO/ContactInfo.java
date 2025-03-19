package com.phonebook.demo.DBO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Table(name = "contact_info")
@Entity
@Getter
@Setter
public class ContactInfo {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    private  int phoneNumber;
    private String  name;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
