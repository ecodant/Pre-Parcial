
package co.edu.uniquindio.poo;

public abstract class Empleado {
    private String nombre;
    private String cargo;

    public Empleado(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public abstract float calcularSalario();

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }
}
