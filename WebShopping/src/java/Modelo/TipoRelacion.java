
package Modelo;

public class TipoRelacion {
    
    private int idTR;
    private String nombreTR;

    public int getIdTR() {
        return idTR;
    }

    public void setIdTR(int idTR) {
        this.idTR = idTR;
    }

    public String getNombreTR() {
        return nombreTR;
    }

    public void setNombreTR(String nombreTR) {
        this.nombreTR = nombreTR;
    }

    public TipoRelacion() {
    }

    public TipoRelacion(int idTR, String nombreTR) {
        this.idTR = idTR;
        this.nombreTR = nombreTR;
    }
    
}
