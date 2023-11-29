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
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(name = "staffs")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "store_staff", joinColumns = @JoinColumn(name = "store_id", referencedColumnName = "storeId"),
            inverseJoinColumns = @JoinColumn(name = "staff_id", referencedColumnName = "staffId"))
    private Set<Staff> staffs;

    public Store() {
    }

    public Set<Staff> getStaff() {
        return staffs;
    }

    public void setStaff(Set<Staff> staffs) {
        this.staffs = staffs;
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
