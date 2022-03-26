
package Modelo;

public class Articulo {
    
    private int idA;
    private String codigo;
    private String denominacionA;
    private float precioUnitario;
    private int idTA;

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDenominacionA() {
        return denominacionA;
    }

    public void setDenominacionA(String denominacionA) {
        this.denominacionA = denominacionA;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getIdTA() {
        return idTA;
    }

    public void setIdTA(int idTA) {
        this.idTA = idTA;
    }

    public Articulo() {
    }

    public Articulo(int idA, String codigo, String denominacionA, float precioUnitario, int idTA) {
        this.idA = idA;
        this.codigo = codigo;
        this.denominacionA = denominacionA;
        this.precioUnitario = precioUnitario;
        this.idTA = idTA;
    }
    
}
