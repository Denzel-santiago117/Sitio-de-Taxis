package models;

public class Unidades {
    private String marca;
    private int matricula;
    private Chofer chofer;
    private static Unidades[] unidades; // Matriz estática para almacenar las unidades
    private static int numUnidades = 0; // Contador para el número de unidades

    public Unidades(String marca, int matricula) {
        this.marca = marca;
        this.matricula = matricula;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public static void inicializarUnidades(int capacidad) {
        unidades = new Unidades[capacidad];
    }

    public static void agregarUnidad(Unidades unidad) {
        unidades[numUnidades] = unidad;
        numUnidades++;
    }

    public static int getNumUnidades() {
        return numUnidades;
    }

    public static Unidades getUnidad(int index) {
        if (index >= 0 && index < numUnidades) {
            return unidades[index];
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        if (chofer != null) {
            return "Unidad - Marca: " + marca + ", Matrícula: " + matricula + ", Chofer Asignado: " + chofer.getNombre();
        } else {
            return "Unidad - Marca: " + marca + ", Matrícula: " + matricula + ", Sin Chofer Asignado";
        }
    }
}