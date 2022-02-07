package br.com.calcularfrete.api.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class CotacaoEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double peso;
    private String cepOrigem;
    private String cepDestino;
    private String nomeDestinatario;
    private Double vlTotalFrete;
    private LocalDate dataPrevistaEntrega;
    private LocalDate dataConsulta;
}
