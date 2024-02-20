package SchoolPOO.pck_articulo;

public class Articulo{ 
    private int idArticulo;
    private String descripcion;
    private String contenido;
    private float precio;
    private String status;


    public void setIdArticulo( int idArticulo ){
        this.idArticulo = idArticulo;
    }

    public void setDescripcion( String descripcion ){
        this.descripcion = descripcion;
    }

    public void setContenido( String contenido ){
        this.contenido = contenido;
    }

    public void setPrecio( float precio ){
        this.precio = precio;
    }
    public void setStatus( String status ){
        this.status = status;
    }

    public int getIdArticulo(){
        return idArticulo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getContenido(){
        return contenido;
    }

    public float getPrecio(){
        return precio;
    }

    public String getStatus(){
        return status;
    }

    public String getDatos(){
        return "***** ARTICULO *****\n" +
            "\nidArtculo: " + getIdArticulo() +
            "\nDescripcion: " + getDescripcion() +
            "\nContenido: " + getContenido() +
            "\nPrecio: " + getPrecio() +
            "\nStatus: " + getStatus();
    }
}