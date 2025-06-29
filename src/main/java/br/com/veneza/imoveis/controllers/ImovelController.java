package br.com.veneza.imoveis.controllers;

import br.com.veneza.imoveis.models.Imovel;
import br.com.veneza.imoveis.services.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imoveis")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @PostMapping
    public ResponseEntity<Imovel> criarImovel(@RequestBody Imovel imovel) {
        Imovel novoImovel = imovelService.criarImovel(imovel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoImovel);
    }

    @GetMapping
    public ResponseEntity<List<Imovel>> listarImoveis() {
        return ResponseEntity.ok(imovelService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> buscarImovelPorId(@PathVariable Long id) {
        return imovelService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}