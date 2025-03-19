package com.phonebook.demo.Controller;

import com.phonebook.demo.Service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/phoneBook")
public class PhoneBookController {

    @Autowired
     private PhoneBookService phoneBookService;

    public Mono<String> addMyContact(@RequestParam  String phoneNumber, @RequestParam  String contactName ) {
       //return phoneBookService.addMyContact(phoneNumber,contactName).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.badRequest().build());
        return null;
    }
}
