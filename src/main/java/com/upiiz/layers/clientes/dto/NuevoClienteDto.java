package com.upiiz.layers.clientes.dto;

// DTO de petición para crear/actualizar un Cliente
public class NuevoClienteDto {
    private String nombre;
    private String email;
    private String telefono;

    public NuevoClienteDto() {}

    public NuevoClienteDto(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
