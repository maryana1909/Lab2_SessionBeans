package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Developer {
    private String name;
    private String experience;
    private String position;
    private String mainTechnology;
    private double salary;
}
