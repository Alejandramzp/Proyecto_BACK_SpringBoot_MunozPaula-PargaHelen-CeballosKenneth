package com.example.POS.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class RolModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre_rol", unique = true, nullable = false)
    private RolNombre nombre_rol;

    public RolModel() {
    }

    public RolModel(Long id_rol, RolNombre nombre_rol) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public RolNombre getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(RolNombre nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public enum RolNombre {
        Cajero,
        Gerente,
        Administrador
    }

}


