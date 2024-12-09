import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day7 {

    public static void main(String[] args) {
        List<Calibration> calibrations = getCalibrations();

        Long result = getTotalValidCalibrationsWithDifferentOperators(calibrations);
        System.out.println("Result: " + result);
    }

    public static List<Calibration> getCalibrations() {
        String filePath = "/Users/aubin/Downloads/calibrations.txt";
        List<Calibration> calibrations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(":");
                List<Long> values = Arrays.stream(lineSplit[1].split(" ")).filter(r -> r != null && !r.isEmpty()).map(Long::parseLong).toList();
                calibrations.add(new Calibration(Long.parseLong(lineSplit[0]), values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return calibrations;
    }

    public static Long getTotalValidCalibrationsWithDifferentOperators(List<Calibration> calibrations) {
        Map<Long, List<String>> expressionByResult = new HashMap<>();
        // Generate combinations
        for(Calibration calibration : calibrations) {
            computeRecursively(calibration.values, 1, String.valueOf(calibration.values.getFirst()), calibration.result, expressionByResult);
        }
        // Evaluate expressions
        long total = 0;
        for(Map.Entry<Long, List<String>> entry : expressionByResult.entrySet()) {
            List<String> expressions = entry.getValue();
            List<Long> results = expressions.stream().map(Day7::evaluateExpression).toList();
            if(results.stream().anyMatch(r -> r.equals(entry.getKey()))) {
                total += entry.getKey();
            }
        }
        return total;
    }

    public static void computeRecursively(List<Long> values, int currentIndex, String expression, Long result, Map<Long, List<String>> expressionByResult) {
        if (currentIndex == values.size()) {
            expressionByResult.computeIfAbsent(result, _ -> new ArrayList<>()).add(expression);
            return;
        }
        // Add '+' operator
        computeRecursively(values, currentIndex + 1, expression + "+" + values.get(currentIndex), result, expressionByResult);
        // Add '*' operator
        computeRecursively(values, currentIndex + 1, expression + "*" + values.get(currentIndex), result, expressionByResult);
    }

    public static long evaluateExpression(String expression) {
        String[] parts = expression.split("(?=[+*])|(?<=[+*])"); // Split by + or *
        long result = Long.parseLong(parts[0]);
        for (int i = 1; i < parts.length; i += 2) {
            String operator = parts[i];
            long nextNum = Long.parseLong(parts[i + 1]);
            if (operator.equals("+")) {
                result += nextNum;
            } else if (operator.equals("*")) {
                result *= nextNum;
            }
        }
        return result;
    }

    public static class Calibration {
        private final Long result;

        private final List<Long> values;

        public Calibration(Long result, List<Long> values) {
            this.result = result;
            this.values = values;
        }

        @Override
        public String toString() {
            return result + " : " + values.stream().map(String::valueOf).collect(Collectors.joining(" "));
        }

        public Long getResult() {
            return result;
        }

    }
}
