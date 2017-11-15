package edu.upc.dsa;


import java.util.ArrayList;
import java.util.Vector;

public interface ProductManager {

    public ArrayList<Producto> Ordenarprecio();
    public void Hacerpedido(String nombre, Vector<Comanda> comandas);
    public Pedido Servirpedido();
    public Vector<Pedido> listapedidosrealizado(Usuario u);
    public ArrayList<Producto> listaproductosordenadoventas();

}
