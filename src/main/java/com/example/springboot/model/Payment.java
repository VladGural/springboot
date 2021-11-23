package com.example.springboot.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long source_acc_id;
    private Long dest_acc_id;
    private BigDecimal amount;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSource_acc_id() {
        return source_acc_id;
    }

    public void setSource_acc_id(Long source_acc_id) {
        this.source_acc_id = source_acc_id;
    }

    public Long getDest_acc_id() {
        return dest_acc_id;
    }

    public void setDest_acc_id(Long dest_acc_id) {
        this.dest_acc_id = dest_acc_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
