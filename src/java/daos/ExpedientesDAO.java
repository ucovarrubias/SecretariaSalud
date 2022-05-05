/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import dominio.Expediente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        InputStream is = null;
        try{
            Connection conexion = this.generarConexion();
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT * FROM expediente WHERE id_paciente = '%d'",
                    idPaciente
            );
            ResultSet resultado = comando.executeQuery(codigoSQL);
            while(resultado.next()){ 
                Integer id = resultado.getInt("id_expediente");
                String nombre = resultado.getString("nombre");
                File file  = new File(nombre);
                try (FileOutputStream fos = new FileOutputStream(file)){
                    byte[] buffer = new byte[1024];
                    is = resultado.getBinaryStream("archivo");
                    while(is.read(buffer) > 0){
                        fos.write(buffer);
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            
//                Blob blob = resultado.getBlob("archivo");
//                byte[] imageBytes=blob.getBytes(1, (int)blob.length());
//                String encodedImage=Base64.getEncoder().encodeToString(imageBytes);
//                String img = "data:image/jpg;base64,"+ encodedImage;
                String tipoDocumento = resultado.getString("TIPO_ARCHIVO");
                String fecha = resultado.getString("fecha");
                String descripcion = resultado.getString("descripcion");

                Expediente expediente = new Expediente(id, nombre, is, tipoDocumento, fecha, descripcion, idPaciente);
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
    public void insertar(Expediente exp) {
        try {
            Connection con = this.generarConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO expediente(nombre, archivo, TIPO_ARCHIVO, fecha, descripcion, id_paciente) VALUES (?, ?, ?, CURRENT_TIMESTAMP, ?, ?)");
            ps.setString(1, exp.getNombre());
            if(exp.getArchivo() != null){
                ps.setBlob(2, exp.getArchivo());    
            }
            ps.setString(3, exp.getTipoDocumento());
            ps.setString(4, exp.getDescripcion());
            ps.setInt(5, exp.getPacienteId());
            ps.execute();
            con.close();
            System.out.println("Se agregó al expediente exitósamente");
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
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
