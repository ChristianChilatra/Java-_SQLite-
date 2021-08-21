package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_3Vo;
import util.JDBCUtilities;

public class Requerimiento_3Dao {

    private final String QUERY = "SELECT p.ID_Proyecto, mc.Nombre_Material FROM Proyecto p JOIN Compra c ON (p.ID_Proyecto=c.ID_Proyecto)    JOIN MaterialConstruccion   mc ON (c.ID_MaterialConstruccion=mc.ID_MaterialConstruccion) WHERE p.ID_Proyecto BETWEEN 5 AND 15 ORDER BY p.ID_Proyecto ASC;";
    private Connection conn;
    private ArrayList<Requerimiento_3Vo> listRequerimiento_3 = new ArrayList<Requerimiento_3Vo>();

    public ArrayList<Requerimiento_3Vo> requerimiento3() throws SQLException {
        try {
            conn = JDBCUtilities.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                Integer idProyecto = rs.getInt("ID_Proyecto");
                String proveedro = rs.getString("Nombre_Material");
                Requerimiento_3Vo req_3 = new Requerimiento_3Vo(proveedro, idProyecto);
                listRequerimiento_3.add(req_3);
            }

        } catch (Exception e) {
            System.out.println("No se puedo traer informacion" + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Error en cierre de conexion" + e.getMessage());
            }

        }
        return listRequerimiento_3;
    }
}