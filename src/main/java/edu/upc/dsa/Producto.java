package edu.upc.dsa;

import java.util.Comparator;

public class Producto implements Comparable<Producto>{
    String nombre;
    Double precio;

    public Producto() {
    }

    public Producto(String nombre, Double precio, int ventas) {
        this.nombre = nombre;
        this.precio = precio;
        this.ventas = ventas;
    }

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.ventas = 0;
    }

    int ventas;

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

    public void aumentarVendas(int venta){
        this.ventas=this.ventas+venta;
    }


    @Override
    public int compareTo(Producto P) {

        return (int)(this.precio-P.getPrecio());
    }

    public static Comparator<Producto> Productoventascomparator
            = new Comparator<Producto>() {

        public int compare(Producto producto1, Producto producto2) {



            return producto2.getVentas()-producto1.getVentas();

        }

    };
}
