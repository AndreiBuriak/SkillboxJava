import core.Line;
import core.Station;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String URL = "https://www.moscowmap.ru/metro.html#lines";
    private static final String PATH_FILE = "src/main/resources/mapMSK.json";
    private static StationIndex stationIndex;

    public static void main(String[] args) throws IOException {
        createStationIndex();
        for (Line lines : stationIndex.getLines()) {
            System.out.println(lines.getName() + " : " + lines.getStations().size() + " станций");
        }
    }

    private static void fillFile() throws IOException {
        Document document = Jsoup.connect(URL).maxBodySize(0).get();
        Elements linkLINES = document.select("span[data-line]");

        JSONObject map = new JSONObject();
        JSONArray lines = new JSONArray();
        JSONArray stations = new JSONArray();
        Elements linkSTATION;
        String lineNumber;
        for (Element element : linkLINES) {
            JSONObject lineINFO = new JSONObject();
            lineNumber = element.attr("data-line");
            lineINFO.put("name", element.text());
            lineINFO.put("number", lineNumber);
            lines.add(lineINFO);

            JSONObject stationsOnLine = new JSONObject();
            linkSTATION = document.select("div[data-depend-set=lines-" + lineNumber + "]");
            String[] s = linkSTATION.text().split("\\s(\\d|\\d.)\\.\\s");
            stationsOnLine.put(lineNumber, Arrays.asList(s).subList(1, s.length));
            stations.add(stationsOnLine);
        }
        map.put("stations", stations);
        map.put("lines", lines);
        try {

            try (FileWriter file = new FileWriter(PATH_FILE)) {
                file.write(map.toString());
                file.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createStationIndex() {
        stationIndex = new StationIndex();
        try {
            fillFile();

            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

            JSONArray linesArray = (JSONArray) jsonData.get("lines");
            parseLines(linesArray);

            JSONArray stationsArray = (JSONArray) jsonData.get("stations");
            parseStations(stationsArray);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void parseStations(JSONArray stationsArray) {
        stationsArray.forEach(stationObject -> {
            JSONObject stationJsonObject = (JSONObject) stationObject;
            stationJsonObject.keySet().forEach(stationJsonArray -> {
                Line line = stationIndex.getLine((String) stationJsonArray);
                JSONArray stationArray = (JSONArray) stationJsonObject.get(stationJsonArray);
                stationArray.forEach(stationJson ->
                {
                    Station station = new Station((String) stationJson, line);
                    stationIndex.addStation(station);
                    line.addStation(station);
                });
            });
        });
    }

    private static void parseLines(JSONArray linesArray) {
        linesArray.forEach(lineObject -> {
            JSONObject lineJsonObject = (JSONObject) lineObject;
            Line line = new Line(
                    (String) lineJsonObject.get("number"),
                    (String) lineJsonObject.get("name")
            );
            stationIndex.addLine(line);
        });
    }

    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(PATH_FILE));
            lines.forEach(builder::append);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
