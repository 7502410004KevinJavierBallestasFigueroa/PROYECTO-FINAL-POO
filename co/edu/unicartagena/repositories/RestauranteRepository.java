
package co.edu.unicartagena.repositories;

import co.edu.unicartagena.entities.Chef;
import co.edu.unicartagena.entities.Menu;
import co.edu.unicartagena.entities.Restaurante;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author kevin
 */
public class RestauranteRepository{

    private static final String FILE_PATH = "restaurantes.txt";
    
    private void guardarTodos(List<Restaurante> restaurantes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Restaurante rest : restaurantes) {
                writer.write(rest.getNombre() + "|" + rest.getTipoComida() + "|" + rest.getUbicacion());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    
    public void crear(Restaurante restaurante) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            // Escribe los datos del restaurante en una línea separada por "|"
            writer.write(restaurante.getNombre() + "|" + restaurante.getTipoComida() + "|" + restaurante.getUbicacion());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Restaurante> listar() {
        List<Restaurante> restaurantes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|"); // Divide la línea por el separador "|"
                if (parts.length == 3) {
                    restaurantes.add(new Restaurante(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return restaurantes;
    }

public void actualizar(String nombre, Restaurante restauranteActualizado) {
    List<Restaurante> restaurantes = listar();
    boolean encontrado = false;

    for (int i = 0; i < restaurantes.size(); i++) {
        Restaurante restaurante = restaurantes.get(i);
        if (restaurante.getNombre().equals(nombre)) {
            restaurantes.set(i, restauranteActualizado);
            encontrado = true;
            break;
        }
    }
    
    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "Restaurante no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        guardarTodos(restaurantes);
        JOptionPane.showMessageDialog(null, "Restaurante actualizado con éxito.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }

    guardarTodos(restaurantes);
}

public void eliminar(String nombre) {
    List<Restaurante> restaurantes = listar();
    boolean encontrado = false;

    for (int i = 0; i < restaurantes.size(); i++) {
        Restaurante restaurante = restaurantes.get(i);
        if (restaurante.getNombre().equals(nombre.trim())){
            restaurantes.remove(i);
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "Restaurante no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        guardarTodos(restaurantes);
        JOptionPane.showMessageDialog(null, "Restaurante eliminado con éxito.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }
}

    // Métodos adicionales para manejar relaciones
    public void agregarChefARestaurante(int index, Chef chef) {
        List<Restaurante> restaurantes = listar();
        if (index < 0 || index >= restaurantes.size()) {
            throw new IndexOutOfBoundsException("Número de índice inválido");
        }
        Restaurante restaurante = restaurantes.get(index);
        restaurante.agregarChef(chef);
        guardarTodos(restaurantes);
    }

    public void agregarMenuARestaurante(int index, Menu menu) {
        List<Restaurante> restaurantes = listar();
        if (index < 0 || index >= restaurantes.size()) {
            throw new IndexOutOfBoundsException("Número de índice inválido");
        }
        Restaurante restaurante = restaurantes.get(index);
        restaurante.agregarMenu(menu);
        guardarTodos(restaurantes);
    }
       
}
