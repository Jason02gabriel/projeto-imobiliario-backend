package br.com.veneza.imoveis.services;

import br.com.veneza.imoveis.models.Contrato;
import br.com.veneza.imoveis.models.Recibo;
import br.com.veneza.imoveis.models.StatusRecibo;
import br.com.veneza.imoveis.repositories.ContratoRepository;
import br.com.veneza.imoveis.repositories.ReciboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class FinanceiroService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ReciboRepository reciboRepository;

    @Transactional
    public Recibo gerarPrimeiraCobranca(Long contratoId) {

        Contrato contrato = contratoRepository.findById(contratoId)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado!"));

        LocalDate dataInicio = contrato.getDataInicio();
        LocalDate proximoVencimento = dataInicio.plusMonths(1).withDayOfMonth(contrato.getDiaVencimento());


        if (reciboRepository.existsByContratoAndDataVencimento(contrato, proximoVencimento)) {
            throw new RuntimeException("Cobrança para este período já existe!");
        }


        Recibo novoRecibo = new Recibo();
        novoRecibo.setContrato(contrato);
        novoRecibo.setDataVencimento(proximoVencimento);
        novoRecibo.setValor(contrato.getValorAluguel());
        novoRecibo.setStatus(StatusRecibo.PENDENTE);


        return reciboRepository.save(novoRecibo);
    }
}