package co.edu.unicartagena.controlator;

import co.edu.unicartagena.entities.Menu;
import co.edu.unicartagena.repositories.MenuRepository;
import java.util.*;

/**
 *
 * @author kevin
 */
public class MenuControlador {
    private MenuRepository repositorio;

    public MenuControlador() {
        this.repositorio = new MenuRepository();
    }

    public void agregarMenu(String nombre, double precio, List<String> platos){
        Menu menu = new Menu(nombre, precio);
        for (String plato : platos) {
            menu.agregarPlato(plato);
        }
        repositorio.crear(menu);
    }

    public List<Menu> listarMenus() {
        return repositorio.listar();
    }
    
    public void actualizarMenu(String nombre, Menu menuActualizado) {
        repositorio.actualizar(nombre, menuActualizado);
    }
    
    public void eliminarMenu(String nombre) {
        repositorio.eliminar(nombre);
    }
}
