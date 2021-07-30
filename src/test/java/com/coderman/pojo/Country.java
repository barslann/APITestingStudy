package com.coderman.pojo;


import lombok.*;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Country {
    private int id;
    private String name;
}
