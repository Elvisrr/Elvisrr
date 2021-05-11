/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.fcys.programacion2.appactivos.core;

/**
 *
 * @author Sistemas-12
 */
public class Activos {
    
    private String nombre;
    private int activo;
    private int salvamiento;

    public Activos(String nombre, int activo, int salvamiento) {
        this.nombre = nombre;
        this.activo = activo;
        this.salvamiento = salvamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getSalvamiento() {
        return salvamiento;
    }

    public void setSalvamiento(int salvamiento) {
        this.salvamiento = salvamiento;
    }

    

    
}
