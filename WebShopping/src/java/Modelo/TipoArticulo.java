
package Modelo;

public class TipoArticulo {
    
    private int idTA;
    private String denominacionTA;

    public int getIdTA() {
        return idTA;
    }

    public void setIdTA(int idTA) {
        this.idTA = idTA;
    }

    public String getDenominacionTA() {
        return denominacionTA;
    }

    public void setDenominacionTA(String denominacionTA) {
        this.denominacionTA = denominacionTA;
    }

    public TipoArticulo() {
    }

    public TipoArticulo(int idTA, String denominacionTA) {
        this.idTA = idTA;
        this.denominacionTA = denominacionTA;
    }
    
}
