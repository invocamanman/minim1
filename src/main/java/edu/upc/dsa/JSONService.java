package edu.upc.dsa;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

@Path("/json")
public class JSONService {



    public JSONService() {}


/*
    @GET
    @Path("/gotproductos/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vector<Pedido> getproductosusuario(@PathParam("nombre") String nombre) {
        return ProductManagerImpl.getInstance().usuarios.get(nombre).getPedidos();
    }


    @GET
    @Path("/gotproductosventas")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Producto> getProductosventas() {


        return (Collection<Producto>)ProductManagerImpl.getInstance().listaproductosordenadoventas();


    }

    @GET
    @Path("/gotproductosprecio")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Producto> getProductoprecio() {


        return (Collection<Producto>)ProductManagerImpl.getInstance().Ordenarprecio();


    }


    @POST
    @Path("/post/hacer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response hacerpedido() {

        Producto p1 = new Producto("bocata", (double)12);
        Producto p2 = new Producto("beguda", (double)13);

        Comanda c1 = new Comanda(p1, 10);
        Comanda c2 = new Comanda(p2, 20);
        Vector<Comanda> comandas = new Vector<Comanda>();
        comandas.add(c1);
        comandas.add(c2);

        ProductManagerImpl.getInstance().Hacerpedido("juan", comandas);



        return Response.status(201).entity("hecho").build();
    }

    @POST
    @Path("/post/servir")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response servirpedido() {

        ProductManagerImpl.getInstance().Servirpedido();

        return Response.status(201).entity("hecho").build();
    }

*/






}