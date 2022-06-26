package com.mokhtar.demo.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnalyseRequestDto {

    private Long id;

    private String result;

    private Long idUser;

}
