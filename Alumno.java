package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "alumno") // Este nombre debe coincidir con el XML
public class Alumno {
    private static String path = "src/main/resources/Alumnos.xml";

    private String nombre;
    private String apellido;
    private String curso;
    private String DNI;
    private int ID;

    public Alumno() {

    }

    public Alumno(String nombre, String apellido, String curso, String DNI, int ID) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.DNI = DNI;
        this.ID=ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @XmlElement
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @XmlElement
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

//    public static void leerDocumentoXML() throws JAXBException {
//        JAXBContext ctx = crearJAXBContext();
//        Unmarshaller um = ctx.createUnmarshaller();
//        File fileToRead = new File(path);
//
//        Alumnos allAlumnos = (Alumnos) um.unmarshal(fileToRead);
//        List<String> nombresAlumnos = new ArrayList<>();
//        for (Alumno alumno : allAlumnos.getRecuento()) {
//            System.out.println(alumno.getNombre());
//            nombresAlumnos.add(alumno.getNombre());
//        }
//    }

    public static List<Alumno> leerDocumentoXML() throws JAXBException {
        // Crear el contexto JAXB para la clase Alumnos
        JAXBContext ctx = crearJAXBContext();
        // Crear el unmarshaller a partir del contexto JAXB
        Unmarshaller um = crearUnmarshaller(ctx);
        // Leer el archivo XML
        File fileToRead = new File(path);
        // Deserializar el XML a un objeto Alumnos
        Alumnos allAlumnos = (Alumnos) um.unmarshal(fileToRead);
        // Almacen de alumnos que servirá para enviar datos a la BBDD
        List<Alumno> todosAlumnos = new ArrayList<>();
        for (Alumno alumno : allAlumnos.getRecuento()) {
            todosAlumnos.add(alumno);
        }
        return todosAlumnos;
    }

    private void String(){

    }


    // Métodos para que quede más bonito el codigo
    private static JAXBContext crearJAXBContext() throws JAXBException {
        return JAXBContext.newInstance(Alumnos.class);
    }

    private static Unmarshaller crearUnmarshaller(JAXBContext ctx) throws JAXBException {
        return ctx.createUnmarshaller();
    }
}



