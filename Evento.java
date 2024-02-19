package models;
import java.time.LocalDateTime;

public class Evento {
    private String descripcion;
    private LocalDateTime fechaHora;

    public Evento(String descripcion) {
        this.descripcion = descripcion;
        this.fechaHora = LocalDateTime.now();
    }
}