package com.mokhtar.demo.services;

import com.mokhtar.demo.dto.AnalyseRequestDto;
import com.mokhtar.demo.dto.AnalyseResponceDto;
import com.mokhtar.demo.dto.UserRequestDto;
import com.mokhtar.demo.dto.UserResponceDto;
import com.mokhtar.demo.entity.Analyse;
import com.mokhtar.demo.entity.User;

import java.util.List;

public interface IAnalyseService {

    AnalyseResponceDto getAnalyseById(Long id);

    List<AnalyseResponceDto> getAll();

    Analyse Save(AnalyseRequestDto analyseRequestDto);

    Analyse update(AnalyseRequestDto analyseRequestDto,Long id);

    String delete(Long id);

}
