package com.example.ContractsOnTheProducerSide.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    private PersonCheckingService personCheckingService;

    public ProducerController(PersonCheckingService personCheckingService) {
        this.personCheckingService = personCheckingService;
    }

    @RequestMapping(value = "/check",
                    method= RequestMethod.POST,
                    consumes="application/json",
                    produces="application/json")
    public Response check(@RequestBody PersonInfo personInfo) {
        //remove::start[]
        if (personCheckingService.shouldGetBeer(personInfo)) {
            return new Response(BeerCheckStatus.OK);
        }
        return new Response(BeerCheckStatus.NOT_OK);
        //remove::end[return]
    }
}
