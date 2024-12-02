package fede;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

     Empleado empleado=new Empleado(3L,"jose",95, "22/7/65",300.00,200.00);

    static Boolean estaHabilitado=false;
    @BeforeAll
    static void inicio(){
        System.out.println("conectando la bd");

    }

    @BeforeEach
    void setUp() throws noHabilitadoExeption {
        empleado.setHabilitado(21);

    }

     @Test
    void getHabilitado() {
         assertEquals( empleado.getHabilitado(),5);
    }

    @Tag("smokeTest")
    @Test
    void setCalificacionException() {
        assertThrows(noHabilitadoExeption.class,()-> empleado.setHabilitado(25),
                "Ingrese del 20 hacia atras habilitacion no correcta ");

    }
    @ParameterizedTest
    @ValueSource(ints = {21,8,3,6,5})
    void setCalificacionValida(Integer habilitado) throws noHabilitadoExeption {
        empleado.setHabilitado(habilitado);
        assertEquals(empleado.getHabilitado(),habilitado);

    }
    @AfterEach
    void tearDown() {
        System.out.println("termino el test");
    }
}
