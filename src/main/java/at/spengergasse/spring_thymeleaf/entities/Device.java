package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.*;

@Entity
@Table(name="d_devices")
public class Device {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String type;
    private String location;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", location=" + location +
                '}';
    }

    public Device(String type, String location) {
        this.type = type;
        this.location = location;
    }

    public Device(){}
}
