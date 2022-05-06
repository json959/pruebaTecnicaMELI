package com.pruebameli.meli.services;

import com.pruebameli.meli.models.DnaModel;
import com.pruebameli.meli.models.StatsModel;
import com.pruebameli.meli.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DnaService {

    @Autowired
    DnaRepository repository;


    public List<DnaModel> getDnas() {
        return (List<DnaModel>) repository.findAll();
    }

    public DnaModel saveDna(DnaModel dna) {
        return repository.save(dna);
    }

    public StatsModel stats() {

        Long mutant, human;
        double ratio;
        List<DnaModel> models = (List<DnaModel>) repository.findAll();
        StatsModel stats = new StatsModel();
        mutant = models.stream().filter(i -> i.isMutant()).count();
        human = models.stream().filter(i -> !i.isMutant()).count();
        ratio = (double) mutant / human;

        stats.setCount_human_dna(human);
        stats.setCount_mutant_dna(mutant);
        stats.setRatio(ratio);

        return stats;
    }


    public HttpStatus isMutant(String[] dna) {
        //String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        int countMutant = 0;
        String newDna;
        HttpStatus statusResponse;
        char[] chars2 = new char[dna[0].toCharArray().length];
        int countMutantCromo = 0;
        boolean isMutant = false;
        int lenChars;
        StringBuffer sb = new StringBuffer();
        DnaModel dnaModel = new DnaModel();
        //for (int h = 0; h < dna.length; h++)
        for (int j = 0; j < dna.length; j++) {

            char[] chars = dna[j].toCharArray();
            chars2[j] = chars[j];
            if (j == 0) {
                countMutantCromo++;
            } else {
                if (chars2[j] == chars2[j - 1]) {
                    countMutantCromo++;
                } else {
                    countMutantCromo = 1;
                }
                if (countMutantCromo >= 4) {
                    countMutant++;
                    countMutantCromo = 0;
                }
            }

        }
        int count = 0;
        countMutantCromo = 0;
        chars2 = new char[dna[0].toCharArray().length];
        for (int h = 0; h < dna.length; h++) {

            for (int j = 0; j < dna.length; j++) {

                char[] chars = dna[j].toCharArray();
                chars2[j] = chars[count];
                if (j == 0) {
                    countMutantCromo++;
                } else {
                    if (chars2[j] == chars2[j - 1]) {
                        countMutantCromo++;
                    } else {
                        countMutantCromo = 1;
                    }
                    if (countMutantCromo >= 4) {
                        countMutant++;
                        countMutantCromo = 0;
                    }
                }

            }
            count++;
        }

        countMutantCromo = 0;
        for (String dna1 : dna) {
            countMutantCromo = 0;
            char[] chars = dna1.toCharArray();
            lenChars = chars.length;
            for (int i = 0; i < lenChars; i++) {
                if (i == 0) {
                    countMutantCromo++;
                } else {
                    if (chars[i] == chars[i - 1]) {
                        countMutantCromo++;
                    } else {
                        countMutantCromo = 1;
                    }
                    if (countMutantCromo >= 4) {
                        countMutant++;
                        countMutantCromo = 0;
                    }
                }
            }
        }

        for (int j = 0; j < dna.length; j++) {

        }

        if (countMutant >= 2) {
            isMutant = true;
            statusResponse = HttpStatus.OK;
        } else {
            statusResponse = HttpStatus.FORBIDDEN;
        }


        for (int i=0; i<dna.length; i++) {
            if (i == 0) {
                sb.append(dna[i]);
            } else {
                sb.append(",");
                sb.append(dna[i]);
            }
        }

        List<DnaModel> list = (List<DnaModel>) repository.findAll();

        Long countDna = list.stream().filter(i -> i.getDna().equals(sb.toString())).count();

        if (countDna <= 0) {

            dnaModel.setMutant(isMutant);
            dnaModel.setDna(sb.toString());
            repository.save(dnaModel);
        }

        return statusResponse;
    }

}
