package com.satyam.springprofiledemo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevGreetingService implements GreetingService{

    @Override
    public String message() {
        return "Hello from Development environment";
    }
}
