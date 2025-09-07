package br.com.veneza.imoveis.controllers;

import br.com.veneza.imoveis.models.Recibo;
import br.com.veneza.imoveis.services.ReciboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recibos")
public class ReciboController {

    @Autowired
    private ReciboService reciboService;

    @GetMapping
    public ResponseEntity<List<Recibo>> listarRecibos() {
        return ResponseEntity.ok(reciboService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recibo> buscarReciboPorId(@PathVariable Long id) {
        return reciboService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}