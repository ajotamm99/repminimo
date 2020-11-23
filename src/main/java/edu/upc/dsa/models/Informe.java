package edu.upc.dsa.models;

public class Informe {
    String idMuestra;
    String resultado;
    String comentario;
    public Informe(){}

    public Informe(String resultado, String comentario,String idMuestra) {
        this.resultado = resultado;
        this.comentario = comentario;
        this.idMuestra = idMuestra;

    }

    public String getResultado() {
        return resultado;
    }

    public String getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(String idMuestra) {
        this.idMuestra = idMuestra;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
