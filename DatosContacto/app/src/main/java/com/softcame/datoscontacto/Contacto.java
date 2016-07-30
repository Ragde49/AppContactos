package com.softcame.datoscontacto;

import java.util.Date;

/**
 * Created by Edgar on 29/07/2016.
 */
public class Contacto {
    private String nombre;
    private Date fechaNac;
    private String telefono;
    private String email;
    private String descripcion;

    public Contacto(String nombre,Date fechaNac,String telefono,String email,String descripcion){
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
