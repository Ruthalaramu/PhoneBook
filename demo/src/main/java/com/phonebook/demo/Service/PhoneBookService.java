package com.phonebook.demo.Service;

import com.phonebook.demo.Common.ApiResponse;
import com.phonebook.demo.DBO.SpamCountInfo;
import com.phonebook.demo.Respository.PhoneBookTransImpl;
import io.smallrye.mutiny.Uni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PhoneBookService {

    @Autowired
    private PhoneBookTransImpl phoneBookTrans;

    public Mono<ApiResponse> addMyContact(String phoneNumber, String contactName) {

       Uni<Integer> count  = phoneBookTrans.getSpamCount(phoneNumber);


        return null;
    }
}
