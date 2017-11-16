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

        logger.debug("Constructos: crea usuarios, productos y pone un pedido a la cola");
        this.productos = new HashMap<String,Producto>();
        this.usuarios = new HashMap<String,Usuario>();
        pila = new Stack<Pedido>();


        //añadir unos productos i ususairos a sus mapas y un pedido a la pila para pruebas
        Producto p1 = new Producto("bocata", (double)12);
        Producto p2 = new Producto("beguda", (double)13);
        productos.put("bocata",p1);
        productos.put("beguda",p2);

        Usuario u1= new Usuario("juan");
        Usuario u2 = new Usuario("marta");
        Usuario u3 = new Usuario("zarta");
        usuarios.put("juan",u1);
        usuarios.put("marta",u2);
        usuarios.put("zarta",u3);

        Comanda c1 = new Comanda(p1, 10);
        Comanda c2 = new Comanda(p2, 20);
        Vector<Comanda> comandas = new Vector<Comanda>();
        comandas.add(c1);
        comandas.add(c2);
        Pedido p = new Pedido(u1,comandas);
        this.Hacerpedido(p);




    }
    public ArrayList<Producto>  Ordenarprecio(){

        logger.debug("Accion ordenar precio");

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
        logger.error("inicio hacer pedido");

        logger.error("numero stacks antes "+pila.size());
        pila.push(p);
        logger.error("numero stacks"+pila.size());

        if (!this.usuarios.containsKey(p.getUsuario().getNombre()))
        {
            logger.error("añade el nuevo usuario al mapa: "+p.getUsuario().getNombre());
            this.usuarios.put(p.getUsuario().getNombre(),p.getUsuario());
        }
        this.usuarios.get(p.getUsuario().getNombre()).añadirpedido(p);
        logger.error("l'usuari ara te un pedido mes");

        for(Comanda c : p.getComandas()){
            if (!this.productos.containsKey(c.getProducto().getNombre()))
            {
                logger.error("añade el nuevo producto al mapa: "+c.getProducto().getNombre());
                this.productos.put(c.getProducto().getNombre(),c.getProducto());
            }
            this.productos.get(c.getProducto().getNombre()).aumentarVendas(c.getCantidad());
            logger.error("el producto " + c.getProducto().getNombre() + " ha aumentado " + c.getCantidad());
        }



    }

    public Pedido Servirpedido(){

        logger.info("Servir pedido");
        logger.debug("Servir pedido");
        logger.error("Servir pedido");

        if (pila.size()==0){
            logger.error("la cola esta vacia!!!");
            return null;
        }
        else{
            logger.info("tamaño de pila antes de hace pop" + pila.size());
            Pedido p =pila.pop();
            logger.info("tamaño de pila despues de hace pop" + pila.size());
            return p;


        }


        //bucle sumar ventas
    }

    public ArrayList<Pedido> listapedidosrealizadousuario(String nombre){

        logger.error("inicio lista de pedidos realizados por usuario");

        if (usuarios.containsKey(nombre)) {
            int i = 1;
            Usuario u = usuarios.get(nombre);
            for (Pedido p : u.getPedidos()) {
                logger.error("Pedido " + i);
                for (Comanda c : p.getComandas()) {
                    logger.error("Producto: " + c.getProducto().getNombre() + " Cantidad " + c.getCantidad());
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

        /*
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto O1, Producto O2) {
                return O2.getVentas()-O1.getVentas();
            }
        });
        */
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
//ususario comanda, aqui respon

}
