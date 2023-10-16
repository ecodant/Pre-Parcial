package co.edu.uniquindio.poo;
import java.util.Collection;
// import java.util.Comparator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;
// import java.util.stream.Collector;
import java.util.stream.Collectors;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Finca {
    private String nombre;
    private final Collection<Empleado> empleados;
    public Finca(String nombre){
        assert nombre != null;

        this.nombre = nombre;
        this.empleados = new LinkedList<>();
    }

    public Collection<EmpleadoTiempoParcial> listaEmpleadosTiempoParcial() {
        Predicate<Empleado> condicion = empleado -> empleado instanceof EmpleadoTiempoParcial;
        return empleados.stream()
                .filter(condicion)
                .map(empleado -> (EmpleadoTiempoParcial) empleado)
                .sorted((empleado1, empleado2) -> Double.compare(empleado1.calcularSalario(), empleado2.calcularSalario()))
                .collect(Collectors.toList());
    }

    public Collection<Empleado> listarEmpleadosMenorRendimiento(){
        Collection<Empleado> listaEmpleadosMenorRendimiento  =  new LinkedList<>();
        Collection<EmpleadoRecoleccion> empleadosRecoleccion;
        Collection<EmpleadoTiempoParcial> empleadosTiempoParcial;

        double promedioKilosRecolectados = empleados.stream()
            .filter(empleado -> empleado instanceof EmpleadoRecoleccion)
            .mapToDouble(empleado -> ((EmpleadoRecoleccion) empleado).getNumeroKilos())
            .average()
            .orElse(0.0);

        double promedioHorasLaboradas = empleados.stream()
            .filter(empleado -> empleado instanceof EmpleadoTiempoParcial)
            .mapToDouble(empleado -> ((EmpleadoTiempoParcial) empleado).getNumeroHoras())
            .average()
            .orElse(0.0);

        empleadosRecoleccion = empleados.stream()
            .filter(empleado -> empleado instanceof EmpleadoRecoleccion)
            .map(empleado -> (EmpleadoRecoleccion) empleado)
            .filter(empleado -> empleado.getNumeroKilos() < promedioKilosRecolectados)
            .collect(Collectors.toList());

        empleadosTiempoParcial = empleados.stream()
            .filter(empleado -> empleado instanceof EmpleadoTiempoParcial)
            .map(empleado -> (EmpleadoTiempoParcial) empleado)
            .filter(empleado -> empleado.getNumeroHoras() < promedioHorasLaboradas)
            .collect(Collectors.toList());

        listaEmpleadosMenorRendimiento.addAll(empleadosRecoleccion);
        listaEmpleadosMenorRendimiento.addAll(empleadosTiempoParcial);

        return listaEmpleadosMenorRendimiento;
    }

    public Collection<EmpleadoRecoleccion> listarEmpleadosRecoleccion(int numeroKilos) {
    Predicate<Empleado> condicion = empleado -> empleado instanceof EmpleadoRecoleccion;
    return empleados.stream()
            .filter(condicion).map(empleado -> (EmpleadoRecoleccion) empleado)
            .filter(empleado -> empleado.getNumeroKilos() > numeroKilos).collect(Collectors.toList());
    }
    private double calcularPromedioSalario(){
        return empleados.stream()
                .mapToDouble(empleado -> empleado.calcularSalario())
                .average()
                .orElse(0.0);
    }

    public Collection<EmpleadoTiempoCompleto> listaEmpleadosTiempoCompleto() {
    Predicate<Empleado> condicion = empleado -> empleado instanceof EmpleadoTiempoCompleto;
    return empleados.stream()
            .filter(condicion)
            .map(empleado -> (EmpleadoTiempoCompleto) empleado).collect(Collectors.toList());
    }
    public Collection<Empleado> listarEmpleadosSalarioMayorPromedio(){

    Predicate<Empleado> condicion = empleado -> empleado.calcularSalario() > calcularPromedioSalario();
    return empleados.stream().filter(condicion).map(empleado -> empleado).collect(Collectors.toList());

    }
   
    public void adicionarEmpleado(Empleado empleado){
        validarEmpleadoExiste(empleado.getNombre());
        empleados.add(empleado);
    }

    public Optional<Empleado> buscarEmpleado(String nombre){
        return empleados.stream()
            .filter(empleado->empleado.getNombre().equals(nombre)).findAny();
    }
    private void validarEmpleadoExiste(String nombreEmpleado){
        boolean existeEmpleado = buscarEmpleado(nombreEmpleado).isPresent();
        ASSERTION.assertion(!existeEmpleado ,"El empleado ya esta registrado");
        
    }
    public Collection<Empleado> getEmpleados()
    {
        return empleados;
    } 
    public String getNombre()
    {
        return nombre;
    }
}
