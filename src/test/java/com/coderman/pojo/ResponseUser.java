package com.coderman.pojo;

import lombok.*;
import lombok.Data;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUser {
    private String name;
    private String job;
    private String id;
    private String createdAt;
}
