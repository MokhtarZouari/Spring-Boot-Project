package com.mokhtar.demo.dto;

import com.mokhtar.demo.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnalyseResponceDto {

    private Long id;

    private String result;

    private UserRequestDto user;

}
