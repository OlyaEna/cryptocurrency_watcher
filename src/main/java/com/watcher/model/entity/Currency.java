package com.watcher.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long currencyId;
    private Long id;
    private String symbol;
    private String name;
    private Double price_usd;
    private Double percent_change_24h;
    private Double percent_change_1h;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
}
