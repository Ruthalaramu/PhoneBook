package com.phonebook.demo.DBO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "spam_count_info")
@Getter
@Setter
public class SpamCountInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spam_count_info_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "spam_class_info_id", nullable = false)
    private SpamCallInfo spamCallInfo;

    @Column(name = "count")
    private int count;

    @Column(name = "is_active")
    private Boolean isActive;
}
