package br.com.veneza.imoveis.services;

import br.com.veneza.imoveis.models.Contrato;
import br.com.veneza.imoveis.repositories.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    public Contrato criarContrato(Contrato contrato) {
        // Futuramente, podemos adicionar uma lógica para, ao criar um contrato,
        // mudar o status do imóvel para "ALUGADO/VENDIDO".
        return contratoRepository.save(contrato);
    }

    public List<Contrato> listarTodos() {
        return contratoRepository.findAll();
    }

    public Optional<Contrato> buscarPorId(Long id) {
        return contratoRepository.findById(id);
    }
}