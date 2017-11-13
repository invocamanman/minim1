package edu.upc.dsa;

import java.util.Vector;

public class Pedido {
    Vector<Comanda> comandas;
    Boolean realizado;
    Usuario usuario;



    public Pedido(Usuario usuario, Vector<Comanda> comandas) {
        this.comandas = comandas;
        this.realizado = false;
        this.usuario = usuario;
    }

    public Vector<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(Vector<Comanda> comandas) {
        this.comandas = comandas;
    }

    public Boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

