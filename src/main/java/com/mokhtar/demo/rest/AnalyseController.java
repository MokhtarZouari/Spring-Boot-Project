package com.mokhtar.demo.rest;

import com.mokhtar.demo.dto.AnalyseRequestDto;
import com.mokhtar.demo.dto.AnalyseResponceDto;
import com.mokhtar.demo.entity.Analyse;
import com.mokhtar.demo.entity.User;
import com.mokhtar.demo.services.AnalyseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class AnalyseController {

    private final AnalyseService analyseService;

    @GetMapping("/analyses/{id}")
    public ResponseEntity<AnalyseResponceDto> getAnalyseById(@PathVariable Long id) {
        AnalyseResponceDto analyse = analyseService.getAnalyseById(id);
        return new ResponseEntity<>(analyse, HttpStatus.OK);
    }
    @GetMapping("/analyses")
    public ResponseEntity<List<AnalyseResponceDto>> getAllAnalyse() {
        return new ResponseEntity<>(analyseService.getAll(), HttpStatus.OK);
    }


    @PostMapping("/analyses")
    public ResponseEntity<Analyse> postAnalyse(@RequestBody AnalyseRequestDto analyseRequestDto) {
        return new ResponseEntity<>(analyseService.Save(analyseRequestDto), HttpStatus.OK);
    }

    @PutMapping("/analyses/{id}")
    public ResponseEntity<Analyse> putAnalyse(@RequestBody AnalyseRequestDto analyseRequestDto, @PathVariable Long id){
        return new ResponseEntity<>(analyseService.update(analyseRequestDto,id), HttpStatus.OK);
    }

    @DeleteMapping("/analyses/{id}")
    public ResponseEntity<String> deleteAnalyse(@PathVariable Long id){
        return new ResponseEntity<>(analyseService.delete(id), HttpStatus.OK);

    }


}
