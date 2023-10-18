package by.melnikov.creator;

import by.melnikov.entity.Flight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FactoryUtils {
    public static List<String> readFromFile(String pathToFile) {
        List<String> lines = new ArrayList<>();
        Path path = Path.of(pathToFile);
        if (Files.exists(path)) {
            try {
                lines = Files.readAllLines(path);
            } catch (IOException e) {
                System.out.println("Reading error");
            }
        }
        return lines;
    }

    public static List<String[]> extractData(List<String> lines) {
        List<String[]> data = new ArrayList<>();
        for (String line : lines) {
            data.add(line.split("\\s+"));
        }
        return data;
    }

    public static List<Flight> createSchedule(List<String[]> data) {
        List<Flight> schedule = new ArrayList<>();
        for (String[] param : data) {
            String destination = param[0];
            String number = param[1];
            String plane = param[2];
            LocalTime time = LocalTime.parse(param[3]);
            DayOfWeek dayOfWeek = DayOfWeek.values()[Integer.parseInt(param[4]) - 1];
            schedule.add(new Flight(destination, number, plane, time, dayOfWeek));
        }
        return schedule;
    }
}

