package br.com.calcularfrete.api.applications.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Responsável por transportar os dados da CotacaoEntrega
 * @author Herlmaneol Fernandes Barbosa
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CotacaoEntregaDTO {
    private Double peso;
    private String cepOrigem;
    private String cepDestino;
    private String nomeDestinatario;
    private Double vlTotalFrete;
    private LocalDate dataPrevistaEntrega;
    private LocalDate dataConsulta;
}
