package br.com.veneza.imoveis.services;

import br.com.veneza.imoveis.models.Recibo;
import br.com.veneza.imoveis.repositories.ReciboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReciboService {

    @Autowired
    private ReciboRepository reciboRepository;

    public List<Recibo> listarTodos() {
        return reciboRepository.findAll();
    }

    public Optional<Recibo> buscarPorId(Long id) {
        return reciboRepository.findById(id);
    }
}