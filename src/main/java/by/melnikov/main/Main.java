package by.melnikov.main;

import by.melnikov.creator.AirlineFactory;
import by.melnikov.entity.Airline;
import by.melnikov.entity.Flight;
import by.melnikov.exception.FileReaderException;
import by.melnikov.exception.ServiceException;
import by.melnikov.printer.DataPrinter;
import by.melnikov.service.AirlineService;
import by.melnikov.service.impl.AirlineServiceImpl;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileReaderException, ServiceException {
        Airline airline = AirlineFactory.create(".\\src\\main\\resources\\airline.txt");
        AirlineService airlineService = AirlineServiceImpl.getInstance();
        DataPrinter printer = DataPrinter.getInstance();

        printer.printData(airlineService.findAllFlights(airline));
        printer.printData(airlineService.findFlightsTo(airline, "moscow"));
        printer.printData(airlineService.findFlightsOn(airline, DayOfWeek.FRIDAY));
        printer.printData(airlineService.findFlightsOnAndAfter(airline, DayOfWeek.MONDAY, LocalTime.now()));
        printer.printData(airlineService.findAllFlightsAfter(airline, DayOfWeek.FRIDAY, LocalTime.parse("08:00")));
    }
}
