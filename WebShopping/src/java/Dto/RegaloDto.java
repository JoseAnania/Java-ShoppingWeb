
package Dto;

public class RegaloDto {
    
    private int idR;
    private String denominacionA;
    private int idA;
    private int idP;
    private int regalado;

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getDenominacionA() {
        return denominacionA;
    }

    public void setDenominacionA(String denominacionA) {
        this.denominacionA = denominacionA;
    }

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public int getRegalado() {
        return regalado;
    }

    public void setRegalado(int regalado) {
        this.regalado = regalado;
    }

    public RegaloDto(int idR, String denominacionA, int idA, int idP, int regalado) {
        this.idR = idR;
        this.denominacionA = denominacionA;
        this.idA = idA;
        this.idP = idP;
        this.regalado = regalado;
    }

    public RegaloDto() {
    }
    
    
}
