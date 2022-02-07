package br.com.calcularfrete.api.applications.controllers;

import br.com.calcularfrete.api.applications.dtos.CotacaoEntregaDTO;
import br.com.calcularfrete.api.applications.dtos.EncomendaDTO;
import br.com.calcularfrete.api.domain.services.EncomendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Responsável por controlar as rotas do endpoint (/encomendas) e chamar o service para realizar as regras de negócio
 * @author Herlmaneol Fernandes Barbosa
 */
@RestController
@RequestMapping("encomendas")
public class EncomendaController {

    @Autowired
    private EncomendaService encomendaService;

    /**
     * Método responsável por consultar o preço do frete, a data prevista da entrega e salvar no banco
     * @param encomendaRequestDTO - encomenda
     * @return ResponseEntity<T>
     */
    @PostMapping
    public ResponseEntity<EncomendaDTO> consultarValorDataEntrega(@RequestBody EncomendaDTO encomendaRequestDTO){
        EncomendaDTO encomendaResponse = encomendaService.getEncomenda(encomendaRequestDTO);
        return ResponseEntity.ok().body(encomendaResponse);
    }

    /**
     * Método responsável por listar todos os objetos da CotacaoEntrega
     * @return ResponseEntity<List<CotacaoEntregaDTO>>
     */
    @GetMapping
    public ResponseEntity<List<CotacaoEntregaDTO>> consultarEntregas(){
        return ResponseEntity.ok().body(encomendaService.consultarTodasEntregas());
    }
}
