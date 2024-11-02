package br.com.auto_fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InfoVeiculos (@JsonAlias("codigo") Integer codigo,
                            @JsonAlias("nome") String modelo) {
    @Override
    public String toString() {
        return "cód: " + codigo + " - Modelo: " + modelo;
    }
}

