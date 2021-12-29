package br.com.besistemagif.domains.clients;

import lombok.Getter;

public enum Gender {
    MALE("Masculino"),
    FEMALE("Feminino"),
    NOT_DECLARED("Não Declarado");

    @Getter
    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }
}
