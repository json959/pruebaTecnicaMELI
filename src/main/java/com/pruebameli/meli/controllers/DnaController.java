package com.pruebameli.meli.controllers;

import com.pruebameli.meli.models.DnaModel;
import com.pruebameli.meli.models.StatsModel;
import com.pruebameli.meli.services.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pruebameli")
public class DnaController {

    @Autowired
    DnaService service;

    @GetMapping
    public List<DnaModel> getDnas(){
        return service.getDnas();
    }

    @PostMapping
    public DnaModel saveDna(@RequestBody DnaModel dna){
        return service.saveDna(dna);
    }

    @GetMapping("/stats")
    public StatsModel getStats(){
        return service.stats();
    }

    @PostMapping("/ismutant")
    public HttpStatus saveDna(@RequestBody String[] dna){
        return service.isMutant(dna);
    }
}
