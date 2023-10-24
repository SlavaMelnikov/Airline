package by.melnikov.Airline.main;

import by.melnikov.Airline.service.AirlineService;
import by.melnikov.Airline.creator.AirlineCreator;
import by.melnikov.Airline.entity.Airline;
import by.melnikov.Airline.exception.CustomException;
import by.melnikov.Airline.printer.DataPrinter;
import by.melnikov.Airline.service.impl.AirlineServiceImpl;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws CustomException {
        Airline airline = AirlineCreator.create(".\\src\\main\\resources\\airline.txt");
        AirlineService airlineService = AirlineServiceImpl.getInstance();
        DataPrinter printer = DataPrinter.getInstance();

        printer.printData(airlineService.findAllFlights(airline));
        printer.printData(airlineService.findFlightsTo(airline, "moscow"));
        printer.printData(airlineService.findFlightsOn(airline, DayOfWeek.FRIDAY));
        printer.printData(airlineService.findFlightsOnAndAfter(airline, DayOfWeek.MONDAY, LocalTime.now()));
        printer.printData(airlineService.findAllFlightsAfter(airline, DayOfWeek.FRIDAY, LocalTime.parse("08:00")));
    }
}
