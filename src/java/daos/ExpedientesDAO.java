/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import dominio.Expediente;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

/**
 *
 * @author ucova
 */
public class ExpedientesDAO extends BaseDAO<Expediente> {

    @Override
    public Expediente autenticar(String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Expediente> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Expediente> consultarPorId(Integer idPaciente) {
        ArrayList<Expediente> listaExpedientes = new ArrayList<>();
        try{
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT imagen FROM expediente WHERE id_paciente = '%d'",
                    idPaciente
            );
            ResultSet resultado = comando.executeQuery(codigoSQL);
            while(resultado.next()){
                Blob blob = resultado.getBlob("imagen");
                byte[] imageBytes=blob.getBytes(1, (int)blob.length());
                String encodedImage=Base64.getEncoder().encodeToString(imageBytes);
                String img = "data:image/jpg;base64,"+ encodedImage;

                Expediente expediente = new Expediente(img, idPaciente);
                listaExpedientes.add(expediente);
            }
            conexion.close();
            System.out.println("Se consultaron los expedientes");
            return listaExpedientes;
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
            return listaExpedientes;
        }
    }

    @Override
    public Expediente consultar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertar(Expediente entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(Expediente entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
