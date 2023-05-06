package com.watcher.model.repository;

import com.watcher.model.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    @Query(value = "select c from Currency c group by c.id")
    List<Currency> getAllCurrencies();

    @Query(value = "select c from Currency c where c.createdAt=(select max(createdAt) from Currency where id IN(:id))")
    List<Currency> findCurrentCurrency(@Param("id") Long id);
//    @Query(value = "select c from Currency c where c.createdAt=(select max(c.createdAt) from Currency) and c.id=:id")

    @Query(value = "select c from Currency c where c.createdAt=(select max(createdAt) from Currency)")
    Currency findCurrency();
}
