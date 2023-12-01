package ru.javarush.lukyanov.hibernate2.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @Column(name = "store_id")
    private Byte storeId;
    @Column(name = "manager_staff_id")
    private Byte managerStaffId;
    @Column(name = "address_id")
    private Short addressId;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "staffId")
    private Staff staff;

    public Store() {
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Byte getStoreId() {
        return storeId;
    }

    public void setStoreId(Byte storeId) {
        this.storeId = storeId;
    }

    public Byte getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(Byte managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public Short getAddressId() {
        return addressId;
    }

    public void setAddressId(Short addressId) {
        this.addressId = addressId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
