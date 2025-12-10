import java.util.*;
import java.util.stream.*;

public class Main {
    public static String[] filterByLength(String[] strings, boolean lessThanAverage) {
        if (strings == null || strings.length == 0) {
            return new String[0];
        }

       
        double averageLength = Arrays.stream(strings)
                                     .mapToInt(String::length)
                                     .average()
                                     .orElse(0.0);

    
        return Arrays.stream(strings)
                     .filter(s -> lessThanAverage ? 
                          s.length() < averageLength : 
                          s.length() > averageLength)
                     .toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] input = {"cat", "elephant", "dog", "a", "giraffe", "hi"};

       
        String[] shorter = filterByLength(input, true);
        System.out.println("Менші за середню: " + Arrays.toString(shorter));

        
        String[] longer = filterByLength(input, false);
        System.out.println("Більші за середню: " + Arrays.toString(longer));
    }
}