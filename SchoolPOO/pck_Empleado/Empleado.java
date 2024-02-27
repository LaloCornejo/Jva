package SchoolPOO.pck_Empleado;

public class Empleado {
  private int idEmpleado;
  private String nombre;
  private String departamento;
  private int anioVentas;
  private double[] ventas = new double[12];

  public Empleado(int idEmpleado, String nombre, String departamento, int anioVentas, double[] ventas) {
    this.idEmpleado = idEmpleado;
    this.nombre = nombre;
    this.departamento = departamento;
    this.anioVentas = anioVentas;
    for( int i  = 0; i < 12; i++){
      this.ventas[i] = ventas[i];
    }
  }

  public Empleado() {
    this(0, null, null, 0, new double[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1});
  }

  public void setIdEmpleado( int idEmpleado ){
    this.idEmpleado = idEmpleado;
  }
  
  public void setNombre( String nombre ){
    this.nombre = nombre;
  }

  public void setDepartamento( String departamento ){
    this.departamento = departamento;
  }

  public void setAnioVentas( int anioVentas){
    this.anioVentas = anioVentas;
  }

  public void setVentas( double venta, int mes ){
    ventas[mes-1] = venta;
  }

  public int getIdEmpleado(){
    return this.idEmpleado;
  }

  public String getNombre(){
    return this.nombre;
  }

  public String getDepartamento(){
    return this.departamento;
  }

  public int getAnioVentas(){
    return this.anioVentas;
  }

  public double getVentas( int mes ){
    return this.ventas[mes];
  }

  public double getVentasAnuales(){
    double suma = 0;
    for( int i = 0; i < 12; i++){
      if( this.ventas[i] != -1)
        suma += this.ventas[i];
    }
    return suma;
  }

  public String getDatos(){
    String tabla = "Mes | Ventas\n" + 
                  "--------------\n";

    for (int i = 0; i < 12; i++){
      if( this.getVentas(i) != -1)
        tabla += (i+1) + "\t" + getVentas(i) + "\n";
    }
    return "Datos del Empleado\n" + "------------------\n" +
          "Id Empleado: " + getIdEmpleado() + "\n" +
           "Nombre: " + getNombre() + "\n" +
           "Departamento: " + getDepartamento() + "\n" +
           "Año de Ventas: " + getAnioVentas() + "\n" +
           "Ventas Anuales: " + getVentasAnuales() + "\n" +
           tabla;
  }
}
