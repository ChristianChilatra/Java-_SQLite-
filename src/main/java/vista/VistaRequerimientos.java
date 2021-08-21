package vista;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;

import controlador.ControladorRequerimientos;


public class VistaRequerimientos extends JFrame implements ActionListener {

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    private JTable tabla;
    private DefaultTableModel modelo;

    private Object datos[][];
    private String[] nameColum = { "Ciudad", "Promedio" };

    public VistaRequerimientos() {
        try {
            datos = controlador.consultarRequerimiento1();

        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void createView() {

        modelo = new DefaultTableModel();
        modelo.addColumn(nameColum);
        tabla = new JTable(datos, nameColum);
        tabla.setModel(modelo);

        setLayout(new BorderLayout());

        setLayout(new BorderLayout());
        JScrollPane panel = new JScrollPane(tabla);
        add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(tabla, BorderLayout.CENTER);
        setSize(400, 150);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }


}
