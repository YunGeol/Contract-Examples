package com.example.provider.controller;

import lombok.Data;

@Data
public class Response {

    BeerCheckStatus status;

    public Response(BeerCheckStatus beerCheckStatus) {
        this.status = beerCheckStatus;
    }
}
