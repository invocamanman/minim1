package edu.upc.dsa;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/json")
public class JSONService {



    public JSONService() {}



    @GET
    @Path("/gotproductos/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Pedido> getproductosusuario(@PathParam("nombre") String nombre) {

        Producto p1 = new Producto("bocata", (double)12);
        Producto p2 = new Producto("beguda", (double)13);


        Usuario u1= new Usuario("juani");



        Comanda c1 = new Comanda(p1, 10);
        Comanda c2 = new Comanda(p2, 20);
        Vector<Comanda> comandas = new Vector<Comanda>();
        comandas.add(c1);
        comandas.add(c2);
        Pedido p = new Pedido(u1,comandas);

        ProductManagerImpl.getInstance().Hacerpedido(p);


        return ProductManagerImpl.getInstance().listapedidosrealizadousuario(nombre);

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
    public ArrayList<Producto> getProductoprecio() {


        return ProductManagerImpl.getInstance().Ordenarprecio();


    }


    @POST
    @Path("/hacer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response hacerpedido(Pedido p) {


        ProductManagerImpl.getInstance().Hacerpedido(p);

        return Response.status(201).entity("hecho").build();
    }

    @GET
    @Path("/servir")
    @Consumes(MediaType.APPLICATION_JSON)
    public Pedido servirpedido() {
        Producto p1 = new Producto("bocataaaa", (double)12);
        Producto p2 = new Producto("beguda", (double)13);


        Usuario u1= new Usuario("juano");


        Comanda c1 = new Comanda(p1, 10);
        Comanda c2 = new Comanda(p2, 20);
        Vector<Comanda> comandas = new Vector<Comanda>();
        comandas.add(c1);
        comandas.add(c2);
        Pedido p = new Pedido(u1,comandas);
        ProductManagerImpl.getInstance().Hacerpedido(p);


        return ProductManagerImpl.getInstance().Servirpedido();

    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public KeyUser login(Usuario user)
    {
        KeyUser key = new KeyUser();
        key.setKey(1);
        return key;
    }








}