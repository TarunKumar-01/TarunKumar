import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment5Q9 {
    public static List<String> printUniqueCities (List <Trader> traders) {

        List<String> cities = new ArrayList<>();

        traders.forEach(x-> cities.add(x.getCity()));

        return cities.stream().distinct().collect(Collectors.toList());
    }

    public static List<String> tradersFromPuneSortByName(List<Trader> traders) {
        List<String> l = new ArrayList<>();
        traders.stream()
                .filter(x-> x.getCity().equals("Pune"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(x-> l.add(x.getName()));

        return l;
    }

    public static String allTrader3Names(List<Trader> traders) {
        StringBuilder names = new StringBuilder();

        traders.stream().
                sorted(Comparator.comparing(Trader::getName))
                .forEach(x-> names.append(x.getName()));

        return names.toString();
    }
    public static ArrayList<Trader> areAnyTradersFromIndore(ArrayList<Trader> traders) {
        return (ArrayList<Trader>) traders.stream()
                .filter(x->x.getCity().equals("Indore"))
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {}
}
