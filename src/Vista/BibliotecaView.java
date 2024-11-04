package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BibliotecaView extends JFrame {
    private JTable tableLibros;
    private JTextField txtId, txtTitulo, txtAutor, txtGenero, txtAnio;
    private JButton btnAgregar, btnEliminar, btnActualizar, btnBuscar;

    public BibliotecaView() {
        setTitle("Gestión de Biblioteca");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de la tabla
        tableLibros = new JTable();
        add(new JScrollPane(tableLibros), BorderLayout.CENTER);

        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(6, 2));
        panelFormulario.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelFormulario.add(txtId);

        panelFormulario.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        panelFormulario.add(txtTitulo);

        panelFormulario.add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        panelFormulario.add(txtAutor);

        panelFormulario.add(new JLabel("Género:"));
        txtGenero = new JTextField();
        panelFormulario.add(txtGenero);

        panelFormulario.add(new JLabel("Año Publicación:"));
        txtAnio = new JTextField();
        panelFormulario.add(txtAnio);

        // Botones
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        btnActualizar = new JButton("Actualizar");
        btnBuscar = new JButton("Buscar");

        panelFormulario.add(btnAgregar);
        panelFormulario.add(btnEliminar);
        panelFormulario.add(btnActualizar);
        panelFormulario.add(btnBuscar);

        add(panelFormulario, BorderLayout.SOUTH);
    }

    // Getters para los campos de texto y botones
    public String getTxtId() { return txtId.getText(); }
    public String getTxtTitulo() { return txtTitulo.getText(); }
    public String getTxtAutor() { return txtAutor.getText(); }
    public String getTxtGenero() { return txtGenero.getText(); }
    public String getTxtAnio() { return txtAnio.getText(); }

    public void setTableData(Object[][] data, String[] columnNames) {
        tableLibros.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    public void addAgregarListener(ActionListener listener) { btnAgregar.addActionListener(listener); }
    public void addEliminarListener(ActionListener listener) { btnEliminar.addActionListener(listener); }
    public void addActualizarListener(ActionListener listener) { btnActualizar.addActionListener(listener); }
    public void addBuscarListener(ActionListener listener) { btnBuscar.addActionListener(listener); }
}
