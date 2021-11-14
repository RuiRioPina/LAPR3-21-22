package lapr.project.model;

import lapr.project.utils.ShipValidation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * This class will contain the shipDynamics related attributes of a ship
 */
public class ShipDynamic {
    private String baseDateTime;
    private Location location;
    private String cargo;
    private Movement movement;
    private String transceiverClass;
    /**
     * The empty public constructor
     */
    public ShipDynamic() {
    }
    /**
     * Public constructor with all its attributes being initialized and verified.
     */
    public ShipDynamic(String baseDateTime, Location location, Movement movement, String cargo, String transceiverClass) {
        ShipValidation.validateBaseDateTime(baseDateTime);
        ShipValidation.validateTransceiverClass(transceiverClass);
        this.baseDateTime = baseDateTime;
        this.location = location;
        this.movement = movement;
        this.cargo = cargo;
        this.transceiverClass = transceiverClass;
    }

    public String getBaseDateTime() {
        return baseDateTime;
    }

    public void setBaseDateTime(String baseDateTime) {
        this.baseDateTime = baseDateTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public String getTransceiverClass() {
        return transceiverClass;
    }

    public void setTransceiverClass(String transceiverClass) {
        this.transceiverClass = transceiverClass;
    }

    public LocalDateTime getBaseDateTimeLDT() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(baseDateTime, format);
        return dateTime;
    }

    public double getSog() {
        return this.movement.getSog();
    }

    public double getCog() {
        return this.movement.getCog();
    }

    public String getLatitude() {
        return this.location.getLatitude();
    }

    public String getLongitude() {
        return this.location.getLongitude();
    }

    @Override
    public String toString() {
        return String.format("%nDate Time: %s, %s, Cargo: %s, %s, Transceiver class: %s", baseDateTime, location, cargo, movement, transceiverClass);
    }
}
