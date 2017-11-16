package edu.upc.dsa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ProductManagerImpl implements ProductManager{

    HashMap<String,Producto> productos;
    HashMap<String,Usuario> usuarios;
    Queue<Pedido> cola;



    private static final Logger logger = LogManager.getLogger(ProductManagerImpl.class.getName());

    private static ProductManagerImpl productManagerimpl = null;

    public static ProductManagerImpl getInstance() {
        if(productManagerimpl ==null)
            productManagerimpl = new ProductManagerImpl();
        return productManagerimpl;
    }

    private ProductManagerImpl() {

        logger.info("Constructor: crea usuarios, productos y pone un pedido a la cola");
        this.productos = new HashMap<String,Producto>();
        this.usuarios = new HashMap<String,Usuario>();
        cola = new LinkedList<Pedido>();


        //añadir unos productos i ususairos a sus mapas
        Producto p1 = new Producto("bocata", (double)12);
        Producto p2 = new Producto("beguda", (double)13);
        productos.put("bocata",p1);
        productos.put("beguda",p2);

        Usuario u1= new Usuario("juan");
        Usuario u2 = new Usuario("marta");
        Usuario u3 = new Usuario("zarta");
        Usuario u4= new Usuario("juani");
        Usuario u5= new Usuario("juano");
        usuarios.put("juan",u1);
        usuarios.put("marta",u2);
        usuarios.put("zarta",u3);
        usuarios.put("juani",u4);
        usuarios.put("juano",u5);
            }
    public ArrayList<Producto>  Ordenarprecio(){

        logger.info("Accion ordenar precio");

        ArrayList<Producto> productoslist = new ArrayList<Producto>();
        for (Producto o: this.productos.values()) {
            productoslist.add(o);

        }
        Collections.sort(productoslist);
        logger.info("la lista es:");
        for (Producto o: productoslist)
        {
            logger.info(o.getNombre());
        }

        return productoslist;
    }


    public void Hacerpedido(Pedido p){

        //hace el pedido, sino exite algun usuario/objeto los añade al mapa
        logger.info("inicio hacer pedido");

        logger.info("numero stacks antes "+cola.size());
        cola.add(p);
        logger.info("numero stacks"+cola.size());

        Usuario u = p.getUsuario();
        String nombre = u.getNombre();

        if (!this.usuarios.containsKey(nombre))
        {
            logger.info("añade el nuevo usuario al mapa: "+nombre);
            this.usuarios.put(nombre,u);
        }
        this.usuarios.get(nombre).añadirpedido(p);
        logger.info("l'usuari ara te un pedido mes");

        for(Comanda c : p.getComandas()){
            if (!this.productos.containsKey(c.getProducto().getNombre()))
            {
                logger.info("añade el nuevo producto al mapa: "+c.getProducto().getNombre());
                this.productos.put(c.getProducto().getNombre(),c.getProducto());
            }
            this.productos.get(c.getProducto().getNombre()).aumentarVendas(c.getCantidad());
            logger.info("el producto " + c.getProducto().getNombre() + " ha aumentado " + c.getCantidad());
        }



    }

    public Pedido Servirpedido(){

        logger.info("inicio Servir pedido");


        if (cola.size()==0){
            logger.error("la cola esta vacia!!!");
            return null;
        }
        else{
            logger.info("tamaño de pila antes de hace pop" + cola.size());
            Pedido p =cola.poll();
            logger.info("tamaño de pila despues de hace pop" + cola.size());
            return p;


        }



    }

    public ArrayList<Pedido> listapedidosrealizadousuario(String nombre){

        logger.info("inicio lista de pedidos realizados por usuario");

        if (usuarios.containsKey(nombre)) {
            int i = 1;
            Usuario u = usuarios.get(nombre);
            for (Pedido p : u.getPedidos()) {
                logger.info("Pedido " + i);
                for (Comanda c : p.getComandas()) {
                    logger.info("Producto: " + c.getProducto().getNombre() + " Cantidad " + c.getCantidad());
                }
                i++;
            }
            return u.getPedidos();
        }
        else
        {
            logger.error("no existe esta usuario en el mapa, por tanto no tendra lista de pedidos");
            return null;
        }

    }


    public ArrayList<Producto> listaproductosordenadoventas(){

        logger.info("inicio ordenar productor por ventas");

        ArrayList<Producto> productoslist = new ArrayList<Producto>(this.productos.values());

       Collections.sort(productoslist,Producto.Productoventascomparator);
       logger.info("retorn vector ordenado por vendas:");
        for (Producto o: productoslist)
        {
            logger.info(o.getNombre());
        }
        return productoslist;

    }

    public void reiniciarSingleton()
    {
        logger.info("reiniciar el singleton");
        productManagerimpl = null;
    }


}
