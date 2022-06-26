package com.mokhtar.demo.services;

import com.mokhtar.demo.dao.AnalyseDao;
import com.mokhtar.demo.dto.AnalyseRequestDto;
import com.mokhtar.demo.dto.AnalyseResponceDto;
import com.mokhtar.demo.entity.Analyse;
import com.mokhtar.demo.mapper.AnalyseMapper;
import com.mokhtar.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalyseService implements IAnalyseService {

    private final AnalyseDao analyseDao;

    private AnalyseMapper analyseMapper = Mappers.getMapper(AnalyseMapper.class);

    @Override
    public AnalyseResponceDto getAnalyseById(Long id){
        return analyseMapper.EntityToDto(analyseDao.findById(id).orElseThrow(()->new IllegalStateException("user not found")));
    }

    @Override
    public List<AnalyseResponceDto> getAll(){
        return analyseDao.findAll().stream().map(analyse -> analyseMapper.EntityToDto(analyse)).collect(Collectors.toList());
    }

    @Override
    public Analyse Save(AnalyseRequestDto analyseRequestDto){
        return analyseDao.save(analyseMapper.dtoToEntity(analyseRequestDto));
    }

    @Override
    public Analyse update(AnalyseRequestDto analyseRequestDto, Long id) {
        analyseRequestDto.setId(id);
        return analyseDao.save(analyseMapper.dtoToEntity(analyseRequestDto));
    }

    @Override
    public String delete(Long id) {
        Analyse analyse = analyseDao.findById(id).orElseThrow(() -> new IllegalStateException("analyse not found"));
        analyseDao.delete(analyse);
        return "The analyse of id "+id+" is deleted";
    }

}
