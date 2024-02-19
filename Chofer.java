package models;

public class Chofer {
    private String nombre;
    private Evento[] eventos;
    private int numEventos;
    private static int total = 10;
    private static Chofer[] choferes = new Chofer[total];
    private static int numChoferes = 0;
    private double cantidad = 0.0;

    public String getNombre() {
        return nombre;
    }

    public Chofer(String nombre, int capacidadMaximaEventos) {
        this.nombre = nombre;
        this.eventos = new Evento[capacidadMaximaEventos];
        this.numEventos = 0;
    }

    public void registrarEvento(String descripcion) {
        if (numEventos < eventos.length) {
            Evento evento = new Evento(descripcion);
            eventos[numEventos] = evento;
            numEventos++;
            System.out.println("Evento registrado por el chofer " + nombre + ": " + evento);
        } else {
            System.out.println("No se pueden registrar más eventos, capacidad máxima alcanzada.");
        }
    }

    public static void altaNuevoChofer(String nombre, int capacidadMaximaEventos) {
        if (numChoferes < total) {
            Chofer nuevoChofer = new Chofer(nombre, capacidadMaximaEventos);
            choferes[numChoferes] = nuevoChofer;
            numChoferes++;
            System.out.println("Nuevo chofer agregado: " + nuevoChofer);
        } else {
            System.out.println("No se puede agregar más choferes, capacidad máxima alcanzada.");
        }
    }

    public static int getNumChoferes() {
        return numChoferes;
    }

    public static Chofer getChofer(int index) {
        if (index >= 0 && index < numChoferes) {
            return choferes[index];
        } else {
            return null; // Manejar el caso en que el índice esté fuera de rango
        }
    }

    public static void ListaChoferes() {
        System.out.println("\nLista de choferes:");
        for (int i = 0; i < numChoferes; i++) {
            System.out.println((i + 1) + ". " + choferes[i].getNombre());
        }
    }

    public void arqueo(double total) {
        cantidad += total;
        System.out.printf("El dinero generado en el día del chofer %s fue de: %.2f%n", nombre, cantidad);
    }
}