package br.com.bibliole.app.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Livro( int id,
                     @JsonAlias("title") String titulo,
                     @JsonAlias("authors") List<Pessoa> autores,
                     @JsonAlias("translators") List<Pessoa> tradutores,//fica por enquanto. pode se que haja uma busca por tradutor
                     @JsonAlias("languages") List<String> idioma,
                     @JsonAlias("download_count") int downloads) {

}
