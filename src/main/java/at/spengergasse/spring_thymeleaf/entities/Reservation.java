package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Device device;

    public Reservation() {}

    public long getId() { return id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Device getDevice() { return device; }
    public void setDevice(Device device) { this.device = device; }
}