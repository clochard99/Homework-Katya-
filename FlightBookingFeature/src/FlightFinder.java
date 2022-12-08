import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class FlightFinder {

    private Map<String, List<Flight>> allFlights = new HashMap<>();

    public FlightFinder(Map<String, List<Flight>> allFlights) {
        this.allFlights = allFlights;
    }

    public List<NavigableSet<Flight>> findFlights(int dayOfMonth, int month, int year,
                                                  int preferredDepartureStartHour, int preferredDepartureEndHour,
                                                  String departureCity, String arrivalCity, String finalArrivalCity,
                                                  String departureCityTimeZone, String arrivalCityTimeZone) {

        List<NavigableSet<Flight>> result = new ArrayList<>();
       LocalDateTime startDepartureTime = LocalDateTime.of(year, month, dayOfMonth, preferredDepartureStartHour,00,00);
       LocalDateTime endDepartureTime = LocalDateTime.of(year, month, dayOfMonth, preferredDepartureEndHour,00,00);

       ZonedDateTime startDepartureTime1 = ZonedDateTime.of(startDepartureTime, ZoneId.of(departureCityTimeZone));
       ZonedDateTime endDepartureTime1 = ZonedDateTime.of(endDepartureTime, ZoneId.of(arrivalCityTimeZone));

        List<Flight> allDepartingFlights = allFlights.get(departureCity);

        NavigableSet<Flight> departingflights = new TreeSet<>();

        for(int i=0;i<allDepartingFlights.size();i++){

            Flight flight = allDepartingFlights.get(i);

            if ( startDepartureTime.isBefore(flight.getDepartureTime())&& endDepartureTime.isAfter(flight.getDepartureTime()) && flight.getArrivalCity().equalsIgnoreCase(arrivalCity) ){

                //System.out.println(flight.getDepartureTime() + flight.getArrivalCity() + startDepartureTime);

                departingflights.add(flight);
            }
        }


        List<Flight> allConnectingFlights = allFlights.get(arrivalCity);
        NavigableSet<Flight> departingflights2 = departingflights;
        NavigableSet<Flight> connectingflights = new TreeSet<>();
        for(Flight f: departingflights2){

            int arrivalTime = f.getArrivalTime().getHour();

            for(int i=0;i<allConnectingFlights.size();i++){

                Flight flight2 = allConnectingFlights.get(i);

                int departureTime = flight2.getDepartureTime().getHour();

                int temp = (departureTime-arrivalTime);

                if(flight2.getArrivalCity().equalsIgnoreCase(finalArrivalCity)&& flight2.getDepartureCity().equalsIgnoreCase(arrivalCity) && temp>=2){

                    connectingflights.add(flight2);

                    //System.out.println(flight2.getDepartureTime() + flight2.getArrivalCity()+ flight2);
                }
            }
        }
        result.add(departingflights);
        result.add(connectingflights);
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Flight f1 = new Flight(1, "1", "Emirates", "New York", "Dubai",
                LocalDateTime.of(2017, 12, 20, 9, 0), LocalDateTime.of(2017, 12, 20, 9, 0));
        Flight f2 = new Flight(2, "2", "Delta", "San Francisco", "Paris",
                LocalDateTime.of(2017, 12, 20, 9, 0), LocalDateTime.of(2017, 12, 20, 9, 0));
        Flight f3 = new Flight(3, "3", "Delta", "San Francisco", "Rome",
                LocalDateTime.of(2017, 12, 20, 9, 0), LocalDateTime.of(2017, 12, 20, 9, 0));
        Flight f4 = new Flight(4, "4", "Emirates", "San Francisco", "Dubai",
                LocalDateTime.of(2017, 12, 20, 8, 0), LocalDateTime.of(2017, 12, 20, 8, 0));
        Flight f5 = new Flight(5, "5", "Emirates", "San Francisco", "Dubai",
                LocalDateTime.of(2017, 12, 20, 9, 30), LocalDateTime.of(2017, 12, 20, 9, 30));
        Flight f6 = new Flight(6, "6", "Emirates", "San Francisco", "Dubai",
                LocalDateTime.of(2017, 12, 20, 11, 30), LocalDateTime.of(2017, 12, 20, 11, 30));
        Flight f7 = new Flight(7, "7", "Emirates", "San Francisco", "Dubai",
                LocalDateTime.of(2017, 12, 20, 12, 30), LocalDateTime.of(2017, 12, 20, 12, 30));


        Flight f11 = new Flight(11, "11", "Emirates", "Dubai", "Mumbai",
                LocalDateTime.of(2017, 12, 20, 9, 30), LocalDateTime.of(2017, 12, 20, 9, 30));
        Flight f12 = new Flight(12, "12", "Emirates", "Dubai", "Mumbai",
                LocalDateTime.of(2017, 12, 20, 10, 30), LocalDateTime.of(2017, 12, 20, 10, 30));
        Flight f13 = new Flight(13, "13", "Delta", "Dubai", "Mumbai",
                LocalDateTime.of(2017, 12, 20, 12, 0), LocalDateTime.of(2017, 12, 20, 12, 0));
        Flight f14 = new Flight(14, "14", "Delta", "Dubai", "Mumbai",
                LocalDateTime.of(2017, 12, 20, 14, 0), LocalDateTime.of(2017, 12, 20, 14, 0));

        Map<String, List<Flight>> allFlights = new HashMap<>();

        allFlights.put("New York", Arrays.asList(f1));
        allFlights.put("San Francisco", Arrays.asList(f2, f3, f4, f5, f6, f7));
        allFlights.put("Dubai", Arrays.asList(f11, f12, f13, f14));

        List<NavigableSet<Flight>> result = new FlightFinder(allFlights).findFlights(20, 12, 2017, 9, 13, "San Francisco", "Dubai", "Mumbai", "America/Los_Angeles", "Asia/Dubai");
    }

}