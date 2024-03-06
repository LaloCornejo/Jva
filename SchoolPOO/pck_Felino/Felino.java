package SchoolPOO.pck_Felino;

public class Felino(){
    protected int idFelino;
    protected String color;
    protected String tamanio;

    public Felino(){
        this( 0, null, null);
    }

    public Felino( int idFelino, String color, String tamanio ){
        this.idFelino = idFelino;
        this.color = color;
        this.tamanio = tamanio;
    }

    public void setIdFelino( int idFelino ){
        this.idFelino = idFelino;
    }

    public void setColor( String color ){
        this.color = color;
    }

    public void setTamanio( String tamanio ){
        this.tamanio = tamanio;
    }

    public int getIDFelino(){
        return this.idFelino;
    }

    public String getColor(){
        return this.color;
    }

    public String getTamanio(){
        return this.tamanio;
    }

    public String getDatos(){
        return "\nID: " + getIDFelino() + "\ncolor: " + getColor() + "\nTamanio: " + getTamanio();
    }
}