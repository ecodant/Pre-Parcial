package co.edu.uniquindio.poo;

public class EmpleadoTiempoCompleto extends Empleado {
    private float salario;

    public EmpleadoTiempoCompleto(String nombre, String cargo, float salario) {
        super(nombre, cargo);
        assert salario > 0 : "Salario debe ser mayor que 0";
        this.salario = salario;
    }

    public float calcularSalario() {
        return salario;
    }

    public float getSalario(){
        return salario;
    }
}
