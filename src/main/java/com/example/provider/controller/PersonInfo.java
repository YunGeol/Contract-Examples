package com.example.provider.controller;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonInfo {
    int age;
    String name;
}
