package com.mokhtar.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequestDto {

    private Long id;

    private String name;

    private  String email;

}
