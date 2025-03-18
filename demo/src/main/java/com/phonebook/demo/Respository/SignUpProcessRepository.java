package com.phonebook.demo.Respository;

import com.phonebook.demo.DBO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpProcessRepository  extends JpaRepository<User   ,Integer> {

    @Query(value = "select * from  user_phone_book where email=:email ",nativeQuery=true)
    User findByEmail(String email);

}
