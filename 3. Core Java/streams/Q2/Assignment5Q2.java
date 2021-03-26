import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public class Assignment5Q2 {
    public static int maxComments(List<News> news) {
        HashMap<Integer,Integer> h = (HashMap<Integer, Integer>) news.stream().collect(Collectors.groupingBy(News::getNewsId,Collectors.summingInt(a->1)));

        int max = 0;
        int maxKey = 0;

        for(Map.Entry map:h.entrySet()){
            if(max<(int) map.getValue()){
                max = (int) map.getValue();
                maxKey = (int) map.getKey();
            }
        }
        return maxKey;

    }

    public static int budgetCount (List < News > news) {
        return (int)news.stream().filter(x-> x.getComment().contains("budget")).count();
    }
    public static String maxCommentsByUser (List < News > news) {
        HashMap<String,Integer> h = (HashMap<String, Integer>) news.stream().collect(Collectors.groupingBy(News::getCommentByUser,Collectors.summingInt(a->1)));

        String user = null;
        int max = 0;

        for(Map.Entry map:h.entrySet()){
            if(max< (int) map.getValue()){
                max = (int) map.getValue();
                user = (String) map.getKey();
            }
        }

        return user;
    }

    public static Map<String, Integer> sortMaxCommentsByUser (List < News > news) {
        Map<String,Integer> h = news.stream().collect(Collectors.groupingBy(News::getCommentByUser,Collectors.summingInt(a->1)));

         Map<String, Integer> s =  h.entrySet().stream().sorted(reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (oldValue, newValue)-> oldValue, LinkedHashMap::new));
         return s;

    }

    public static void main(String[] args) {}
}
