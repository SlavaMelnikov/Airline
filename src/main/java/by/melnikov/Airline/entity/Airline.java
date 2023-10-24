package by.melnikov.Airline.entity;

import java.util.List;

public class Airline {
    private List<Flight> flights;

    public Airline(List<Flight> flights) {
        this.flights = flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
