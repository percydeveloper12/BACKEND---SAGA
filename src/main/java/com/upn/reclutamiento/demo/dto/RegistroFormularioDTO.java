package com.upn.reclutamiento.demo.dto;

public class RegistroFormularioDTO {
    private String nombre;
    private String usuario;
    private String correo;
    private String password;
    private String repetirPassword;

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRepetirPassword() { return repetirPassword; }
    public void setRepetirPassword(String repetirPassword) { this.repetirPassword = repetirPassword; }
}

