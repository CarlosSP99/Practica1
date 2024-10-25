package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    // Credenciales
    private static final String url="jdbc:postgresql://localhost:5433/postgres";
    private static final String user= "postgres";
    private static final String pass= "12345";

    // Método para conectarte + creacion de base de datos
    public static Connection getConnection() throws SQLException {
        Connection connection= DriverManager.getConnection(url, user, pass);
        String sql="CREATE TABLE IF NOT EXISTS alumno (\n" +
                "    id SERIAL,\n"+
                "    nombre VARCHAR(50) NOT NULL,\n" +
                "    apellido VARCHAR(50) NOT NULL,\n" +
                "    curso VARCHAR(50) NOT NULL,\n" +
                "    dni VARCHAR(10) NOT NULL UNIQUE\n" +
                ");";
        Statement statement= connection.createStatement();
        statement.executeUpdate(sql);
        System.out.println("tabla creada");
        return connection;
    }



}
