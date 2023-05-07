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

    @Query(value = "select c from Currency c where c.createdAt=(select max(createdAt) from Currency where symbol=:symbol)")
    Currency findCurrentCurrency(String symbol);

    @Query(value = "select c.price_usd from Currency c where c.createdAt=(select max(createdAt) from Currency where symbol=:symbol)")
    Double findPriceBySymbol(String symbol);
    @Query(value = "select distinct c.symbol from Currency c")
    List<String> findAllSymbols();

}
