
package co.edu.unicartagena.entities;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author kevin
 */
public class Restaurante {
    private String nombre;
    private String tipoComida;
    private String ubicacion;
    private List<Chef> chefs;
    private List<Menu> menus;

    public Restaurante(String nombre, String tipoComida, String ubicacion) {
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.ubicacion = ubicacion;
        this.chefs = new ArrayList<>();
        this.menus = new ArrayList<>();
    }

    public String getNombre(){ 
        return nombre; 
    }
    public void setNombre(String nombre){ 
        this.nombre = nombre; 
    }

    public String getTipoComida(){ 
        return tipoComida;
    }
    public void setTipoComida(String tipoComida){ 
        this.tipoComida = tipoComida; 
    }

    public String getUbicacion(){ 
        return ubicacion; 
    }
    public void setUbicacion(String ubicacion){ 
        this.ubicacion = ubicacion; 
    }

    public List<Chef> getChefs(){ 
        return chefs; 
    }
    public void setChefs(List<Chef> chefs){ 
        this.chefs = chefs; 
    }

    public List<Menu> getMenus(){ 
        return menus; 
    }
    public void setMenus(List<Menu> menus){ 
        this.menus = menus; 
    }

    // Métodos para gestionar listas
    public void agregarChef(Chef chef) {
        chefs.add(chef);
    }

    public void eliminarChef(Chef chef) {
        chefs.remove(chef);
    }

    public void agregarMenu(Menu menu) {
        menus.add(menu);
    }

    public void eliminarMenu(Menu menu) {
        menus.remove(menu);
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nombre='" + nombre + '\'' +
                ", tipoComida='" + tipoComida + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", chefs=" + chefs +
                ", menus=" + menus +
                '}';        
    }
}
