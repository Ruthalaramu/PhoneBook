package com.phonebook.demo.Service;

import com.phonebook.demo.DBO.User;
import com.phonebook.demo.Respository.SignUpProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private SignUpProcessRepository signUpProcessRepository;
    public ResponseEntity<String> createAccount(User user) {
        try{
            User user1= new User();
            user1.setEmail(user.getEmail());
                user1.setFirstName(user.getFirstName());
            user1.setMobileNumber(user.getMobileNumber());
            user1.setPassword(passwordEncoder.encode(user.getPassword()));
            signUpProcessRepository.save(user1);
        }catch (Exception e){
            e.printStackTrace();
        }

        return  new ResponseEntity<>("sucessfully saved", HttpStatus.CREATED);
    }
}
