
package Modelo;

public class Invitado {
    
    private int idI;
    private String nombreI;
    private int idP;
    private int idTR;

    public int getIdI() {
        return idI;
    }

    public void setIdI(int idI) {
        this.idI = idI;
    }

    public String getNombreI() {
        return nombreI;
    }

    public void setNombreI(String nombreI) {
        this.nombreI = nombreI;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public int getIdTR() {
        return idTR;
    }

    public void setIdTR(int idTR) {
        this.idTR = idTR;
    }

    public Invitado() {
    }

    public Invitado(int idI, String nombreI, int idP, int idTR) {
        this.idI = idI;
        this.nombreI = nombreI;
        this.idP = idP;
        this.idTR = idTR;
    }
    
}
