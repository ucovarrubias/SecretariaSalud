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

    public TrabajadorSalud autenticar(String cedulaProfesional, String contrasenia) {
        TrabajadorSalud trabajadorSalud = null;

        try ( Connection conexion = this.generarConexion()) {
            Statement comando = conexion.createStatement();

            String codigoSQL = String.format(
                    "SELECT id_trabajador_salud, nombre, curp, fecha_nacimiento, huella_dactilar, cedula_profesional, contrasenia FROM trabajador_salud WHERE cedula_profesional = '%s' AND contrasenia = '%s'",
                    cedulaProfesional, contrasenia
            );

            ResultSet resultado = comando.executeQuery(codigoSQL);

            if (resultado.next()) {

                Integer id = resultado.getInt("id_trabajador_salud");
                String nombre = resultado.getString("nombre");
                String curp = resultado.getString("curp");
                Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
                String huellaDactilar = resultado.getString("huella_dactilar");

                trabajadorSalud = TrabajadorSalud.builder()
                        .id(id)
                        .cedulaProfesional(cedulaProfesional)
                        .contrasenia(contrasenia)
                        .nombre(nombre)
                        .curp(curp)
                        .fechaNacimiento(fechaNacimiento)
                        .huellaDactilar(huellaDactilar)
                        .build();

                System.out.println("Se autenticó el trabajador de la salud " + trabajadorSalud.getNombre() + " con cédula profesional: " + trabajadorSalud.getCedulaProfesional());
            }

            conexion.close();

            return trabajadorSalud;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return trabajadorSalud;
        }
    }

    @Override
    public ArrayList<TrabajadorSalud> consultar() {
        ArrayList<TrabajadorSalud> listaTrabajadores = new ArrayList<>();
        try ( Connection conexion = this.generarConexion()) {
            Statement comandoSQL = conexion.createStatement();

            String codigoSQL = String.format("SELECT id_trabajador_salud, nombre, curp, fecha_nacimiento, huella_dactilar, cedula_profesional, contrasenia FROM trabajador_salud");

            ResultSet resultado = comandoSQL.executeQuery(codigoSQL);

            while (resultado.next()) {
                Integer id = resultado.getInt("id_trabajador_salud");
                String nombre = resultado.getString("nombre");
                String curp = resultado.getString("curp");
                Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
                String huellaDactilar = resultado.getString("huella_dactilar");
                String cedulaProfesional = resultado.getString("cedula_profesional");
                String contrasenia = resultado.getString("contrasenia");

                TrabajadorSalud trabajadorSalud = TrabajadorSalud.builder()
                        .id(id)
                        .cedulaProfesional(cedulaProfesional)
                        .contrasenia(contrasenia)
                        .nombre(nombre)
                        .curp(curp)
                        .fechaNacimiento(fechaNacimiento)
                        .huellaDactilar(huellaDactilar)
                        .build();

                System.out.println(trabajadorSalud);
                listaTrabajadores.add(trabajadorSalud);
            }

            conexion.close();

            return listaTrabajadores;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return listaTrabajadores;
        }
    }

    @Override
    public TrabajadorSalud consultar(Integer idTrabajador) {
        TrabajadorSalud trabajadorSalud = null;
        try ( Connection conexion = this.generarConexion()) {

            Statement comandoSQL = conexion.createStatement();

            String codigoSQL = String.format("SELECT id_trabajador_salud, nombre, curp, fecha_nacimiento, huella_dactilar, cedula_profesional, contrasenia FROM trabajador_salud WHERE cedula_profesional = '%s'",
                    idTrabajador
            );

            ResultSet resultado = comandoSQL.executeQuery(codigoSQL);

            if (resultado.next()) {
                Integer id = resultado.getInt("id_trabajador_salud");
                String nombre = resultado.getString("nombre");
                String curp = resultado.getString("curp");
                Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
                String huellaDactilar = resultado.getString("huella_dactilar");
                String cedulaProfesional = resultado.getString("cedula_profesional");
                String contrasenia = resultado.getString("contrasenia");

                trabajadorSalud = TrabajadorSalud.builder()
                        .id(id)
                        .cedulaProfesional(cedulaProfesional)
                        .contrasenia(contrasenia)
                        .nombre(nombre)
                        .curp(curp)
                        .fechaNacimiento(fechaNacimiento)
                        .huellaDactilar(huellaDactilar)
                        .build();
            }

            conexion.close();

            return trabajadorSalud;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return trabajadorSalud;
        }
    }

    @Override
    public boolean insertar(TrabajadorSalud entidad) {
        try ( Connection conexion = this.generarConexion()) {
            Statement comandoSql = conexion.createStatement();

            String codigoSQL = String.format("INSERT INTO trabajador_salud (id_trabajador_salud, nombre, curp, fecha_nacimiento, huella_dactilar, cedula_profesional, contrasenia) "
                    + "VALUES ('%d', '%s', '%s', '%s', '%s', '%s' '%s');",
                    entidad.getId(),
                    entidad.getNombre(),
                    entidad.getCurp(),
                    entidad.getFechaNacimiento(),
                    entidad.getHuellaDactilar(),
                    entidad.getCedulaProfesional(),
                    entidad.getContrasenia());

            int numeroRegistrosAfectados = comandoSql.executeUpdate(codigoSQL);

            conexion.close();

            return numeroRegistrosAfectados == 1;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(TrabajadorSalud entidad) {
        try ( Connection conexion = this.generarConexion()) {
            Statement comandoSql = conexion.createStatement();

            String codigoSQL = String.format("UPDATE trabajador_salud SET nombre='%s', curp='%s', fecha_nacimiento='%s', huella_dactilar='%s', cedula_profesional='%s', contrasenia='%s'"
                    + "WHERE cedula_profesional = %s;",
                    entidad.getNombre(),
                    entidad.getCurp(),
                    entidad.getFechaNacimiento(),
                    entidad.getHuellaDactilar(),
                    entidad.getCedulaProfesional(),
                    entidad.getContrasenia(),
                    entidad.getCedulaProfesional());

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

            String codigoSQL = String.format("DELETE FROM trabajador_salud WHERE cedula_profesional = %d;",
                    id);

            int numeroRegistrosAfectados = comandoSql.executeUpdate(codigoSQL);

            conexion.close();

            return numeroRegistrosAfectados == 1;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<TrabajadorSalud> consultarPorId(Integer idTrabajadorSalud) {
        ArrayList<TrabajadorSalud> listaTrabajadores = null;

        try ( Connection conexion = this.generarConexion()) {
            listaTrabajadores = new ArrayList<>();

            Statement comando = conexion.createStatement();
            String codigoSQL = String.format("SELECT id_trabajador_salud, nombre, curp, fecha_nacimiento, huella_dactilar, cedula_profesional, contrasenia FROM trabajador_salud WHERE cedula_profesional = '%s'",
                    idTrabajadorSalud
            );

            ResultSet resultado = comando.executeQuery(codigoSQL);

            while (resultado.next()) {
                Integer id = resultado.getInt("id_trabajador_salud");
                String nombre = resultado.getString("nombre");
                String curp = resultado.getString("curp");
                Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
                String huellaDactilar = resultado.getString("huella_dactilar");
                String cedulaProfesional = resultado.getString("cedula_profesional");
                String contrasenia = resultado.getString("contrasenia");

                TrabajadorSalud trabajadorSalud = TrabajadorSalud.builder()
                        .id(id)
                        .cedulaProfesional(cedulaProfesional)
                        .contrasenia(contrasenia)
                        .nombre(nombre)
                        .curp(curp)
                        .fechaNacimiento(fechaNacimiento)
                        .huellaDactilar(huellaDactilar)
                        .build();

                System.out.println(trabajadorSalud);
                listaTrabajadores.add(trabajadorSalud);
            }

            conexion.close();
            System.out.println("Se consultaron las citas");

            return listaTrabajadores;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return listaTrabajadores;
        }
    }

}
