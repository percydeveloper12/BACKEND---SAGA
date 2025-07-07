package com.upn.reclutamiento.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre") // o el nombre real en la base de datos
    private String nombre;

    // getters y setters
    
    
    public String getNombre() {
        return nombre;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

