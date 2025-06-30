package br.com.veneza.imoveis.services;

import br.com.veneza.imoveis.models.Seguradora;
import br.com.veneza.imoveis.repositories.SeguradoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeguradoraService {

    @Autowired
    private SeguradoraRepository seguradoraRepository;

    public Seguradora criarSeguradora(Seguradora seguradora) {
        return seguradoraRepository.save(seguradora);
    }

    public List<Seguradora> listarTodas() {
        return seguradoraRepository.findAll();
    }

    public Optional<Seguradora> buscarPorId(Long id) {
        return seguradoraRepository.findById(id);
    }
}