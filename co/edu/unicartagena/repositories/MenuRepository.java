package co.edu.unicartagena.repositories;

import co.edu.unicartagena.entities.Menu;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author kevin
 */
public class MenuRepository {

    private static final String FILE_PATH = "menus.txt";

    private void guardarTodos(List<Menu> menus) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Menu menu : menus) {
                writer.write(menu.getNombre() + "|" + menu.getPrecio() + "|" + String.join(",", menu.getPlatos()));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crear(Menu menu) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(menu.getNombre() + "|" + menu.getPrecio() + "|" + String.join(",", menu.getPlatos()));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Menu> listar() {
        List<Menu> menus = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 2) {
                    Menu menu = new Menu(parts[0], Double.parseDouble(parts[1]));
                    if (parts.length == 3) {
                        String[] platos = parts[2].split(",");
                        for (String plato : platos) {
                            menu.agregarPlato(plato);
                        }
                    }
                    menus.add(menu);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return menus;
    }

    public void actualizar(String nombre, Menu menuActualizado) {
        List<Menu> menus = listar();
        boolean encontrado = false;

        for (int i = 0; i < menus.size(); i++) {
            Menu menu = menus.get(i);
            if (menu.getNombre().equals(nombre)) {
                menus.set(i, menuActualizado);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Menú no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            guardarTodos(menus);
            JOptionPane.showMessageDialog(null, "Menú actualizado con éxito.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void eliminar(String nombre) {
        List<Menu> menus = listar();
        boolean encontrado = false;

        for (int i = 0; i < menus.size(); i++) {
            Menu menu = menus.get(i);
            if (menu.getNombre().equals(nombre.trim())) {
                menus.remove(i);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Menú no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            guardarTodos(menus);
            JOptionPane.showMessageDialog(null, "Menú eliminado con éxito.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

