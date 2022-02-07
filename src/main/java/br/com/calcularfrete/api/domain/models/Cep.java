package br.com.calcularfrete.api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cep {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String DDD;

}
