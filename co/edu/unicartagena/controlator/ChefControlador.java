package co.edu.unicartagena.controlator;

/**
 *
 * @author kevin
 */
import co.edu.unicartagena.entities.Chef;
import co.edu.unicartagena.repositories.ChefRepository;
import java.util.List;

public class ChefControlador {
    private ChefRepository repositorio;

    public ChefControlador() {
        this.repositorio = new ChefRepository();
    }

    // Agregar un nuevo chef
    public void agregarChef(String nombre, String especialidad, int experiencia) {
        Chef chef = new Chef(nombre, especialidad, experiencia);
        repositorio.crear(chef);
    }

    // Listar todos los chefs
    public List<Chef> listarChefs() {
        return repositorio.listar();
    }

    // Actualizar un chef por su nombre
    public void actualizarChef(String nombre, Chef chefActualizado) {
        repositorio.actualizar(nombre, chefActualizado);
    }

    // Eliminar un chef por su nombre
    public void eliminarChef(String nombre) {
        repositorio.eliminar(nombre);
    }
}

