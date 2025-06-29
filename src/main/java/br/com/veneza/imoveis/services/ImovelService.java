package br.com.veneza.imoveis.services;

import br.com.veneza.imoveis.models.Imovel;
import br.com.veneza.imoveis.repositories.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public Imovel criarImovel(Imovel imovel) {

        return imovelRepository.save(imovel);
    }

    public List<Imovel> listarTodos() {
        return imovelRepository.findAll();
    }

    public Optional<Imovel> buscarPorId(Long id) {
        return imovelRepository.findById(id);
    }
}