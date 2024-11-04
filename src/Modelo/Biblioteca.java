package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> obtenerLibros() {
        return libros;
    }

    public Libro buscarLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public void eliminarLibro(int id) {
        libros.removeIf(libro -> libro.getId() == id);
    }

    public void actualizarLibro(int id, String titulo, String autor, String genero, int anioPublicacion) {
        Libro libro = buscarLibroPorId(id);
        if (libro != null) {
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setGenero(genero);
            libro.setAnioPublicacion(anioPublicacion);
        }
    }
}

