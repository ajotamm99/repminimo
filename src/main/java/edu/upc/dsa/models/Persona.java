package edu.upc.dsa.models;

import java.util.LinkedList;

public class Persona {
    String idPer;
    String nombre;
    String apellido;
    String salud;
    LinkedList<Muestra> muestras;

    public Persona(){}
    public Persona(String id, String name, String apellido, String salud){
        this.idPer=id;
        this.nombre=name;
        this.apellido=apellido;
        this.salud=salud;
        this.muestras= new LinkedList<>();

    }

    public void setIdPer(String idPer) {
        this.idPer = idPer;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSalud(String salud) {
        this.salud = salud;
    }

    public String getIdPer() {
        return idPer;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getSalud() {
        return salud;
    }

    public LinkedList<Muestra> getMuestras() {
        return muestras;
    }

    public void addMuestras(Muestra muestra){
        Muestra mst= new Muestra();
        mst.setFecha(muestra.getFecha());
        mst.setIdClinico(muestra.getIdClinico());
        mst.setIdLaboratorio(muestra.getIdLaboratorio());
        mst.setIdMuestra(muestra.getIdMuestra());;
        mst.setIdPersona(muestra.getIdPersona());
        this.muestras.add(mst);

    }
}
