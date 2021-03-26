import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment5Q1 {
    public static List<String> reverseSort(ArrayList<Fruit> fruits) {
        List<String> s= new ArrayList<>();

        fruits.stream().filter(x->x.getCalories()<100).sorted(Comparator.comparingInt(Fruit::getCalories).reversed())
                .collect(Collectors.toList())
                .forEach(x-> s.add(x.getName()));

        return s;


    }

    public static ArrayList<Fruit> sort(ArrayList<Fruit> Fruits) {

        Fruits = (ArrayList<Fruit>) Fruits.stream().sorted(Comparator.comparing(Fruit::getColor))
                .collect(Collectors.toList());
        return Fruits;
    }

    public static ArrayList<Fruit> filterRedSortPrice(ArrayList<Fruit> fruits){
        fruits = (ArrayList<Fruit>) fruits.stream().filter(x-> x.getName().equals("RED"))
                .sorted(Comparator.comparingInt(Fruit::getPrice))
                .collect(Collectors.toList());
        return fruits;
    }


    public static void main(String[] args) {}
}
