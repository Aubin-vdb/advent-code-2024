import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Day2 {
    public static void main(String[] args) {

        String filePath = "/Users/aubin/Downloads/inputs.csv";
        List<List<String>> data = new ArrayList<>();

        // Read the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split line into components based on comma
                List<String> row = Arrays.asList(line.split(","));
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long safeReport = data.stream()
                .map(Day2::convertToInt)
                .filter(Day2::isSafeReport1)
                .count();
        System.out.println("Safe report step 1 " + safeReport);

        List<List<Integer>> reportsToCheck = data.stream()
                .map(Day2::convertToInt)
                .filter(r -> !Day2.isSafeReport1(r))
                .toList();
        long complementSafeReport = generateCombinations(reportsToCheck);
        System.out.println("Safe report step 2 " + complementSafeReport);

        System.out.println("Total safe report " + (safeReport + complementSafeReport));

    }

    public static boolean isSafeReport1(List<Integer> input) {
        boolean resultGap = IntStream.range(1, input.size())
                .mapToDouble(i -> Math.abs(input.get(i) - input.get(i - 1)))
                .allMatch(d -> d >= 1 && d <= 3);
        boolean resultIncreasing = IntStream.range(1, input.size())
                .mapToDouble(i -> input.get(i) - input.get(i - 1))
                .allMatch(d -> d > 0);
        boolean resultDecreasing = IntStream.range(1, input.size())
                .mapToDouble(i -> input.get(i) - input.get(i - 1))
                .allMatch(d -> d < 0);
        return resultGap && (resultIncreasing || resultDecreasing);
    }

    public static long generateCombinations(List<List<Integer>> reportsToCheck) {
        long count = 0;
        for(List<Integer> report : reportsToCheck) {
            for(int i = 0; i < report.size(); i++) {
                List<Integer> tmp = new ArrayList<>(report);
                tmp.remove(i);
                if(isSafeReport1(tmp)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static List<Integer> convertToInt(List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .toList();
    }

}