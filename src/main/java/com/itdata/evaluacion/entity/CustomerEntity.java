package com.itdata.evaluacion.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "eval", catalog = "")
public class CustomerEntity {
    private Integer idCustomer;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private Integer edad;
    private Date fecha;
    private Collection<AccountEntity> accountsByIdCustomer;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_customer")
    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "dni")
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Basic
    @Column(name = "edad")
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Basic
    @Column(name = "fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(idCustomer, that.idCustomer) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(apellido, that.apellido) &&
                Objects.equals(dni, that.dni) &&
                Objects.equals(correo, that.correo) &&
                Objects.equals(edad, that.edad) &&
                Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCustomer, nombre, apellido, dni, correo, edad, fecha);
    }

    @OneToMany(mappedBy = "customerByCustomerIdCustomer", cascade = CascadeType.REMOVE)
    public Collection<AccountEntity> getAccountsByIdCustomer() {
        return accountsByIdCustomer;
    }

    public void setAccountsByIdCustomer(Collection<AccountEntity> accountsByIdCustomer) {
        this.accountsByIdCustomer = accountsByIdCustomer;
    }
}
