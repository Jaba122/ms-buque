package com.CordyTech.Buque.buque.controller;

import com.CordyTech.Buque.buque.model.Buque;
import com.CordyTech.Buque.buque.model.EstadoBuque;
import com.CordyTech.Buque.buque.service.BuqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buques")
@RequiredArgsConstructor
public class BuqueController {

    private final BuqueService buqueService;

    // GET /api/buques
    @GetMapping
    public ResponseEntity<List<Buque>> listarTodos() {
        return ResponseEntity.ok(buqueService.listarTodos());
    }

    // GET /api/buques/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Buque> buscarPorId(@PathVariable Long id) {
        return buqueService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/buques/codigo/{codBuque}
    @GetMapping("/codigo/{codBuque}")
    public ResponseEntity<Buque> buscarPorCodigo(@PathVariable String codBuque) {
        return buqueService.buscarPorCodigo(codBuque)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/buques/imo/{imoNumero}
    @GetMapping("/imo/{imoNumero}")
    public ResponseEntity<Buque> buscarPorImo(@PathVariable String imoNumero) {
        return buqueService.buscarPorImo(imoNumero)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/buques/estado/{estado}
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Buque>> listarPorEstado(@PathVariable EstadoBuque estado) {
        return ResponseEntity.ok(buqueService.listarPorEstado(estado));
    }

    // GET /api/buques/bandera/{bandera}
    @GetMapping("/bandera/{bandera}")
    public ResponseEntity<List<Buque>> listarPorBandera(@PathVariable String bandera) {
        return ResponseEntity.ok(buqueService.listarPorBandera(bandera));
    }

    // POST /api/buques
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Buque buque) {
        try {
            Buque nuevo = buqueService.crear(buque);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // PUT /api/buques/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Buque buque) {
        try {
            Buque actualizado = buqueService.actualizar(id, buque);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/buques/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            buqueService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}