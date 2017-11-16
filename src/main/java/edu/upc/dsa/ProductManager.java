package edu.upc.dsa;


import java.util.ArrayList;
import java.util.Vector;

public interface ProductManager {

    public ArrayList<Producto> Ordenarprecio();
    public void Hacerpedido(Pedido p);
    public Pedido Servirpedido();
    public ArrayList<Pedido> listapedidosrealizadousuario(String nombre);
    public ArrayList<Producto> listaproductosordenadoventas();

}
