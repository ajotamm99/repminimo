package edu.upc.dsa.models;

public class Muestra {
    String idMuestra;
    String idPersona;
    String idClinico;
    String idLaboratorio;
    String fecha;

    public Muestra(){}


    public Muestra(String idMuestra, String idPersona, String idClinico, String idLaboratorio, String fecha) {
        this.idPersona = idPersona;
        this.idMuestra=idMuestra;
        this.idClinico = idClinico;
        this.idLaboratorio = idLaboratorio;
        this.fecha = fecha;
    }

    public void setIdMuestra(String idMuestra) {
        this.idMuestra = idMuestra;
    }

    public String getIdMuestra() {
        return idMuestra;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public String getIdClinico() {
        return idClinico;
    }

    public String getIdLaboratorio() {
        return idLaboratorio;
    }

    public String getFecha() {
        return fecha;
    }



    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public void setIdClinico(String idClinico) {
        this.idClinico = idClinico;
    }

    public void setIdLaboratorio(String idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
