import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String filePath = "liczby.txt";
        Map<Integer, Integer> numberOccurenceMap = FileUtils.getNumberOccurenceMap(filePath);

        Set<Map.Entry<Integer, Integer>> entries = numberOccurenceMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getKey() + " - liczba wystąpień " + entry.getValue());
        }
    }
}
