package edu.upc.dsa;

import edu.upc.dsa.models.Informe;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;

import java.util.List;

public interface Covid19Manager {
    public void addPers(String id, String name, String apellido, String salud);
    public void addLab(String identificador, String nombre);
    public void addMuest(String idMuestra, String idPersona, String idClinico, String idLaboratorio, String fecha);
    public List<Muestra> listMuest(String idusuario);

    public Informe procesarMuestra(String idlab, String res, String descp);
    public int numlabs();
    public Persona getPers(String id);
    public void clear();
}
