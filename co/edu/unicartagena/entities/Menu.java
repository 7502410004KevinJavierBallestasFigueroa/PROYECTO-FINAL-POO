package co.edu.unicartagena.entities;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author kevin
 */
public class Menu {
    private String nombre;
    private List<String> platos;
    private double precio;

    public Menu(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.platos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getPlatos() {
        return platos;
    }
    public void setPlatos(List<String> platos) {
        this.platos = platos;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Métodos para gestionar la lista de platos
    public void agregarPlato(String plato) {
        platos.add(plato);
    }

    public void eliminarPlato(String plato) {
        platos.remove(plato);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "nombre='" + nombre + '\'' +
                ", platos=" + platos +
                ", precio=" + precio +
                '}';
    }
}
