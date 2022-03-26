package Modelo;

import java.sql.Date;

public class Pareja {
    
    private int idP;
    private String nombre1;
    private String apellido1;
    private String nombre2;
    private String apellido2;
    private String fechaCasamiento;//en BD date
    private int idC;

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getFechaCasamiento() {
        return fechaCasamiento;
    }

    public void setFechaCasamiento(String fechaCasamiento) {
        this.fechaCasamiento = fechaCasamiento;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public Pareja() {
    }

    public Pareja(int idP, String nombre1, String apellido1, String nombre2, String apellido2, String fechaCasamiento, int idC) {
        this.idP = idP;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
        this.nombre2 = nombre2;
        this.apellido2 = apellido2;
        this.fechaCasamiento = fechaCasamiento;
        this.idC = idC;
    }
    
}

   

