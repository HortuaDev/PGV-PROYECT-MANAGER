package net.salesianos.Object;

public class Product {
    int id;
    String nombre;
    String categoria;
    Float cantidad;
    Float precio;

    public Product(int id, String nombre, String categoria, Float cantidad, Float precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", cantidad=" + cantidad
                + ", precio=" + precio + "]";
    }
}
