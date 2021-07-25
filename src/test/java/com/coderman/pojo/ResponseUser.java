package com.coderman.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ResponseUser {
    private String name;
    private String job;
    private String id;
    private String createdAt;
}
