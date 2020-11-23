package edu.upc.dsa;

import edu.upc.dsa.models.Informe;
import edu.upc.dsa.models.Laboratorio;
import edu.upc.dsa.models.Persona;
import edu.upc.dsa.models.Muestra;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;

public class Covid19ManagerImp implements Covid19Manager{
    private static Covid19Manager instance;
    private int numlabs;
    private Laboratorio Laboratorios[];
    private static int num =10;
    HashMap<String, Persona> personas;
    final static Logger logger = Logger.getLogger(Covid19ManagerImp.class.getName());

    private Covid19ManagerImp() {
        this.personas = new HashMap<>();
        this.numlabs = 0;
        this.Laboratorios = new Laboratorio[num];
    }

    public static Covid19Manager getInstance(){
        if(instance==null){
            instance = new Covid19ManagerImp();
        }
        return instance;
    }

    @Override
    public void addPers(String id, String name, String apellido, String salud){
        logger.debug("Entering User");
        Persona user = new Persona(id,name,apellido,salud);
        this.personas.put(id, user);
        logger.info("addPers completed");


    }

    @Override
    public void addLab(String identificador, String nombre){
        logger.debug("Entering Lab");
        Laboratorio lab = new Laboratorio(identificador,nombre);
        this.Laboratorios[this.numlabs]=lab;
        this.numlabs+=1;
        logger.info("addLab completed");
        logger.info(lab.getIdentificador());

    }

    @Override
    public void addMuest(String idMuestra, String idPersona, String idClinico, String idLaboratorio, String fecha){
        logger.debug("Entering muestra");

        Laboratorio lab1 = null;
        int found=0;
        for(int i = 0; i<this.numlabs; i++) {
            logger.info(this.Laboratorios[i].getIdentificador());
            if(idLaboratorio.equals(this.Laboratorios[i].getIdentificador())){
                lab1 = this.Laboratorios[i];
                found=i;
                logger.info("Lab found");
            }
        }
        if (lab1!=null){
            Muestra mst = new Muestra(idMuestra,idPersona,idClinico,idLaboratorio,fecha);
            logger.info("nuevo lab actualizado1");
            Laboratorio lab = new Laboratorio(Laboratorios[found].getIdentificador(),Laboratorios[found].getNombre());
            logger.info("nuevo lab actualizado 2");
            lab.addMuestras(idMuestra,idLaboratorio,idClinico,idPersona,fecha);
            logger.info("nuevo lab actualizado 3");
            this.Laboratorios[found]=lab;
            logger.info("nuevo lab actualizado 4");

        }else
            logger.error("Lab not found");
        logger.info("addMuest completed");

    }
    @Override
    public List<Muestra> listMuest(String idusuario){
        List<Muestra> x;
        Persona pers = personas.get(idusuario);
        x=pers.getMuestras();
        if (pers!=null){
            logger.info("Usuario encontrado, devolviendo lista");
            return x;
        }else
            logger.error("no existe usuario");
            return null;
    }

    @Override
    public Informe procesarMuestra(String idlab,String res,String descp){
        Laboratorio lab1 = null;
        for(int i = 0; i<this.numlabs; i++) {
            if(idlab.equals(this.Laboratorios[i].getIdentificador())){
                lab1 = this.Laboratorios[i];
            }
        }

        if (lab1!=null){
            Muestra mst = lab1.getMuestras().poll();
            Informe inf = new Informe(res,descp, mst.getIdMuestra());
            logger.info("Muestra creada");
            return inf;
        }else
            logger.error("Lab not found");
            return null;





    }
   /* @Override
    public Informe procMuest(String idlab, String resultado,String description){

        /*Laboratorio lab1 = null;
        for(int i = 0; i<this.numlabs; i++) {
            if(idlab.equals(this.Laboratorios[i].getIdentificador())){
                lab1 = this.Laboratorios[i];
            }
        }

        if (lab1!=null){
            Muestra mst = lab1.getMuestras().poll();
            Informe inf = new Informe(resultado,description, mst.getIdMuestra());
            return inf;
        }else
            return null;
            logger.error("Lab not found");

        logger.info("procMuest completed");
        Informe inf =null;
        return inf;
    }*/

    @Override
    public void clear(){
        personas.clear();
        Laboratorios = new Laboratorio[10];
        instance = null;
    }

    @Override
    public int numlabs(){return this.numlabs;}

    public Persona getPers(String id){return personas.get(id);}
}
