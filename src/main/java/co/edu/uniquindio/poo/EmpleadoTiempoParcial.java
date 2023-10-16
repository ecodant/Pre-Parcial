package co.edu.uniquindio.poo;
public class EmpleadoTiempoParcial extends Empleado {
    private int numeroHoras;
    private float salarioHora;

    public EmpleadoTiempoParcial(String nombre, String cargo, int numeroHoras, float salarioHora) {
        super(nombre, cargo);
        assert numeroHoras > 0 : "Número de horas debe ser mayor que 0";
        assert salarioHora > 0 : "Salario por hora debe ser mayor que 0";
        this.numeroHoras = numeroHoras;
        this.salarioHora = salarioHora;
    }

    // @Override
    public float calcularSalario() {
        return numeroHoras * salarioHora;
    }
    public int getNumeroHoras(){
        return numeroHoras;
    }
    public float getSalarioHora(){
        return numeroHoras;
    }
}

