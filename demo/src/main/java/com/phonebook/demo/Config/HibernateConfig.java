package com.phonebook.demo.Config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.reactive.mutiny.Mutiny;
import org.hibernate.reactive.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class HibernateConfig {

    @Autowired
    private DataBaseConfig loadDetails;

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        Map<String,String> map = new HashMap<>();
        map.put("jakarta.persistence.jdbc.url", loadDetails.getUrl());
        map.put("jakarta.persistence.jdbc.user", loadDetails.getUsername());
        map.put("jakarta.persistence.jdbc.password", loadDetails.getPassword());
        return Persistence.createEntityManagerFactory("ReactivePU",map);
    }

    @Bean
    public Mutiny.SessionFactory reactiveSessionFactory(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.unwrap(Mutiny.SessionFactory.class);
    }

    @Bean
    public Stage.SessionFactory futureSessionFactory(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.unwrap(Stage.SessionFactory.class);
    }
}
