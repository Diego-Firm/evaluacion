package com.itdata.evaluacion.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "account", schema = "eval", catalog = "")
public class AccountEntity {
    private Integer idAccount;
    private String numero;
    private String tipo;
    private Integer monto;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Integer customerIdCustomer;
    private CustomerEntity customerByCustomerIdCustomer;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_account")
    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    @Basic
    @Column(name = "numero")
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "monto")
    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    @Basic
    @Column(name = "fecha_creacion")
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Basic
    @Column(name = "fecha_modificacion")
    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Basic
    @Column(name = "customer_id_customer")
    public Integer getCustomerIdCustomer() {
        return customerIdCustomer;
    }

    public void setCustomerIdCustomer(Integer customerIdCustomer) {
        this.customerIdCustomer = customerIdCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return Objects.equals(idAccount, that.idAccount) &&
                Objects.equals(numero, that.numero) &&
                Objects.equals(tipo, that.tipo) &&
                Objects.equals(monto, that.monto) &&
                Objects.equals(fechaCreacion, that.fechaCreacion) &&
                Objects.equals(fechaModificacion, that.fechaModificacion) &&
                Objects.equals(customerIdCustomer, that.customerIdCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccount, numero, tipo, monto, fechaCreacion, fechaModificacion, customerIdCustomer);
    }

    @ManyToOne
    @JoinColumn(name = "customer_id_customer", referencedColumnName = "id_customer", nullable = false,
            updatable = false, insertable = false)
    public CustomerEntity getCustomerByCustomerIdCustomer() {
        return customerByCustomerIdCustomer;
    }

    public void setCustomerByCustomerIdCustomer(CustomerEntity customerByCustomerIdCustomer) {
        this.customerByCustomerIdCustomer = customerByCustomerIdCustomer;
    }
}
