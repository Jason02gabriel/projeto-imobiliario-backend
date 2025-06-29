package br.com.veneza.imoveis.controllers;

import br.com.veneza.imoveis.models.Contrato;
import br.com.veneza.imoveis.services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping
    public ResponseEntity<Contrato> criarContrato(@RequestBody Contrato contrato) {
        Contrato novoContrato = contratoService.criarContrato(contrato);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoContrato);
    }

    @GetMapping
    public ResponseEntity<List<Contrato>> listarContratos() {
        return ResponseEntity.ok(contratoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> buscarContratoPorId(@PathVariable Long id) {
        return contratoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}