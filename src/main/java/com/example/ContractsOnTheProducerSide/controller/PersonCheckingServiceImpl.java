package com.example.ContractsOnTheProducerSide.controller;

import org.springframework.stereotype.Service;

@Service
public class PersonCheckingServiceImpl implements PersonCheckingService {

    @Override
    public boolean shouldGetBeer(PersonInfo personInfo) {
        return false;
    }
}
