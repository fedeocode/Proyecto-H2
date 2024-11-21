package fede;

public class Perro {

    private Long id;
    private Integer edad;
    private String nombre;

    public Perro(Long id, Integer edad, String nombre) {
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }
}
