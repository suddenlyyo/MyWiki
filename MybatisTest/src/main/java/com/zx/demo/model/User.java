package com.zx.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    private int id;
    private String name;
    private int age;

    // Getter and Setter methods...
}