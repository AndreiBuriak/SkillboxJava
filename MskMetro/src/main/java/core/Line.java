package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Line {
    private final String number;
    private final String name;
    private final List<Station> stations;

    public Line(String number, String name) {
        this.number = number;
        this.name = name;
        stations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStation(Station... station) {
        stations.addAll(Arrays.asList(station));
    }

    public List<Station> getStations() {
        return stations;
    }

    public String getNumber() {
        return number;
    }
}
