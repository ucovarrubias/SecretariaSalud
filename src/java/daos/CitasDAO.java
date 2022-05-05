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

/**
 *
 * @author ucova
 */
public class CitasDAO extends BaseDAO<Cita>{

    @Override
    public Cita autenticar(String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cita> consultar() {
       throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public Cita consultar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertar(Cita entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(Cita entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cita> consultarPorId(Integer idTrabajador) {
        ArrayList<Cita> listaCitas = new ArrayList<>();
        try{
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT citas.id_cita, citas.hora_cita, citas.acceso_expediente, citas.id_paciente, paciente.nombre FROM citas "
                    + "LEFT JOIN paciente "
                    + "ON citas.id_paciente = paciente.id_paciente "
                    + "WHERE id_trabajador_salud = '%d'",
                    idTrabajador
            );
            ResultSet resultado = comando.executeQuery(codigoSQL);
            while(resultado.next()){
                Integer id = resultado.getInt("id_cita");
                String horaCita = resultado.getString("hora_cita");
                Boolean accesoExpediente = resultado.getBoolean("acceso_expediente");
                Integer pacienteId = resultado.getInt("id_paciente");
                String nombrePaciente = resultado.getString("nombre");

                Cita cita = new Cita(id, horaCita, accesoExpediente, pacienteId, nombrePaciente, idTrabajador);
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
    
    
}
