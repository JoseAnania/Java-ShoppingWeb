
package Dto;

public class InvitadoDto {
    
    private int idI;
    private String nombreI;
    private String nombre1;
    private String nombre2;
    private String nombreTR;

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

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getNombreTR() {
        return nombreTR;
    }

    public void setNombreTR(String nombreTR) {
        this.nombreTR = nombreTR;
    }

    public InvitadoDto() {
    }

    public InvitadoDto(int idI, String nombreI, String nombre1, String nombre2, String nombreTR) {
        this.idI = idI;
        this.nombreI = nombreI;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.nombreTR = nombreTR;
    }
    
}
