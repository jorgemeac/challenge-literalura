package br.com.bibliole.app.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Pessoa (@JsonAlias("name") String nome,
                      @JsonAlias("birth_year") int anoNascimento,
                      @JsonAlias("death_year") int anoObito) {
    public Pessoa {
        //construtor sem argumentos
    }


}