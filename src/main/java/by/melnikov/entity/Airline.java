package by.melnikov.entity;

import java.util.List;

public class Airline {
    private List<Flight> allFlights;

    public Airline(List<Flight> allFlights) {
        this.allFlights = allFlights;
    }

    public void setAllFlights(List<Flight> allFlights) {
        this.allFlights = allFlights;
    }

    public List<Flight> getAllFlights() {
        return allFlights;
    }
}
