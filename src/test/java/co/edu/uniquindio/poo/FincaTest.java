package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;


public class FincaTest {
    private static final Logger LOG = Logger.getLogger(FincaTest.class.getName());
    @Test
    public void calcularSalarioEmpleadoRecoleccion(){
        LOG.info("Cargando Prueba Calcular Salario para los Empleado de Recolección...");

        Empleado empleadoRecoleccion = new EmpleadoRecoleccion("Juan", "Jardinero", (int) 12,(float) 4.55);

        //Esto es porque toca redondar el resultado del calculo dado que son floats
        BigDecimal bigDecimal = new BigDecimal(empleadoRecoleccion.calcularSalario());
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        assertEquals((float)54.6, bigDecimal.floatValue());
        LOG.info("Fin de la prueba Calcular Salario para los Empleados de Recolección.");
    }
    @Test
    public void calcularSalarioEmpleadoTiempoCompleto(){
        LOG.info("Cargando Prueba Calcular Salario para los Empleados de Tiempo Completo...");

        Empleado empleadoTiempoCompleto = new EmpleadoTiempoCompleto("Pablo", "Niñera", (float) 275.55);

        assertEquals((float)275.55, empleadoTiempoCompleto.calcularSalario());

        LOG.info("Fin de la prueba Calcular Salario para los Empleados de Tiempo Completo.");
    }
    @Test
    public void calcularSalarioEmpleadoTiempoParcial(){
        LOG.info("Cargando Prueba Calcular Salario para los Empleados de Tiempo Parcial");

        Empleado empleadoTiempoParcial = new EmpleadoTiempoParcial("Juan", "Jardinero", (int) 9,(float)6.35);

        //Esto es porque toca redondar el resultado del calculo dado que son floats
        BigDecimal bigDecimal = new BigDecimal(empleadoTiempoParcial.calcularSalario());
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        assertEquals((float) 57.15, bigDecimal.floatValue());

        LOG.info("Fin de la prueba Calcular Salario para los Empleados de Tiempo Parcial.");
    }

}
