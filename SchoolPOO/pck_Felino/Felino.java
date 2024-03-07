package SchoolPOO.pck_Felino;

public class Felino {
    protected int idFelino;
    protected String color;
    protected String tamano;

    public Felino() {
        this(0, null, null);
    }

    public Felino(int idFelino, String color, String tamano) {
        this.idFelino = idFelino;
        this.color = color;
        this.tamano = tamano;
    }

    public void setIdFelino(int idFelino) {
        this.idFelino = idFelino;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public int getIDFelino() {
        return this.idFelino;
    }

    public String getColor() {
        return this.color;
    }

    public String getTamano() {
        return this.tamano;
    }

    public String getDatos(){
        return "\nID: " + getIDFelino() + "\ncolor: " + getColor() + "\nTamano: " + getTamano();
    }
}