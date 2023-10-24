package by.melnikov.Airline.printer;

import by.melnikov.Airline.entity.Flight;

import java.util.List;

public class DataPrinter {
    private static DataPrinter instance;

    public static DataPrinter getInstance() {
        if (instance == null) {
            instance = new DataPrinter();
        }
        return instance;
    }

    public void printData(List<Flight> data) {
        for (Flight flight : data) {
            System.out.println(flight);
        }
        System.out.println();
    }
}
