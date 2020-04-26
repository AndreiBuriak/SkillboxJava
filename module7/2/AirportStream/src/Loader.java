
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

public class Loader {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.HOUR_OF_DAY, 2);
        Date nowPlus2Hours = calendar.getTime();

        airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .collect(Collectors.toList())
                .stream().filter(f -> (f.getType() == Flight.Type.ARRIVAL) && (f.getDate().after(now)) && f.getDate().before(nowPlus2Hours))
                .sorted(Comparator.comparing(Flight::getDate))
                .forEach(f -> System.out.println(dateFormat.format(f.getDate()) + "\t" + f.getAircraft()));


    }
}
