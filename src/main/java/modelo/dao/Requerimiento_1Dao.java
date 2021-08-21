package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


import modelo.vo.Requerimiento_1Vo;
import util.JDBCUtilities;

public class Requerimiento_1Dao {

    private final String QUERY = "SELECT Ciudad_Residencia, AVG(Salario) AS Promedio  FROM Lider GROUP BY Ciudad_Residencia HAVING AVG(Salario) < 600000 ORDER BY Promedio DESC;";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private Object [][]datos;
    private List<String> ciudades;
    private List<Float> promedios;
    private int sizeRs = 0;
    private int sizeColum;



    public Object[][] requerimiento1() throws SQLException {
        try{
            conn = JDBCUtilities.getConnection();
            pstmt = conn.prepareStatement(QUERY);
            rs = pstmt.executeQuery();
            Requerimiento_1Vo objectVo = new Requerimiento_1Vo();

            sizeColum = objectVo.getNumColum();

            int iterador = 0;


            ciudades = new ArrayList<String>();
            promedios = new ArrayList<Float>();

            while (rs.next()) {

                ciudades.add(rs.getString("Ciudad_Residencia"));
                promedios.add(rs.getFloat("Promedio"));
                sizeRs++;
                iterador++;
            }

            datos = new Object [(sizeRs)][sizeColum];



            for (int i = 0; i < datos.length; i++) {
                for (int j = 0; j < datos[0].length; j++) {
                    datos [i][j] = ciudades.get(i);
                    j++;
                    datos [i][j] = promedios.get(i);
                }
            }

        } catch (Exception e) {
            System.out.println("No se puedo traer informacion " + e.getMessage());
        } finally{
            try {
                if (rs != null){rs.close();}
            } catch (Exception e) {
                System.out.println("Error en cierre de conexion " + e.getMessage());
            }
            ;
            try {
                if (pstmt != null){pstmt.close();}
            } catch (Exception e) {
                System.out.println("Error en cierre de conexion " + e.getMessage());
            }
            ;
            try {
                if (conn != null){conn.close();}
            } catch (Exception e) {
                System.out.println("Error en cierre de conexion " + e.getMessage());
            }
        }
        return datos;
    }
}