package com.devsuperior.dsvendas.repositories;

import com.devsuperior.dsvendas.dtos.SaleSuccessDTO;
import com.devsuperior.dsvendas.dtos.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsvendas.dtos.SaleSumDTO(obj.seller, SUM(obj.amount)) " +
            " FROM Sale as obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.devsuperior.dsvendas.dtos.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " +
            " FROM Sale as obj GROUP BY obj.seller")
    List<SaleSuccessDTO> successGroupedBySeller();
}
