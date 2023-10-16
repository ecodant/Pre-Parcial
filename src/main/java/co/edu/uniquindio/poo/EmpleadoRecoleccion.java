package co.edu.uniquindio.poo;

public class EmpleadoRecoleccion extends Empleado {
    private int numeroKilos;
    private float valorKilo;

    public EmpleadoRecoleccion(String nombre, String cargo, int numeroKilos, float valorKilo) {
        super(nombre, cargo);
        assert numeroKilos > 0 : "Número de kilos debe ser mayor que 0";
        assert valorKilo > 0 : "Valor del kilo debe ser mayor que 0";
        this.numeroKilos = numeroKilos;
        this.valorKilo = valorKilo;
    }

    public float calcularSalario() {
        return numeroKilos * valorKilo;
    }
    public int getNumeroKilos(){
        return numeroKilos;
    }
    public float getValorKilo(){
        return valorKilo;
    }
}
