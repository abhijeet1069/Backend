package com.satyam.springprofiledemo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdGreetingService implements GreetingService{

    @Override
    public String message() {
        return "Hello from Production environment";
    }
}
