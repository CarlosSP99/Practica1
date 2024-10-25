package org.example;

import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BrandDAO {
    private Connection connection;

    // Cada vez que instancio un objeto BrandDAO se conecta a la BBDD
    public BrandDAO() throws SQLException {
        this.connection = DBConnection.getConnection();
    }

    // Metodo que introduce datos a través de un array de objetos Alumnos
    public void insertarNombres(List<Alumno> alumnos) throws SQLException {
        String insertQuery = "INSERT INTO alumno (nombre, apellido, curso, dni) VALUES (?, ?, ?, ?) RETURNING id;";
        PreparedStatement statement = connection.prepareStatement(insertQuery);

        for (Alumno alumno : alumnos) {
            statement.setString(1, alumno.getNombre());
            statement.setString(2, alumno.getApellido());
            statement.setString(3, alumno.getCurso());
            statement.setString(4, alumno.getDNI());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    System.out.println("Alumno " + id + " (" + alumno.getNombre() + " " + alumno.getApellido() +
                            ") está matriculado en el grado de " + alumno.getCurso() + " con DNI " + alumno.getDNI());
                }
            } catch (PSQLException e) {
                System.out.println("El alumno con DNI "+alumno.getDNI() +  " que ya se encuentra en la base de datos ");
            }
        }
    }
}
// El catch por si insertamos de nuevo un alumno que ya está en la base de datos



