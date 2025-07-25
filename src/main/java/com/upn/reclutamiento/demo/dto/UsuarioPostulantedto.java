package com.upn.reclutamiento.demo.dto;

public class UsuarioPostulantedto {
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private String cv;

    public UsuarioPostulantedto() {}

    public UsuarioPostulantedto(Integer id, String nombre, String apellido, String dni, String cv) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.cv = cv;
    }

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getCv() { return cv; }
    public void setCv(String cv) { this.cv = cv; }
}
