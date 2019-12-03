/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuarios {
    
    private int id_usuario;
    private String apodo;
    private String clave;
    
    public Usuarios() {
    }
    
    public static boolean conectar(String usuario, String clave) {
        boolean valido = false;
        Conexion sql = new Conexion();
        // Creamos el String para la consulta a la base de datos
        String query = "SELECT * FROM usuario ";
        query += "WHERE apodo = '" + usuario + "' ";
        query += "AND clave = '" + clave + "';";
        
        try {
            Statement s = sql.conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            
            int filas = 0;
            while(rs.next()){
                filas++;
                // filas = filas + 1;
            }
            if (filas == 1) {
                valido = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valido;
    }
}
