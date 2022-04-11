/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ucova
 * @param <T>
 */
public abstract class BaseDAO<T> {

    private static final String CADENA_CONEXION = "jdbc:mysql://localhost:3306/secretaria_salud?autoReconnet=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
<<<<<<< HEAD
    //private static final String CONTRASENIA = "admin";
    private static final String CONTRASENIA = "password";
    private static final String CLASSNAME="com.mysql.cj.jdbc.Driver";
    
    protected Connection generarConexion() throws SQLException{
=======
    private static final String CONTRASENIA = "admin";
    private static final String CLASSNAME = "com.mysql.cj.jdbc.Driver";

    protected Connection generarConexion() throws SQLException {
>>>>>>> 1143540a6f1c6b833ce1831efe8cf76b8f61bbac
        try {
            Class.forName(CLASSNAME);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASENIA);
    }

    public abstract ArrayList<T> consultar();

    public abstract ArrayList<T> consultarPorId(Integer id);

    public abstract T consultar(Integer id);

    public abstract boolean insertar(T entidad);

    public abstract boolean actualizar(T entidad);

    public abstract boolean eliminar(Integer id);
}
