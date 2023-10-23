package by.melnikov.entity;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;
import java.util.StringJoiner;

public class Flight {
    private long flightId; //todo
    private String number;
    private String destination;
    private String plane;
    private LocalTime departureTime;
    private DayOfWeek departureDay;

    public Flight(long flightId, String number, String destination, String plane, LocalTime departureTime, DayOfWeek departureDay) {
        this.flightId = flightId;
        this.number = number;
        this.destination = destination;
        this.plane = plane;
        this.departureTime = departureTime;
        this.departureDay = departureDay;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public DayOfWeek getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(DayOfWeek departureDay) {
        this.departureDay = departureDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (flightId != flight.flightId) return false;
        if (!Objects.equals(number, flight.number)) return false;
        if (!Objects.equals(destination, flight.destination)) return false;
        if (!Objects.equals(plane, flight.plane)) return false;
        if (!Objects.equals(departureTime, flight.departureTime))
            return false;
        return departureDay == flight.departureDay;
    }

    @Override
    public int hashCode() {
        int result = (int) (flightId ^ (flightId >>> 32));
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (plane != null ? plane.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + (departureDay != null ? departureDay.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ",  "[", "]")
                .add("flightId = " + flightId)
                .add("number = " + number)
                .add("destination = " + destination)
                .add("plane = " + plane)
                .add("departureTime = " + departureTime)
                .add("departureDay = " + departureDay)
                .toString();
    }
}
