package com.CordyTech.Buque.buque.service;

import com.CordyTech.Buque.buque.model.Buque;
import com.CordyTech.Buque.buque.model.EstadoBuque;
import com.CordyTech.Buque.buque.repository.BuqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuqueService {

    private final BuqueRepository buqueRepository;

    // Listar todos
    public List<Buque> listarTodos() {
        return buqueRepository.findAll();
    }

    // Buscar por ID
    public Optional<Buque> buscarPorId(Long id) {
        return buqueRepository.findById(id);
    }

    // Buscar por código
    public Optional<Buque> buscarPorCodigo(String codBuque) {
        return buqueRepository.findByCodBuque(codBuque);
    }

    // Buscar por IMO
    public Optional<Buque> buscarPorImo(String imoNumero) {
        return buqueRepository.findByImoNumero(imoNumero);
    }

    // Listar por estado
    public List<Buque> listarPorEstado(EstadoBuque estadoBuque) {
        return buqueRepository.findByEstadoBuque(estadoBuque);
    }

    // Listar por bandera
    public List<Buque> listarPorBandera(String bandera) {
        return buqueRepository.findByBandera(bandera);
    }

    // Crear
    public Buque crear(Buque buque) {
        if (buqueRepository.existsByCodBuque(buque.getCodBuque())) {
            throw new RuntimeException("Ya existe un buque con el código: " + buque.getCodBuque());
        }
        if (buqueRepository.existsByImoNumero(buque.getImoNumero())) {
            throw new RuntimeException("Ya existe un buque con el IMO: " + buque.getImoNumero());
        }
        return buqueRepository.save(buque);
    }

    // Actualizar
    public Buque actualizar(Long id, Buque buqueActualizado) {
        Buque buque = buqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Buque no encontrado con id: " + id));

        buque.setNombreBuque(buqueActualizado.getNombreBuque());
        buque.setEsloraBuque(buqueActualizado.getEsloraBuque());
        buque.setManga(buqueActualizado.getManga());
        buque.setCalado(buqueActualizado.getCalado());
        buque.setTonelajeBruto(buqueActualizado.getTonelajeBruto());
        buque.setBandera(buqueActualizado.getBandera());
        buque.setAgenciaNaviera(buqueActualizado.getAgenciaNaviera());
        buque.setFechaHoraLlegada(buqueActualizado.getFechaHoraLlegada());
        buque.setFechaHoraPartida(buqueActualizado.getFechaHoraPartida());
        buque.setEstadoBuque(buqueActualizado.getEstadoBuque());

        return buqueRepository.save(buque);
    }

    // Eliminar
    public void eliminar(Long id) {
        if (!buqueRepository.existsById(id)) {
            throw new RuntimeException("Buque no encontrado con id: " + id);
        }
        buqueRepository.deleteById(id);
    }
}