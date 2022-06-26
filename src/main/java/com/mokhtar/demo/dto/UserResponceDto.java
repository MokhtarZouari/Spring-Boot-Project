package com.mokhtar.demo.dto;

import com.mokhtar.demo.entity.Analyse;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class UserResponceDto {

    private Long id;

    private String name;

    private  String email;

    private List<AnalyseRequestDto> analyses;
}
