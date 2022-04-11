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
    public ArrayList<Expediente> consultar() {
        ArrayList<Expediente> listaExpediente = new ArrayList<>();
        try ( Connection conexion = this.generarConexion()) {
            Statement comandoSQL = conexion.createStatement();

            String codigoSQL = String.format("SELECT imagen, id_paciente FROM expediente");

            ResultSet resultado = comandoSQL.executeQuery(codigoSQL);

            while (resultado.next()) {
                Integer idPaciente = resultado.getInt("id_paciente");
                Blob blob = resultado.getBlob("imagen");
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                String img = "data:image/jpg;base64," + encodedImage;

                Expediente trabajadorSalud = new Expediente(img, idPaciente);
                System.out.println(trabajadorSalud);
                listaExpediente.add(trabajadorSalud);
            }

            conexion.close();
            return listaExpediente;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return listaExpediente;
        }
    }

    @Override
    public ArrayList<Expediente> consultarPorId(Integer idPaciente) {
        ArrayList<Expediente> listaExpedientes = new ArrayList<>();
        try ( Connection conexion = this.generarConexion()) {
            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT imagen FROM expediente WHERE id_paciente = '%d'",
                    idPaciente
            );

            ResultSet resultado = comando.executeQuery(codigoSQL);

            while (resultado.next()) {
                Blob blob = resultado.getBlob("imagen");
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                String img = "data:image/jpg;base64," + encodedImage;

                Expediente expediente = new Expediente(img, idPaciente);
                listaExpedientes.add(expediente);
            }

            conexion.close();
            System.out.println("Se consultaron los expedientes");
            return listaExpedientes;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return listaExpedientes;
        }
    }

    @Override
    public Expediente consultar(Integer idPaciente) {
        Expediente expediente = null;
        try ( Connection conexion = this.generarConexion()) {

            Statement comandoSQL = conexion.createStatement();

            String codigoSQL = String.format("SELECT imagen, id_paciente FROM expediente WHERE id_paciente = '%d'",
                    idPaciente
            );

            ResultSet resultado = comandoSQL.executeQuery(codigoSQL);

            if (resultado.next()) {
                Blob blob = resultado.getBlob("imagen");
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                String img = "data:image/jpg;base64," + encodedImage;

                expediente = new Expediente(img, idPaciente);
            }

            conexion.close();
            return expediente;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return expediente;
        }
    }

    @Override
    public boolean insertar(Expediente entidad) {
        try ( Connection conexion = this.generarConexion()) {
            Statement comandoSql = conexion.createStatement();

            String codigoSQL = String.format("INSERT INTO trabajador_salud (imagen, id_paciente) "
                    + "VALUES ('%s', '%d');",
                    entidad.getImagen(),
                    entidad.getPacienteId());

            int numeroRegistrosAfectados = comandoSql.executeUpdate(codigoSQL);

            conexion.close();

            return numeroRegistrosAfectados == 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Expediente entidad) {
        try ( Connection conexion = this.generarConexion()) {
            Statement comandoSql = conexion.createStatement();

            String codigoSQL = String.format("UPDATE expediente SET imagen='%s'"
                    + "WHERE id_paciente = %d;",
                    entidad.getImagen(),
                    entidad.getPacienteId());

            int numeroRegistrosAfectados = comandoSql.executeUpdate(codigoSQL);
            conexion.close();

            return numeroRegistrosAfectados == 1;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Integer id) {
        try ( Connection conexion = this.generarConexion()) {

            Statement comandoSql = conexion.createStatement();

            String codigoSQL = String.format("DELETE FROM expediente WHERE id_paciente = %d;",
                    id);

            int numeroRegistrosAfectados = comandoSql.executeUpdate(codigoSQL);

            conexion.close();

            return numeroRegistrosAfectados == 1;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

}
