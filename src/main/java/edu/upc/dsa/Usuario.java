package edu.upc.dsa;

import java.util.Vector;

public class Usuario {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Vector<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Vector<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    String nombre;
    Vector<Pedido> pedidos;

    public void añadirpedido(Pedido p){
        pedidos.add(p);
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }
}
