package com.example.provider.controller;

import org.springframework.stereotype.Service;

@Service
public class PersonCheckingServiceImpl implements PersonCheckingService {

    @Override
    public boolean shouldGetBeer(PersonInfo personInfo) {
        return false;
    }
}
