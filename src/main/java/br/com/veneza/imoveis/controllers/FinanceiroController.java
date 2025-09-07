package br.com.veneza.imoveis.controllers;

import br.com.veneza.imoveis.models.Recibo;
import br.com.veneza.imoveis.services.FinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/financeiro")
public class FinanceiroController {

    @Autowired
    private FinanceiroService financeiroService;

    @PostMapping("/gerar-cobranca/{contratoId}")
    public ResponseEntity<Recibo> gerarCobranca(@PathVariable Long contratoId) {
        try {
            Recibo reciboGerado = financeiroService.gerarPrimeiraCobranca(contratoId);
            return ResponseEntity.status(HttpStatus.CREATED).body(reciboGerado);
        } catch (RuntimeException e) {
            // Retorna uma resposta de erro caso o contrato não seja encontrado ou a cobrança já exista
            return ResponseEntity.badRequest().body(null);
        }
    }
}