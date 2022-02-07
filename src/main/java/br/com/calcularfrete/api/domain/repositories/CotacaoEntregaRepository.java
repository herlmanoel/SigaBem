package br.com.calcularfrete.api.domain.repositories;

import br.com.calcularfrete.api.domain.entities.CotacaoEntrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotacaoEntregaRepository extends JpaRepository<CotacaoEntrega, Long> {
}
