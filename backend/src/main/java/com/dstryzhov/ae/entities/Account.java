package com.dstryzhov.ae.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    private BigDecimal balance;
}
