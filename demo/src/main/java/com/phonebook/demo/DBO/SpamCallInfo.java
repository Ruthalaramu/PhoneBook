package com.phonebook.demo.DBO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "spam_call_info")
@Getter
@Setter
public class SpamCallInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spam_call_info_id")
    private int id;

    @Column(name = "phoneNumber")
    private int phoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "is_Active")
    private Boolean isActive;
}
