package edu.upc.dsa.models;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import edu.upc.*;

public class Laboratorio{
    String identificador;
    String nombre;
    Queue<Muestra> muestras ;

    public Laboratorio(){}

    public Laboratorio(String identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public Queue<Muestra> getMuestras() {
        return muestras;
    }

    public void addMuestras(String idm, String idl,String idc,String idP,String fec){
        Muestra mst= new Muestra(idm,idP,idc,idl,fec);
        this.muestras.add(mst);
    }
}
