package edu.upc.dsa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ProductManagerImpl implements ProductManager{

    HashMap<String,Producto> productos;
    HashMap<String,Usuario> usuarios;
    Stack<Pedido> pila ;



    private static final Logger logger = LogManager.getLogger(ProductManagerImpl.class.getName());

    private static ProductManagerImpl productManagerimpl = null;

    public static ProductManagerImpl getInstance() {
        if(productManagerimpl ==null)
            productManagerimpl = new ProductManagerImpl();
        return productManagerimpl;
    }

    private ProductManagerImpl() {
        this.productos = new HashMap<String,Producto>();
        this.usuarios = new HashMap<String,Usuario>();
        pila = new Stack<Pedido>();

        Producto p1 = new Producto("bocata", (double)12);
        Producto p2 = new Producto("beguda", (double)13);
        productos.put("bocata",p1);
        productos.put("beguda",p2);

       // productos.add(p1);
      //  productos.add(p2);
        Usuario u1= new Usuario("juan");
        Usuario u2 = new Usuario("marta");
        Usuario u3 = new Usuario("zarta");
        usuarios.put("juan",u1);
        usuarios.put("marta",u2);
        usuarios.put("zarta",u3);




    }
    public ArrayList<Producto> Ordenarprecio(){

        ArrayList<Producto> productos = new ArrayList<Producto>();
        for (Producto o: this.productos.values()) {
            productos.add(o);

        }
        Collections.sort(productos);
        logger.info("retorn vector ordenat");
        return productos;
    }


    public void Hacerpedido(String nombre, Vector<Comanda> comandas){

        logger.info("numero stacks abans"+pila.size());
        Pedido p = new Pedido(usuarios.get(nombre),comandas);
        pila.push(p);
        logger.info("numero stacks despres"+pila.size());

    }

    public void Servirpedido(){
        Pedido p = pila.pop();
        p.getUsuario().añadirpedido(p);
        logger.info("l'usuari ara te un pedido mes");

        //bucle sumar ventas
    }

    public Vector<Pedido> listapedidosrealizado(Usuario u){

        logger.info("l'usuari ara te un pedido mes");
        return u.getPedidos();

    }


    public void listaproductosordenadoventas(){

    }







    public void reiniciarSingleton()
    {
        productManagerimpl = null;
    }
//ususario comanda, aqui respon

}
