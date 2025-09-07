package br.com.veneza.imoveis.repositories;

import br.com.veneza.imoveis.models.Contrato;
import br.com.veneza.imoveis.models.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Long> {
    boolean existsByContratoAndDataVencimento(Contrato contrato, LocalDate dataVencimento);
}