package br.com.calcularfrete.api.domain.models;

import br.com.calcularfrete.api.applications.dtos.EncomendaDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Encomenda {
    private Double peso;
    private Cep cepOrigem;
    private Cep cepDestino;
    private String nomeDestinatario;
    private Double desconto;
    private Double VALOR_POR_KG;
    private LocalDate dataPrevistaEntrega;

    public Encomenda(Double peso, Cep cepOrigem, Cep cepDestino, String nomeDestinatario) {
        this.peso = peso;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.nomeDestinatario = nomeDestinatario;
        this.VALOR_POR_KG = 1D;
        this.setDescontoPrevisaoEntregaDias();
    }

    public EncomendaDTO createEncomendaDTO() {
        return new EncomendaDTO(getCepOrigem().getCep(), getCepDestino().getCep(), getNomeDestinatario(), getValorComDesconto(), getDataPrevistaEntrega());
    }
    private void setDescontoPrevisaoEntregaDias() {
        if(this.isEqualsDDD()) {
            this.desconto = 0.5;
            this.dataPrevistaEntrega = LocalDate.now().plusDays(1);
            return;
        }
        if(isEqualsState()) {
            this.dataPrevistaEntrega = LocalDate.now().plusDays(3);
            this.desconto = 0.75;
            return;
        }
        this.dataPrevistaEntrega = LocalDate.now().plusDays(10);
        this.desconto = 0D;
    }



    public boolean isEqualsDDD() {
        return cepOrigem.getDDD().equalsIgnoreCase(cepDestino.getDDD());
    }
    
    public boolean isEqualsState() {
        return cepOrigem.getUf().equalsIgnoreCase(cepDestino.getUf());
    }

    private Double getDesconto() {
        return this.getValor() * this.desconto;
    }

    public Double getValor() {
        return this.peso * this.VALOR_POR_KG;
    }

    public Double getValorComDesconto() {
        return this.getValor() - this.getDesconto();
    }
}
