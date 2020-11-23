package edu.upc.dsa.services;
import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImp;
import edu.upc.dsa.models.Laboratorio;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/service", description = "Endpoint to Muestra Service")
@Path("/service")

public class RestService {

    private Covid19Manager cv;

    public RestService() {
        this.cv = Covid19ManagerImp.getInstance();

    }

    @POST
    @ApiOperation(value = "create a new User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Persona.class)

    })

    @Path("/newuser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newPers(Persona pers) {


        this.cv.addPers(pers.getIdPer(),pers.getNombre(), pers.getApellido(), pers.getSalud());
        return Response.status(201).entity(pers).build();
    }

    @POST
    @ApiOperation(value = "create a new Lab", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Persona.class)

    })

    @Path("/newlab")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newLab(Laboratorio lab) {


        this.cv.addLab(lab.getIdentificador(), lab.getNombre());
        return Response.status(201).entity(lab).build();
    }

    @POST
    @ApiOperation(value = "create a new muestra", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Muestra.class)

    })

    @Path("/newmuestra")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newMuestra(Muestra mst) {


        this.cv.addMuest(mst.getIdMuestra(), mst.getIdPersona(), mst.getIdClinico(), mst.getIdLaboratorio(), mst.getFecha());
        return Response.status(201).entity(mst).build();
    }

}
