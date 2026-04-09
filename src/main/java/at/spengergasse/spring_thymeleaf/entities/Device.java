package at.spengergasse.spring_thymeleaf.entities;

public class Device {
    private int id;
    private String type;
    private int roomnr;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRoomnr() {
        return roomnr;
    }

    public void setRoomnr(int roomnr) {
        this.roomnr = roomnr;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", roomnr=" + roomnr +
                '}';
    }

    public Device(String type, int roomnr) {
        this.type = type;
        this.roomnr = roomnr;
    }

    public Device(){}
}
