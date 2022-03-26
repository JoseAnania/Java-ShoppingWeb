
package Modelo;

public class Regalo {
    
    private int idR;
    private int idP;
    private int idA;
    private int idI;
    private int cantidad;
    private int regalado;

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public int getIdI() {
        return idI;
    }

    public void setIdI(int idI) {
        this.idI = idI;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getRegalado() {
        return regalado;
    }

    public void setRegalado(int regalado) {
        this.regalado = regalado;
    }

    public Regalo(int idR, int idP, int idA, int idI, int cantidad, int regalado) {
        this.idR = idR;
        this.idP = idP;
        this.idA = idA;
        this.idI = idI;
        this.cantidad = cantidad;
        this.regalado = regalado;
    }

    public Regalo() {
    }
    

    
}
