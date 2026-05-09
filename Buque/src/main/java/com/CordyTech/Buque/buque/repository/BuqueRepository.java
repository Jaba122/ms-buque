package com.CordyTech.Buque.buque.repository;

import com.CordyTech.Buque.buque.model.Buque;
import com.CordyTech.Buque.buque.model.EstadoBuque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuqueRepository extends JpaRepository<Buque, Long> {

    Optional<Buque> findByCodBuque(String codBuque);

    Optional<Buque> findByImoNumero(String imoNumero);

    List<Buque> findByEstadoBuque(EstadoBuque estadoBuque);

    List<Buque> findByBandera(String bandera);

    boolean existsByCodBuque(String codBuque);

    boolean existsByImoNumero(String imoNumero);
}