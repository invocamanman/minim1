package edu.upc.dsa;

import java.util.Vector;

public class Pedido {
    Vector<Comanda> comandas;
    Usuario usuario;

    public Pedido() {
    }

    public Pedido(Usuario usuario, Vector<Comanda> comandas) {
        this.comandas = comandas;
        this.usuario = usuario;
    }

    public Vector<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(Vector<Comanda> comandas) {
        this.comandas = comandas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}

