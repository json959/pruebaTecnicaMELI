package com.pruebameli.meli.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatsModel {


    public Long count_mutant_dna;
    public Long count_human_dna;
    public double ratio;


}
