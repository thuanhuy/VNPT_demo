package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserToDo {
    private String name;
    private String address;
    private String sex;
    private Number age;
}
