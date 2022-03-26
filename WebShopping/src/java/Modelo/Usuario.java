
package Modelo;

public class Usuario {
    
    private int idU;
    private String nombreU;
    private String contrasenia;

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getNombreU() {
        return nombreU;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Usuario() {
    }

    public Usuario(int idU, String nombreU, String contrasenia) {
        this.idU = idU;
        this.nombreU = nombreU;
        this.contrasenia = contrasenia;
    }
    
}
