package ru.javarush.lukyanov.hibernate2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "payment_id")
    private Short paymentId;
    @Column(name = "customer_id")
    private Short customerId;
    @Column(name = "staff_id")
    private Byte staffId;
    @Column(name = "rental_id")
    private Integer rentalId;
    @Column(name = "amount")
    private java.math.BigDecimal amount;
    @Column(name = "payment_date")
    private LocalDate paymentDate;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public Payment() {
    }

    public Short getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Short paymentId) {
        this.paymentId = paymentId;
    }

    public Short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Short customerId) {
        this.customerId = customerId;
    }

    public Byte getStaffId() {
        return staffId;
    }

    public void setStaffId(Byte staffId) {
        this.staffId = staffId;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
