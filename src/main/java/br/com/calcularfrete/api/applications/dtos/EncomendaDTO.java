package br.com.calcularfrete.api.applications.dtos;

import br.com.calcularfrete.api.domain.models.Cep;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Responsável por transportar os dados da Entrega
 * @author Herlmaneol Fernandes Barbosa
 */
@Data
@NoArgsConstructor
public class EncomendaDTO {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Double peso;
    private String cepOrigem;
    private String cepDestino;
    private String nomeDestinatario;
    private Double vlTotalFrete;
    private LocalDate dataPrevistaEntrega;

    public EncomendaDTO(String cepOrigem, String cepDestino, String nomeDestinatario, Double vlTotalFrete, LocalDate dataPrevistaEntrega) {
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.nomeDestinatario = nomeDestinatario;
        this.vlTotalFrete = vlTotalFrete;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }
}
