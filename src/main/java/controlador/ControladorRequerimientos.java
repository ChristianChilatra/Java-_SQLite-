package controlador;

import java.sql.SQLException;


import modelo.dao.Requerimiento_1Dao;

public class ControladorRequerimientos {
    // Su código
    private Object [][] listRequerimiento_1;



    public Object[][] consultarRequerimiento1() throws SQLException {
        try {
            Requerimiento_1Dao consulta = new Requerimiento_1Dao();
            listRequerimiento_1 = consulta.requerimiento1();

        } catch (Exception e) {
            System.out.println("Error al recibir datos DAO" + e.getMessage());
        }
        return listRequerimiento_1;
    }

}
