package br.com.veneza.imoveis.controllers;

import br.com.veneza.imoveis.models.Seguradora;
import br.com.veneza.imoveis.services.SeguradoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguradoras")
public class SeguradoraController {

    @Autowired
    private SeguradoraService seguradoraService;

    @PostMapping
    public ResponseEntity<Seguradora> criarSeguradora(@RequestBody Seguradora seguradora) {
        return ResponseEntity.status(HttpStatus.CREATED).body(seguradoraService.criarSeguradora(seguradora));
    }

    @GetMapping
    public ResponseEntity<List<Seguradora>> listarSeguradoras() {
        return ResponseEntity.ok(seguradoraService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seguradora> buscarSeguradoraPorId(@PathVariable Long id) {
        return seguradoraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}