/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import dominio.Cita;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ucova
 */
public class CitasDAO extends BaseDAO<Cita> {

    @Override
    public ArrayList<Cita> consultar() {
        ArrayList<Cita> listaCitas = new ArrayList<>();
        try{
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT id_cita, hora_cita, acceso_expediente, id_paciente, id_trabajador_salud FROM citas");
            ResultSet resultado = comando.executeQuery(codigoSQL);
            while(resultado.next()){
                Integer id = resultado.getInt("id_cita");
                String horaCita = resultado.getString("hora_cita");
                Boolean accesoExpediente = resultado.getBoolean("acceso_expediente");
                Integer idPaciente = resultado.getInt("id_paciente");
                Integer idTrabajador = resultado.getInt("id_trabajador_salud");

                Cita cita = new Cita(id, horaCita, accesoExpediente, idPaciente, idTrabajador);
                System.out.println(cita);
                listaCitas.add(cita);
            }
            conexion.close();
            System.out.println("Se consultaron las citas");
            return listaCitas;
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
            return listaCitas;
        }
    }

    @Override
    public Cita consultar(Integer id) {
        Cita cita = null;
        try{
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT id_trabajador_salud, hora_cita, acceso_expediente, id_paciente FROM citas WHERE id_cita = '%d'",
                    id
            );
            ResultSet resultado = comando.executeQuery(codigoSQL);

            String horaCita = resultado.getString("hora_cita");
            Boolean accesoExpediente = resultado.getBoolean("acceso_expediente");
            Integer idPaciente = resultado.getInt("id_paciente");
            Integer idTrabajador = resultado.getInt("id_trabajador_salud");
            cita = new Cita(id, horaCita, accesoExpediente, idPaciente, idTrabajador);

            conexion.close();
            System.out.println("Se consultaron las citas");
            return cita;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
        return cita;
    }

    @Override
<<<<<<< HEAD
    public void insertar(Cita entidad) {
        Connection conexion;
        try {
            conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("INSERT INTO citas\n" +
                    "(id_cita,\n" +
                    "hora_cita,\n" +
                    "acceso_expediente,\n" +
                    "id_paciente,\n" +
                    "id_trabajador_salud)\n" +
                    "VALUES (%d, %s, %s, %d, %d)",
                    entidad.getId(),
                    entidad.getHoraCita(),
                    entidad.getAccesoExpediente(),
                    entidad.getPacienteId(),
                    entidad.getTrabajadorSaludId());
            
            ResultSet resultado = comando.executeQuery(codigoSQL);       
            conexion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CitasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    @Override
    public void actualizar(Cita entidad) {
        Connection conexion;
        try {
            conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("UPDATE citas SET" +
                    "id_cita = %d,"+
                    "hora_cita = %s,"+
                    "acceso_expediente = %s,"+
                    " id_paciente = %d, "+
                    "id_trabajador_salud = %d"+
                    "WHERE id_cita = %",
                    entidad.getId(),
                    entidad.getHoraCita(),
                    entidad.getAccesoExpediente(),
                    entidad.getPacienteId(),
                    entidad.getTrabajadorSaludId(),
                    entidad.getId());
            
            ResultSet resultado = comando.executeQuery(codigoSQL);       
            conexion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CitasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
=======
    public boolean insertar(Cita entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Cita entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
>>>>>>> 1143540a6f1c6b833ce1831efe8cf76b8f61bbac
    }
    
    @Override
<<<<<<< HEAD
    public void eliminar(Integer id) {
        ArrayList<Cita> listaCitas = new ArrayList<>();
        try{
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("DELETE FROM citas WHERE id_cita = '%d'",id);
            ResultSet resultado = comando.executeQuery(codigoSQL);            
            conexion.close();            
            
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
            ;
        }
=======
    public boolean eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
>>>>>>> 1143540a6f1c6b833ce1831efe8cf76b8f61bbac
    }

    @Override
    public ArrayList<Cita> consultarPorId(Integer idTrabajador) {
        ArrayList<Cita> listaCitas = null;

        try ( Connection conexion = this.generarConexion()) {
            listaCitas = new ArrayList<>();

            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT id_cita, hora_cita, acceso_expediente, id_paciente FROM citas WHERE id_trabajador_salud = '%d'",
                    idTrabajador
            );

            ResultSet resultado = comando.executeQuery(codigoSQL);

            while (resultado.next()) {
                Integer id = resultado.getInt("id_cita");
                String horaCita = resultado.getString("hora_cita");
                Boolean accesoExpediente = resultado.getBoolean("acceso_expediente");
                Integer idPaciente = resultado.getInt("id_paciente");

                Cita cita = new Cita(id, horaCita, accesoExpediente, idPaciente, idTrabajador);
                System.out.println(cita);
                listaCitas.add(cita);
            }

            conexion.close();
            System.out.println("Se consultaron las citas");

            return listaCitas;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return listaCitas;
        }
    }

}
