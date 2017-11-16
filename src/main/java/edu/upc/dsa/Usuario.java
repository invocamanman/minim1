package edu.upc.dsa;

import java.util.ArrayList;
import java.util.Vector;

public class Usuario {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    String nombre;
    ArrayList<Pedido> pedidos;


    public void añadirpedido(Pedido p){
        pedidos.add(p);
    }

    public Usuario(String nombre) {
        pedidos = new ArrayList<Pedido>();
        this.nombre = nombre;
    }

    public Usuario() {

    }
}
