package br.com.veneza.imoveis.repositories;

import br.com.veneza.imoveis.models.Seguradora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguradoraRepository extends JpaRepository<Seguradora, Long> {
}