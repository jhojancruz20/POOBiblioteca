package Controlador;

import Modelo.Biblioteca;
import Modelo.Libro;
import Vista.BibliotecaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BibliotecaController {
    private Biblioteca model;
    private BibliotecaView view;

    public BibliotecaController(Biblioteca model, BibliotecaView view) {
        this.model = model;
        this.view = view;

        view.addAgregarListener(new AgregarListener());
        view.addEliminarListener(new EliminarListener());
        view.addActualizarListener(new ActualizarListener());
        view.addBuscarListener(new BuscarListener());
    }

    private void actualizarTabla() {
        Object[][] data = model.obtenerLibros().stream()
                .map(libro -> new Object[]{
                    libro.getId(), libro.getTitulo(), libro.getAutor(),
                    libro.getGenero(), libro.getAnioPublicacion()
                })
                .toArray(Object[][]::new);
        String[] columnNames = {"ID", "Título", "Autor", "Género", "Año"};
        view.setTableData(data, columnNames);
    }

    class AgregarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(view.getTxtId());
            String titulo = view.getTxtTitulo();
            String autor = view.getTxtAutor();
            String genero = view.getTxtGenero();
            int anio = Integer.parseInt(view.getTxtAnio());
            model.agregarLibro(new Libro(id, titulo, autor, genero, anio));
            actualizarTabla();
        }
    }

    class EliminarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(view.getTxtId());
            model.eliminarLibro(id);
            actualizarTabla();
        }
    }

    class ActualizarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(view.getTxtId());
            String titulo = view.getTxtTitulo();
            String autor = view.getTxtAutor();
            String genero = view.getTxtGenero();
            int anio = Integer.parseInt(view.getTxtAnio());
            model.actualizarLibro(id, titulo, autor, genero, anio);
            actualizarTabla();
        }
    }

    class BuscarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(view.getTxtId());
            Libro libro = model.buscarLibroPorId(id);
            if (libro != null) {
                view.setTableData(new Object[][]{
                    {libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.getAnioPublicacion()}
                }, new String[]{"ID", "Título", "Autor", "Género", "Año"});
            }
        }
    }
}
