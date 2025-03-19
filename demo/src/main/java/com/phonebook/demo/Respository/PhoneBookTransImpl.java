package com.phonebook.demo.Respository;

import io.smallrye.mutiny.Uni;
import org.hibernate.reactive.mutiny.Mutiny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PhoneBookTransImpl {

    @Autowired
    private Mutiny.SessionFactory sessionFactory;

    public Uni<Integer> getSpamCount(String phoneNumber) {

        String sqlQuery =   "select count(*) from spam_count_info " +
                            "inner join spam_call_info ON spam_call_info.spam_call_info_id = spam_count_info.spam_class_info_id\n" +
                            "where spam_call_info.phone_number=:phoneNumber";

        return sessionFactory.withSession(session ->
                session.createNativeQuery(sqlQuery, Long.class)
                        .setParameter("phoneNumber", phoneNumber)
                        .getSingleResult()
                        .map(Long::intValue) );// Convert Long to Integer

    }
}
