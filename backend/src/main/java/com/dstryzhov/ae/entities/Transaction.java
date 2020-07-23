package com.dstryzhov.ae.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @ColumnDefault("random_uuid()")
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    private BigDecimal amount;

    @CreatedDate
    @Temporal(TemporalType.DATE)
    @ColumnDefault("current_date()")
    private Date effectiveDate = new Date();

    public Transaction(Type type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
    }

    public enum Type {
        debit, credit
    }
}
