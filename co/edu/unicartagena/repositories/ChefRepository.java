package co.edu.unicartagena.repositories;

import co.edu.unicartagena.entities.Chef;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ChefRepository {

    private static final String FILE_PATH = "chefs.txt";
    
    // Guardar todos los chefs en el archivo
    private void guardarTodos(List<Chef> chefs) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Chef chef : chefs) {
                writer.write(chef.getNombre() + "|" + chef.getEspecialidad() + "|" + chef.getExperiencia());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Crear un nuevo chef y guardarlo en el archivo
    public void crear(Chef chef) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            // Escribe los datos del chef en una línea separada por "|"
            writer.write(chef.getNombre() + "|" + chef.getEspecialidad() + "|" + chef.getExperiencia());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Listar todos los chefs desde el archivo
    public List<Chef> listar() {
        List<Chef> chefs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|"); // Divide la línea por el separador "|"
                if (parts.length == 3) {
                    String nombre = parts[0];
                    String especialidad = parts[1];
                    int experiencia = Integer.parseInt(parts[2]);
                    chefs.add(new Chef(nombre, especialidad, experiencia));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chefs;
    }

    // Actualizar un chef por su nombre
    public void actualizar(String nombre, Chef chefActualizado) {
        List<Chef> chefs = listar();
        boolean encontrado = false;

        for (int i = 0; i < chefs.size(); i++) {
            Chef chef = chefs.get(i);
            if (chef.getNombre().equals(nombre)) {
                chefs.set(i, chefActualizado);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Chef no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            guardarTodos(chefs);
            JOptionPane.showMessageDialog(null, "Chef actualizado con éxito.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Eliminar un chef por su nombre
    public void eliminar(String nombre) {
        List<Chef> chefs = listar();
        boolean encontrado = false;

        for (int i = 0; i < chefs.size(); i++) {
            Chef chef = chefs.get(i);
            if (chef.getNombre().equals(nombre.trim())) {
                chefs.remove(i);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Chef no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            guardarTodos(chefs);
            JOptionPane.showMessageDialog(null, "Chef eliminado con éxito.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

