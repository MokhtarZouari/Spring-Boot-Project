package com.mokhtar.demo.mapper;

import com.mokhtar.demo.dto.AnalyseRequestDto;
import com.mokhtar.demo.dto.AnalyseResponceDto;
import com.mokhtar.demo.entity.Analyse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AnalyseMapper {

    @Mapping(source = "idUser",target = "user.id")
    Analyse dtoToEntity(AnalyseRequestDto analyseRequestDto);

    AnalyseResponceDto EntityToDto(Analyse analyse);

}
