package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, JAXBException {
        // Creacion de la BBDD

        DBConnection.getConnection();
        // Se guarda el resultado de
        List<Alumno> listaAlumnos=Alumno.leerDocumentoXML();

        //Creamos el objeto BrandDAO para ejecutar consultas
        BrandDAO instruccionesCRUD=new BrandDAO();

        //Enviamos los datos del xml a la base de datos
        instruccionesCRUD.insertarNombres(listaAlumnos);
    }

}