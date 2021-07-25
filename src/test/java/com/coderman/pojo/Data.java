package com.coderman.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Data {
    private String last_name;
    private int id;
    private String email;
    private String first_name;
    private String avatar;
}
