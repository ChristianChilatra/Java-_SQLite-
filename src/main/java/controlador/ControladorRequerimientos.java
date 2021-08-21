package controlador;

import java.sql.SQLException;

import modelo.dao.Requerimiento_1Dao;
import modelo.dao.Requerimiento_2Dao;
import modelo.dao.Requerimiento_3Dao;

public class ControladorRequerimientos {
    // Su código
    private Object [][] datos;




    public Object[][] consultarRequerimiento1() throws SQLException {
        try {
            Requerimiento_1Dao consulta = new Requerimiento_1Dao();
            datos = consulta.requerimiento1();

        } catch (Exception e) {
            System.out.println("Error al recibir datos DAO" + e.getMessage());
        }
        return datos;
    }

    public Object[][] consultarRequerimiento2() throws SQLException {
        try {
            Requerimiento_2Dao consulta = new Requerimiento_2Dao();
            datos = consulta.requerimiento2();

        } catch (Exception e) {
            System.out.println("Error al recibir datos DAO" + e.getMessage());
        }
        return datos;
    }

    public Object[][] consultarRequerimiento3() throws SQLException {
        try {
            Requerimiento_3Dao consulta = new Requerimiento_3Dao();
            datos = consulta.requerimiento3();

        } catch (Exception e) {
            System.out.println("Error al recibir datos DAO" + e.getMessage());
        }
        return datos;
    }

}
