package Controlador;

import Dto.ArticuloDto;
import Dto.InvitadoDto;
import Dto.ParejaComercioDto;
import Dto.ParejaDto;
import Dto.RegaloDto;
import Dto.TipoArticuloDto;
import Modelo.Articulo;
import Modelo.Comercio;
import Modelo.Invitado;
import Modelo.Pareja;
import Modelo.Regalo;
import Modelo.TipoArticulo;
import Modelo.TipoRelacion;
import Modelo.Usuario;
import com.sun.javafx.beans.IDProperty;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection con;
    private Statement S;
    private PreparedStatement PS;
    private ResultSet RS;

    public void abrirConexion() {
        try {
            String url = "jdbc:sqlserver://DESKTOP-E8FRIUV\\SQLEXPRESS:1433;databaseName=Shopping";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection(url, "sa", "giandjoe");
            System.out.println("Conexión a la BD");
        } catch (Exception e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        try {
            con.close();
            System.out.println("Conexión a la BD cerrada");
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión:" + e.getMessage());
        }
    }

    public void altaPareja(Pareja nuevaPareja) {
        try {
            abrirConexion();
            PS = con.prepareStatement("INSERT INTO pareja (nombre1, apellido1, nombre2, apellido2, fechaCasamiento, idC) VALUES (?,?,?,?,?,?)");

            PS.setString(1, nuevaPareja.getNombre1());
            PS.setString(2, nuevaPareja.getApellido1());
            PS.setString(3, nuevaPareja.getNombre2());
            PS.setString(4, nuevaPareja.getApellido2());
            PS.setString(5, nuevaPareja.getFechaCasamiento());
            PS.setInt(6, nuevaPareja.getIdC());

            PS.execute();

            PS.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al insertar una Pareja: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void bajaPareja(Pareja borrarPareja) {
        try {
            abrirConexion();
            PS = con.prepareStatement("DELETE FROM pareja WHERE idP=?");

            PS.setInt(1, borrarPareja.getIdP());

            PS.executeUpdate();

            PS.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al borrar una Pareja: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void modificarPareja(Pareja cambiarPareja) {
        try {
            abrirConexion();
            PS = con.prepareStatement("UPDATE pareja SET nombre1=?, apellido1=?, nombre2=?, apellido2=?, fechaCasamiento=?, idC=? WHERE idP=?");

            PS.setString(1, cambiarPareja.getNombre1());
            PS.setString(2, cambiarPareja.getApellido1());
            PS.setString(3, cambiarPareja.getNombre2());
            PS.setString(4, cambiarPareja.getApellido2());
            PS.setString(5, cambiarPareja.getFechaCasamiento());
            PS.setInt(6, cambiarPareja.getIdC());
            PS.setInt(7, cambiarPareja.getIdP());

            PS.executeUpdate();

            PS.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al modificar una Pareja: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public ArrayList<ParejaDto> listarParejas() {
        ArrayList<ParejaDto> lista = new ArrayList<>();

        try {
            abrirConexion();
            S = con.createStatement();
            RS = S.executeQuery("SELECT p.idP, p.nombre1, p.apellido1, p.nombre2, p.apellido2, p.fechaCasamiento, c.denominacionC FROM pareja p INNER JOIN comercio c ON p.idC=c.idC ORDER BY c.denominacionC");

            while (RS.next()) {
                ParejaDto P = new ParejaDto();

                P.setIdP(RS.getInt(1));
                P.setNombre1(RS.getString(2));
                P.setApellido1(RS.getString(3));
                P.setNombre2(RS.getString(4));
                P.setApellido2(RS.getString(5));
                P.setFechaCasamiento(RS.getString(6));
                P.setDenominacionC(RS.getString(7));

                lista.add(P);
            }

            RS.close();
            S.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar las Pareja: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return lista;
    }

    public void altaArticulo(Articulo nuevoArticulo) {
        try {
            abrirConexion();
            PS = con.prepareStatement("INSERT INTO articulo (codigo, denominacionA, precioUnitario, idTA) VALUES (?,?,?,?)");

            PS.setString(1, nuevoArticulo.getCodigo());
            PS.setString(2, nuevoArticulo.getDenominacionA());
            PS.setFloat(3, nuevoArticulo.getPrecioUnitario());
            PS.setInt(4, nuevoArticulo.getIdTA());

            PS.execute();

            PS.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al insertar un Artículo: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void bajaArticulo(Articulo borrarArticulo) {
        try {
            abrirConexion();
            PS = con.prepareStatement("DELETE FROM articulo WHERE idA=?");

            PS.setInt(1, borrarArticulo.getIdA());

            PS.executeUpdate();

            PS.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al borrar un Artículo: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void modificarArticulo(Articulo cambiarArticulo) {
        try {
            abrirConexion();
            PS = con.prepareStatement("UPDATE articulo SET codigo=?, denominacionA=?, precioUnitario=?, idTA=? WHERE idA=?");

            PS.setString(1, cambiarArticulo.getCodigo());
            PS.setString(2, cambiarArticulo.getDenominacionA());
            PS.setFloat(3, cambiarArticulo.getPrecioUnitario());
            PS.setInt(4, cambiarArticulo.getIdTA());
            PS.setInt(5, cambiarArticulo.getIdA());

            PS.executeUpdate();

            PS.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al modificar un Artículo: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public ArrayList<ArticuloDto> listarArticulos() {
        ArrayList<ArticuloDto> lista = new ArrayList<>();

        try {
            abrirConexion();
            S = con.createStatement();
            RS = S.executeQuery("SELECT a.idA, a.codigo, a.denominacionA, a.precioUnitario, ta.denominacionTA FROM Articulo a INNER JOIN tipoArticulo ta ON a.idTA=ta.idTA ORDER BY ta.denominacionTA");

            while (RS.next()) {
                ArticuloDto A = new ArticuloDto();

                A.setIdA(RS.getInt(1));
                A.setCodigo(RS.getString(2));
                A.setDenominacionA(RS.getString(3));
                A.setPrecioUnitario(RS.getFloat(4));
                A.setDenominacionTA(RS.getString(5));

                lista.add(A);
            }

            RS.close();
            S.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar los Artículos: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return lista;
    }

    public void altaInvitado(Invitado nuevoInvitado) {
        try {
            abrirConexion();
            PS = con.prepareStatement("INSERT INTO invitado (nombreI, idP, idTR) VALUES (?,?,?)");

            PS.setString(1, nuevoInvitado.getNombreI());
            PS.setInt(2, nuevoInvitado.getIdP());
            PS.setInt(3, nuevoInvitado.getIdTR());

            PS.execute();

            PS.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al insertar un Invitado: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void bajaInvitado(Invitado borrarInvitado) {
        try {
            abrirConexion();
            PS = con.prepareStatement("DELETE FROM invitado WHERE idI=?");

            PS.setInt(1, borrarInvitado.getIdI());

            PS.executeUpdate();

            PS.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al borrar un Invitado: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void modificarInvitado(Invitado cambiarInvitado) {
        try {
            abrirConexion();
            PS = con.prepareStatement("UPDATE invitado SET nombreI=?, idP=?, idTR=? WHERE idI=?");

            PS.setString(1, cambiarInvitado.getNombreI());
            PS.setInt(2, cambiarInvitado.getIdP());
            PS.setInt(3, cambiarInvitado.getIdTR());
            PS.setInt(4, cambiarInvitado.getIdI());

            PS.executeUpdate();

            PS.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al modificar un Invitado: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public ArrayList<InvitadoDto> listarInvitados() {
        ArrayList<InvitadoDto> lista = new ArrayList<>();

        try {
            abrirConexion();
            S = con.createStatement();
            RS = S.executeQuery("SELECT i.idI, i.nombreI, p.nombre1, p.nombre2, tr.nombreTR FROM pareja p INNER JOIN invitado i ON p.idP=i.idP INNER JOIN tipoRelacion tr ON i.idTR=tr.idTR ORDER BY p.nombre1");

            while (RS.next()) {
                InvitadoDto I = new InvitadoDto();

                I.setIdI(RS.getInt(1));
                I.setNombreI(RS.getString(2));
                I.setNombre1(RS.getString(3));
                I.setNombre2(RS.getString(4));
                I.setNombreTR(RS.getString(5));

                lista.add(I);
            }

            RS.close();
            S.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar los Invitados: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return lista;
    }

    public ArrayList<TipoArticulo> listarTipoArticulos() {
        ArrayList<TipoArticulo> lista = new ArrayList<>();

        try {
            abrirConexion();
            S = con.createStatement();
            RS = S.executeQuery("SELECT * FROM tipoArticulo");

            while (RS.next()) {
                TipoArticulo TA = new TipoArticulo();

                TA.setIdTA(RS.getInt(1));
                TA.setDenominacionTA(RS.getString(2));

                lista.add(TA);
            }

            RS.close();
            S.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar los Invitados: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return lista;
    }

    public ArrayList<TipoRelacion> listarTipoRelacion() {
        ArrayList<TipoRelacion> lista = new ArrayList<>();

        try {
            abrirConexion();
            S = con.createStatement();
            RS = S.executeQuery("SELECT * FROM tipoRelacion");

            while (RS.next()) {
                TipoRelacion TR = new TipoRelacion();

                TR.setIdTR(RS.getInt(1));
                TR.setNombreTR(RS.getString(2));

                lista.add(TR);
            }

            RS.close();
            S.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar el Tipo de Relación: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return lista;
    }

    public ArrayList<Comercio> listarComercios() {
        ArrayList<Comercio> lista = new ArrayList<>();

        try {
            abrirConexion();
            S = con.createStatement();
            RS = S.executeQuery("SELECT * FROM Comercio");

            while (RS.next()) {
                Comercio C = new Comercio();

                C.setIdC(RS.getInt(1));
                C.setDenominacionC(RS.getString(2));

                lista.add(C);
            }

            RS.close();
            S.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar los Comercios: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return lista;
    }

    public void altaRegalo(Regalo nuevoRegalo) {
        try {
            abrirConexion();
            PS = con.prepareStatement("INSERT INTO regalo (idP, idA, idI, cantidad, regalado) VALUES (?,?,NULL,0,0)");

            PS.setInt(1, nuevoRegalo.getIdP());
            PS.setInt(2, nuevoRegalo.getIdA());

            PS.execute();

            PS.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al insertar un Regalo: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public ArrayList<RegaloDto> listarLista(int numeroP) {

        ArrayList<RegaloDto> lista = new ArrayList<>();

        try {
            abrirConexion();
            S = con.createStatement();
            RS = S.executeQuery("SELECT a.denominacionA, r.idA, r.idP FROM regalo r INNER JOIN articulo a ON r.idA=a.idA WHERE regalado=0 and idP=" + numeroP + "");

            while (RS.next()) {

                RegaloDto R = new RegaloDto();

                R.setDenominacionA(RS.getString(1));
                R.setIdA(RS.getInt(2));
                R.setIdP(RS.getInt(3));

                lista.add(R);
            }

            RS.close();
            S.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar la Lista: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return lista;
    }

    public int numeroPareja(int numeroP) {
        int idPareja = 0;

        try {

            abrirConexion();
            S = con.createStatement();
            RS = S.executeQuery("SELECT idP FROM pareja WHERE idP like " + numeroP);

            RS.next();

            idPareja = RS.getInt(1);

            RS.close();
            S.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Ocurrió un error al obtener el número de la Pareja: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return idPareja;
    }

    public boolean ingresoAdm(String nombreU, String contrasenia) {
        try {
            abrirConexion();
            PS = con.prepareStatement("SELECT nombreU, contrasenia FROM usuario WHERE nombreU=? AND contrasenia=?");

            PS.setString(1, nombreU);
            PS.setString(2, contrasenia);

            RS = PS.executeQuery();

            if (RS.next()) {

                return true;
            }
            else{
                System.out.println("NO");
            }
            RS.close();
            S.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar ingresar: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    public ArrayList<ParejaComercioDto> reporte1() {

        ArrayList<ParejaComercioDto> lista = new ArrayList<>();

        try {
            abrirConexion();
            S = con.createStatement();
            RS = S.executeQuery("SELECT p.nombre1, p.apellido1, p.nombre2, p.apellido2, p.fechaCasamiento, c.denominacionC FROM pareja p INNER JOIN comercio c ON p.idC=c.idC ORDER BY c.denominacionC");

            while (RS.next()) {

                ParejaComercioDto PC = new ParejaComercioDto();

                PC.setNombre1(RS.getString(1));
                PC.setApellido1(RS.getString(2));
                PC.setNombre2(RS.getString(3));
                PC.setApellido2(RS.getString(4));
                PC.setFechaCasamiento(RS.getString(5));
                PC.setDenominacionC(RS.getString(6));

                lista.add(PC);
            }

            RS.close();
            S.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar el Reporte: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return lista;
    }

    public ArrayList<Invitado> invitadoPorPareja(int numeroPareja) {
        ArrayList<Invitado> lista = new ArrayList<>();

        try {

            abrirConexion();
            S = con.createStatement();
            RS = S.executeQuery("SELECT * FROM invitado WHERE idP=" + numeroPareja);

            while (RS.next()) {
                Invitado I = new Invitado();

                I.setIdI(RS.getInt(1));
                I.setNombreI(RS.getString(2));
                I.setIdP(RS.getInt(3));
                I.setIdTR(RS.getInt(4));

                lista.add(I);
            }

            RS.close();
            S.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar el Invitado: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return lista;
    }

    public ArrayList<RegaloDto> articuloPorPareja(int numeroPareja) {
        ArrayList<RegaloDto> lista = new ArrayList<>();

        try {

            abrirConexion();
            S = con.createStatement();
            RS = S.executeQuery("SELECT r.idR, a.denominacionA FROM regalo r INNER JOIN articulo a ON r.idA=a.idA WHERE idP=" + numeroPareja);

            while (RS.next()) {
                RegaloDto R = new RegaloDto();

                R.setIdR(RS.getInt(1));
                R.setDenominacionA(RS.getString(2));

                lista.add(R);
            }

            RS.close();
            S.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar el Regalo: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return lista;
    }

    public void nuevoRegalo(Regalo nuevoRegalo) {
        try {
            abrirConexion();
            PS = con.prepareStatement("UPDATE regalo SET idI=?, cantidad=?, regalado=1 WHERE idR=?");

            PS.setInt(1, nuevoRegalo.getIdI());
            PS.setInt(2, nuevoRegalo.getCantidad());
            PS.setInt(3, nuevoRegalo.getIdR());

            PS.executeUpdate();

            PS.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al modificar una Regalo: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public float reporte2() {
        float total = 0;

        try {

            abrirConexion();
            S = con.createStatement();
            RS = S.executeQuery("SELECT SUM(a.precioUnitario*r.cantidad) FROM articulo a INNER JOIN regalo r ON a.idA=r.idA WHERE r.regalado=1");

            RS.next();

            total = RS.getFloat(1);

            RS.close();
            S.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Ocurrió un error al obtener el Reporte: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return total;
    }
    
    public ArrayList<Pareja> reporte3() {

        ArrayList<Pareja> lista = new ArrayList<>();

        try {
            abrirConexion();
            S = con.createStatement();
            RS = S.executeQuery("SELECT p.nombre1, p.apellido1, p.nombre2, p.apellido2 FROM pareja p INNER JOIN regalo r ON p.idP=r.idP INNER JOIN articulo a ON a.idA=r.idA GROUP BY r.regalado, p.nombre1, p.apellido1, p.nombre2, p.apellido2 HAVING SUM(a.precioUnitario)>10000 AND r.regalado=1");

            while (RS.next()) {

                Pareja P = new Pareja();

                P.setNombre1(RS.getString(1));
                P.setApellido1(RS.getString(2));
                P.setNombre2(RS.getString(3));
                P.setApellido2(RS.getString(4));

                lista.add(P);
            }

            RS.close();
            S.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar el Reporte: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return lista;
    }
    
     public ArrayList<TipoArticuloDto> reporte4() {

        ArrayList<TipoArticuloDto> lista = new ArrayList<>();

        try {
            abrirConexion();
            S = con.createStatement();
            RS = S.executeQuery("SELECT ta.denominacionTA, COUNT(a.idA) FROM articulo a INNER JOIN tipoArticulo ta ON a.idTA=ta.idTA INNER JOIN regalo r ON r.idA=a.idA WHERE regalado = 0 GROUP BY ta.denominacionTA ORDER BY COUNT(a.idA) DESC");

            while (RS.next()) {

                TipoArticuloDto TA = new TipoArticuloDto();

                TA.setDenominacionTA(RS.getString(1));
                TA.setCantidad(RS.getInt(2));
                
                lista.add(TA);
            }

            RS.close();
            S.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar el Reporte: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return lista;
    }
}
