package vista;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import controlador.ControladorRequerimientos;
import modelo.dao.Requerimiento_1Dao;
import modelo.dao.Requerimiento_2Dao;
import modelo.dao.Requerimiento_3Dao;

public class VistaRequerimientos extends JFrame implements ActionListener{

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    private JTable tabla;
    private DefaultTableModel modelo;
    private JButton req1,req2,req3;
    private JPanel container;
    private JScrollPane scrollPane;


    private Object[][] datos;


    public VistaRequerimientos() {
    }

    public void VistaRequerimientos1(){
        try {
            datos = new Requerimiento_1Dao().requerimiento1();
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }
    public void VistaRequerimientos2(){
        try {
            datos = new Requerimiento_2Dao().requerimiento2();
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }
    public void VistaRequerimientos3(){
        try {
            datos = new Requerimiento_3Dao().requerimiento3();
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void createView() {


        Container c = getContentPane();

        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        container = new JPanel();

        tabla = new JTable();

        scrollPane = new JScrollPane(tabla);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        req1 = new JButton("Requerimiento 1");
        req1.addActionListener(this);
        req2 = new JButton("Requerimiento 2");
        req2.addActionListener(this);
        req3 = new JButton("Requerimiento 3");
        req3.addActionListener(this);

        container.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));

        container.add(req1);
        container.add(req2);
        container.add(req3);

        add(container);
        add(scrollPane);

        setSize(600, 600);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == req1){
            VistaRequerimientos1();

            modelo = new DefaultTableModel();

            modelo.addColumn("Ciudades");
            modelo.addColumn("Promedio");
            for (int i = 0; i < datos.length; i++) {
                for (int j = 0; j < datos[0].length; j++) {
                    modelo.addRow(new Object[] { datos[i][j], datos[i][++j] });
                }
            }
            tabla.setModel(modelo);
            validate();
        }
        if (e.getSource() == req2){
            VistaRequerimientos2();

            modelo = new DefaultTableModel();

            modelo.addColumn("Id Vendedor");
            modelo.addColumn("Proveedor");
            for (int i = 0; i < datos.length; i++) {
                for (int j = 0; j < datos[0].length; j++) {
                    modelo.addRow(new Object[] { datos[i][j], datos[i][++j] });
                }
            }
            tabla.setModel(modelo);
            validate();
        }
        if (e.getSource() == req3){
            VistaRequerimientos3();

            modelo = new DefaultTableModel();
            modelo.addColumn("Id Vendedor");
            modelo.addColumn("Nombre del Material");
            for (int i = 0; i < datos.length; i++) {
                for (int j = 0; j < datos[0].length; j++) {
                    modelo.addRow(new Object[] { datos[i][j], datos[i][++j] });
                }
            }
            tabla.setModel(modelo);
            validate();
        }

    }

}
