
package Dto;

public class TipoArticuloDto {
    
    private String denominacionTA;
    private int cantidad;

    public String getDenominacionTA() {
        return denominacionTA;
    }

    public void setDenominacionTA(String denominacionTA) {
        this.denominacionTA = denominacionTA;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public TipoArticuloDto() {
    }

    public TipoArticuloDto(String denominacionTA, int cantidad) {
        this.denominacionTA = denominacionTA;
        this.cantidad = cantidad;
    }
    
}
