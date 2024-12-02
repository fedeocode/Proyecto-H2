package fede;

public class Empleado  {

    private Long id;
    private String nombre;
    private Integer edad;
    private String fechaIniciada;
    private Double sueldoBAsico=600.000;
    private Double sueldoTotal;
    private Integer habilitado;

    public Empleado(Long id, String nombre, Integer edad, String fechaIniciada, Double sueldoTotal, Double sueldoBAsico) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.fechaIniciada = fechaIniciada;
        this.sueldoTotal = sueldoTotal;
        this.sueldoBAsico = sueldoBAsico;
        this.habilitado = habilitado;
    }

    public Double calcularSueldoTotal(Integer habilitado ) throws noHabilitadoExeption {

        int habilitadoExtras=20;
        if(habilitadoExtras<20){
      Double horasExtras=getSueldoBAsico()+400.000;

         return horasExtras;

        }else{

           throw new noHabilitadoExeption("No esta habilitado");

        }

       }

    public Integer getHabilitado() {
        return habilitado;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getFechaIniciada() {
        return fechaIniciada;
    }

    public Double getSueldoBAsico() {
        return sueldoBAsico;
    }

    public Double getSueldoTotal() {
        return sueldoTotal;
    }

    public void setHabilitado(Integer habilitado) {
        this.habilitado = habilitado;
    }
}

