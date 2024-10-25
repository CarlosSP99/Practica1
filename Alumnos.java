package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "alumnos") // Nombre del XML
public class Alumnos {
    private static String path = "C:\\Users\\csper\\Desktop\\DAM\\Practica1_ACCESO_DATOS\\src\\main\\java\\org\\example\\Alumnos.xml";
    private List<Alumno> recuento;

    @XmlElement(name = "alumno")
    public List<Alumno> getRecuento() {
        return recuento;
    }

    public void setRecuento(List<Alumno> recuento) {
        this.recuento = recuento;
    }

}
