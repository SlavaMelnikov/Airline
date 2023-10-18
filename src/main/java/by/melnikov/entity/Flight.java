package by.melnikov.entity;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;
import java.util.StringJoiner;

public class Flight {
    private String destination;
    private String number;
    private String plane;
    private LocalTime departureTime;
    private DayOfWeek departureDay;

    public Flight(String destination, String number, String plane, LocalTime departureTime, DayOfWeek departureDay) {
        this.destination = destination;
        this.number = number;
        this.plane = plane;
        this.departureTime = departureTime;
        this.departureDay = departureDay;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

        if (!Objects.equals(destination, flight.destination)) return false;
        if (!Objects.equals(number, flight.number)) return false;
        if (!Objects.equals(plane, flight.plane)) return false;
        if (!Objects.equals(departureTime, flight.departureTime))
            return false;
        return departureDay == flight.departureDay;
    }

    @Override
    public int hashCode() {
        int result = destination != null ? destination.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (plane != null ? plane.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + (departureDay != null ? departureDay.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ",  "[", "]")
                .add("destination = " + destination)
                .add("number = " + number)
                .add("plane = " + plane)
                .add("departureTime = " + departureTime)
                .add("departureDay = " + departureDay)
                .toString();
    }
}
