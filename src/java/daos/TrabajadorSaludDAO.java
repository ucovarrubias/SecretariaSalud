/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import dominio.TrabajadorSalud;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ucova
 */
public class TrabajadorSaludDAO extends BaseDAO<TrabajadorSalud> {

    @Override
    public TrabajadorSalud autenticar(String cedulaProfesional, String contrasenia){
        TrabajadorSalud trabajadorSalud = null;
        try {
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format(
                "SELECT id_trabajador_salud, nombre, curp, fecha_nacimiento, huella_dactilar, cedula_profesional, contrasenia FROM trabajador_salud WHERE cedula_profesional = '%s' AND contrasenia = '%s'",
                    cedulaProfesional, contrasenia
            );
            ResultSet resultado = comando.executeQuery(codigoSQL);
            if(resultado.next()){
                Integer id = resultado.getInt("id_trabajador_salud");
                String nombre = resultado.getString("nombre");
                String curp = resultado.getString("curp");
                Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
                String huellaDactilar = resultado.getString("huella_dactilar");
                //String cedulaProfesional = resultado.getString("cedula_profesional");
                //String contrasenia = resultado.getString("contrasenia");
                trabajadorSalud = new TrabajadorSalud(id, cedulaProfesional, contrasenia, nombre, curp, fechaNacimiento, huellaDactilar);
                System.out.println("Se autenticó el trabajador de la salud " + nombre + " con cédula profesional: " + cedulaProfesional);
            }
            conexion.close();
            return trabajadorSalud;
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
            return trabajadorSalud;
        }
    }
    
    @Override
    public ArrayList<TrabajadorSalud> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TrabajadorSalud consultar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertar(TrabajadorSalud entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(TrabajadorSalud entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TrabajadorSalud> consultarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
