package SchoolPOO.pck_estudiante;

public class Estuciante {
    private String nombre;
    private int noCuenta;
    private int semestre;
    private int grupo;
    private String programaEducativo;
    private float promedioGeneral;

    public void setNoCuenta(int noCuenta) {
        this.noCuenta = noCuenta;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public void setProgrmaEducativo(String programaEducativo) {
        this.programaEducativo = programaEducativo;
    }

    public void setPromedioGeneral(float promedioGeneral) {
        this.promedioGeneral = promedioGeneral;
    }

    public int getNoCuenta() {
        return noCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public int getGrupo() {
        return grupo;
    }

    public String getProgramaEducativo() {
        return programaEducativo;
    }

    public float getPromedioGeneral() {
        return promedioGeneral;
    }

    public String getDatos() {
        return "***** ESTUDIANTE *****\n" +
            "\nNo. Cuenta: " + getNoCuenta() +
            "\nNombre: " + getNombre() +
            "\nSemestre: " + getSemestre() +
            "\nGrupo: " + getGrupo() +
            "\nPrograma Educativo: " + getProgramaEducativo() +
            "\nPromedio General: " + getPromedioGeneral();
    }
}

//Jesus Eduardo Cornejo Clavel 3ro 1
//que es un contructor y que tipos hay