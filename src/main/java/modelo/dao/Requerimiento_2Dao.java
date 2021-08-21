package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_2Vo;
import util.JDBCUtilities;

public class Requerimiento_2Dao {

    private final String QUERY = "SELECT p.ID_Proyecto, c.Proveedor FROM Proyecto p JOIN Compra c ON(p.ID_Proyecto=c.ID_Proyecto) WHERE p.Ciudad ='Quibdo' ORDER BY p.ID_Proyecto";
    private Connection conn;
    private ArrayList<Requerimiento_2Vo> listRequerimiento_2 = new ArrayList<Requerimiento_2Vo>();

    public ArrayList<Requerimiento_2Vo> requerimiento2() throws SQLException {
        try {
            conn = JDBCUtilities.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                Integer idProyecto = rs.getInt("ID_Proyecto");
                String proveedro = rs.getString("Proveedor");
                Requerimiento_2Vo req_2 = new Requerimiento_2Vo(proveedro, idProyecto);
                listRequerimiento_2.add(req_2);
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
        return listRequerimiento_2;
    }
}