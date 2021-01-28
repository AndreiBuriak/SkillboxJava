import core.Line;
import core.Station;

import java.util.*;

public class StationIndex {
    HashMap<String, Line> number2line;
    HashSet<Station> stations;

    public StationIndex() {
        number2line = new HashMap<>();
        stations = new HashSet<>();
    }

    public List<Line> getLines() {
        ArrayList<Line> lines = new ArrayList<>();
        for (Map.Entry<String, Line> entry : number2line.entrySet()) {
            lines.add(entry.getValue());
        }
        return lines;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void addLine(Line line) {
        number2line.put(line.getNumber(), line);
    }

    public Line getLine(String number) {
        return number2line.get(number);
    }

}
