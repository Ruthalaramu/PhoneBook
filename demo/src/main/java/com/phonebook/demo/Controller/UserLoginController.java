package com.phonebook.demo.Controller;

import com.phonebook.demo.Config.JwtUtil;
import com.phonebook.demo.DBO.User;
import com.phonebook.demo.Respository.SignUpProcessRepository;
import com.phonebook.demo.Service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/phoneBook")
@RestController
public class UserLoginController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private SignUpProcessRepository signUpProcessRepository;
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private JwtUtil jwtUtil;


     @PostMapping("/login")
    public ResponseEntity<String> signUpProcess(@RequestParam String email, @RequestParam String password ){
          if(email!=null ){
              User login = signUpProcessRepository.findByEmail(email);
              if(login!=null){
               if(email.equalsIgnoreCase(login.getEmail()) &&
                       passwordEncoder.matches(password, login.getPassword()) ){
                          jwtUtil.generateToken(email);
                   return ResponseEntity.ok("Login Successful");

                  }else{
                   return ResponseEntity.ok("Invalid credentials");
               }
              }
          }

         return null;
     }
    @PostMapping("/signUp")
 public  ResponseEntity<String> userSignUp(@RequestBody User user){
    if(user!=null){
        User signUp = signUpProcessRepository.findByEmail(user.getMobileNumber());
        if(signUp==null ){
            return  userLoginService.createAccount(user);
        }else{
            return ResponseEntity.ok("user already  registered ");
        }
    }

     return ResponseEntity.ok("SignUp Successful");
 }

//  @PostMapping("/getPhoneBook")
// public ResponseEntity<String> getPhoneBook(@RequestParam  ema )
}
