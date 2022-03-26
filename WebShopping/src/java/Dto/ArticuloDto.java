
package Dto;

public class ArticuloDto {
    
    private int idA;
    private String codigo;
    private String denominacionA;
    private float precioUnitario;
    private String denominacionTA;

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

    public String getDenominacionTA() {
        return denominacionTA;
    }

    public void setDenominacionTA(String denominacionTA) {
        this.denominacionTA = denominacionTA;
    }

    public ArticuloDto() {
    }

    public ArticuloDto(int idA, String codigo, String denominacionA, float precioUnitario, String denominacionTA) {
        this.idA = idA;
        this.codigo = codigo;
        this.denominacionA = denominacionA;
        this.precioUnitario = precioUnitario;
        this.denominacionTA = denominacionTA;
    }
    
}
