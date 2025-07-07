package com.upn.reclutamiento.demo.model;

import jakarta.persistence.*;

@Entity
public class Vacante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String descripcion;
    private String area;
    private String tipo;
    private String imagenUrl;

    // Constructor vacío (necesario para JPA)
    public Vacante() {}

    // Constructor personalizado usado en ProyectoController
    public Vacante(String titulo, String descripcion, String area, String tipo, String imagenUrl) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.area = area;
        this.tipo = tipo;
        this.imagenUrl = imagenUrl;
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }
}
