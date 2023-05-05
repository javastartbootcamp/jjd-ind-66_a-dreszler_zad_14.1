import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class FileUtils {
    private static final String RED = "\033[0;31m";
    private static final String RESET = "\033[0m";

    public static Map<Integer, Integer> getNumberOccurenceMap(String filePath) {
        Map<Integer, Integer> sortedNumbers = new TreeMap<>();
        try (
                var reader = new Scanner(new File(filePath))
        ) {
            while (reader.hasNextLine()) {
                Integer number = getNumber(reader);
                if (number != null) {
                    if (!sortedNumbers.containsKey(number)) {
                        sortedNumbers.put(number, 1);
                    } else {
                        sortedNumbers.put(number, sortedNumbers.get(number) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(RED + "Nie znaleziono pliku " + filePath + RESET);
        }

        return sortedNumbers;
    }

    private static Integer getNumber(Scanner reader) {
        Integer number = null;
        try {
            number = Integer.valueOf(reader.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(RED + "Pominięto wpis - w pliku powinny być tylko liczby całkowite" + RESET);
        }

        return number;
    }
}
