package com.pruebameli.meli.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="dna")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DnaModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public Long dnaId;

    public String dna;
    public boolean isMutant;
}
