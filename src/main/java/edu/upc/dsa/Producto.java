package edu.upc.dsa;

import java.util.Comparator;

public class Producto implements Comparable<Producto>{
    private String nombre;
    private Double precio;

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.ventas = 0;
    }

    private int ventas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }


    @Override
    public int compareTo(Producto P) {

        return (int)(this.precio-P.getPrecio());
    }
}
