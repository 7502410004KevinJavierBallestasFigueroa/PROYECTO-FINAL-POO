
package co.edu.unicartagena.controlator;

import co.edu.unicartagena.entities.Chef;
import co.edu.unicartagena.entities.Menu;
import co.edu.unicartagena.entities.Restaurante;
import co.edu.unicartagena.repositories.RestauranteRepository;
import java.util.*;

/**
 *
 * @author kevin
 */
public class RestauranteControlador {
    private RestauranteRepository repositorio;

    public RestauranteControlador() {
        this.repositorio = new RestauranteRepository();
    }

    public void agregarRestaurante(String nombre, String tipoComida, String ubicacion){
        Restaurante restaurante = new Restaurante(nombre, tipoComida, ubicacion);
        repositorio.crear(restaurante);
    }

    public List<Restaurante> listarRestaurantes() {
        //repositorio.listar().forEach(System.out::println);
        return repositorio.listar();
    }
    
    public void actualizarRestaurante(String nombre, Restaurante restauranteActualizado) {
    repositorio.actualizar(nombre, restauranteActualizado);
    }
    
    public void eliminarRestaurante(String nombre) {
    repositorio.eliminar(nombre);
    }
    public void agregarChefARestaurante(int restauranteIndex, Chef chef){
        repositorio.agregarChefARestaurante(restauranteIndex, chef);
    }

    public void agregarMenuARestaurante(int restauranteIndex, Menu menu){
        repositorio.agregarMenuARestaurante(restauranteIndex, menu);
    }
}
