
package Modelo;

public class Comercio {
    
    private int idC;
    private String denominacionC;

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getDenominacionC() {
        return denominacionC;
    }

    public void setDenominacionC(String denominacionC) {
        this.denominacionC = denominacionC;
    }

    public Comercio() {
    }

    public Comercio(int idC, String denominacionC) {
        this.idC = idC;
        this.denominacionC = denominacionC;
    }
    
}
