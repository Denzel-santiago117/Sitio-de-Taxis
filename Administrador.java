package models;
import java.util.ArrayList;

public class Administrador {
    public ArrayList<Unidades> unidades;

    public Administrador() {
        this.unidades = new ArrayList<>();
    }

    public void altaNuevaUnidad(String marca, int matricula) {
        Unidades nuevaUnidad = new Unidades(marca, matricula);
        unidades.add(nuevaUnidad);
        System.out.println("Unidad nueva agregada: " + nuevaUnidad);
    }

    public void mostrarListaUnidades() {
        System.out.println("\nLista de unidades:");
        for (int i = 0; i < unidades.size(); i++) {
            System.out.println((i + 1) + ". " + unidades.get(i));
        }
    }

    public void asignarChofer(Unidades unidad, Chofer chofer) {
        unidad.setChofer(chofer);
        System.out.println("La unidad: " + unidad + " fue asignada al Chofer: " + chofer);
    }
}