package edu.upc.dsa;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/json")
public class JSONService {



    public JSONService() {}



   /* @GET
    @Path("/gotproductos/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUsuario(@PathParam("nombre") String nombre) {
        return Usuariomap.getInstance().mapa.get(nombre);
    }
*/

    @GET
    @Path("/gotproductosprecio")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductoprecio() {

        return "hola";

    }







}