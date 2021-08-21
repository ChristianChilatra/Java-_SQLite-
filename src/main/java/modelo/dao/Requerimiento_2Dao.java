package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.vo.Requerimiento_2Vo;
import util.JDBCUtilities;

public class Requerimiento_2Dao {

    private final String QUERY = "SELECT p.ID_Proyecto, c.Proveedor FROM Proyecto p JOIN Compra c ON(p.ID_Proyecto=c.ID_Proyecto) WHERE p.Ciudad ='Quibdo' ORDER BY p.ID_Proyecto";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private Object[][] datos;
    private List<Integer> idProyecto;
    private List<String> proveedor;
    private int sizeRs = 0;
    private int sizeColum;

    public Object[][] requerimiento2() throws SQLException {
        try {
            conn = JDBCUtilities.getConnection();
            pstmt = conn.prepareStatement(QUERY);
            rs = pstmt.executeQuery();
            Requerimiento_2Vo objectVo = new Requerimiento_2Vo();

            sizeColum = objectVo.getNumColum();

            idProyecto = new ArrayList<Integer>();
            proveedor = new ArrayList<String>();

            int iterador = 0;

            while (rs.next()) {

                idProyecto.add(rs.getInt("ID_Proyecto"));
                proveedor.add(rs.getString("Proveedor"));
                sizeRs++;
                iterador++;
            }

            datos = new Object[(sizeRs)][sizeColum];

            for (int i = 0; i < datos.length; i++) {
                for (int j = 0; j < datos[0].length; j++) {
                    datos[i][j] = idProyecto.get(i);
                    j++;
                    datos[i][j] = proveedor.get(i);
                }
            }

        } catch (Exception e) {
            System.out.println("No se puedo traer informacion " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.out.println("Error en cierre de conexion " + e.getMessage());
            }
            ;
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                System.out.println("Error en cierre de conexion " + e.getMessage());
            }
            ;
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Error en cierre de conexion " + e.getMessage());
            }
        }
        return datos;
    }
}