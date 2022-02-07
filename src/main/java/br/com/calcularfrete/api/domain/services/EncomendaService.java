package br.com.calcularfrete.api.domain.services;

import br.com.calcularfrete.api.applications.dtos.CotacaoEntregaDTO;
import br.com.calcularfrete.api.applications.dtos.EncomendaDTO;
import br.com.calcularfrete.api.domain.entities.CotacaoEntrega;
import br.com.calcularfrete.api.domain.models.Cep;
import br.com.calcularfrete.api.domain.models.Encomenda;
import br.com.calcularfrete.api.domain.repositories.CotacaoEntregaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EncomendaService {
    @Autowired
    private CotacaoEntregaRepository cotacaoEntregaRepository;

    public Cep getCep(String cep) {
        String url = String.format("https://viacep.com.br/ws/%s/json", cep);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Cep.class);
    }

    public EncomendaDTO getEncomenda(EncomendaDTO encomendaDTO) {
        Cep cepOrigem = this.getCep(encomendaDTO.getCepOrigem());
        Cep cepDestino = this.getCep(encomendaDTO.getCepDestino());

        Encomenda encomenda = new Encomenda(encomendaDTO.getPeso(), cepOrigem, cepDestino, encomendaDTO.getNomeDestinatario());

        EncomendaDTO encomendaResponse = encomenda.createEncomendaDTO();
        CotacaoEntrega cotacaoEntrega = createCotacaoEntrega(encomenda);

        return encomendaResponse;
    }

    public CotacaoEntrega createCotacaoEntrega(Encomenda encomenda) {
        CotacaoEntrega cotacaoEntrega = new CotacaoEntrega();
        BeanUtils.copyProperties(encomenda, cotacaoEntrega);
        cotacaoEntrega.setDataConsulta(LocalDate.now());
        cotacaoEntrega.setCepDestino(encomenda.getCepDestino().getCep());
        cotacaoEntrega.setCepOrigem(encomenda.getCepOrigem().getCep());
        cotacaoEntrega.setPeso(encomenda.getPeso());
        cotacaoEntrega.setVlTotalFrete(encomenda.getValorComDesconto());
        return cotacaoEntregaRepository.save(cotacaoEntrega);
    }

    public List<CotacaoEntregaDTO> consultarTodasEntregas() {
        List<CotacaoEntrega> cotacoes = cotacaoEntregaRepository.findAll();

        return cotacoes.stream().map(cotacaoEntrega -> {
            CotacaoEntregaDTO cotacaoEntregaDTO = new CotacaoEntregaDTO();
            BeanUtils.copyProperties(cotacaoEntrega, cotacaoEntregaDTO);
            return cotacaoEntregaDTO;
        }).collect(Collectors.toList());
    }
}
