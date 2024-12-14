import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class Day9 {

    public static final String FREE_SPACE = ".";

    public static void main(String[] args) {
        String input = getInput();
        List<String> representation = getRepresentation(input);
        System.out.println(String.join("", representation));

        List<String> cleanRep = getRepresentationWithoutFreeSpace(representation);
        System.out.println(String.join("", cleanRep));

        long total = computeCheckSum(cleanRep);
        System.out.print("Checksum :  " + total);

    }

    public static String getInput() {
        StringBuilder input =  new StringBuilder();
        String filePath = "/Users/aubin/Downloads/filesystem.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input.toString();
    }

    public static long computeCheckSum(List<String> input) {
        long total = 0;
        for(int i = 0; i < input.size(); i++) {
            total += i * Long.parseLong(input.get(i));
        }
        return total;
    }

    public static List<String> getRepresentation(String input) {
        List<String> rep = new ArrayList<>();
        long id = 0;
        for(int i = 0; i < input.length(); i++) {
            String character = i%2 == 0 ? String.valueOf(id++) : FREE_SPACE;
            int repeat = Character.getNumericValue(input.charAt(i));
            for(int j = 0 ; j < repeat; j++)
                rep.add(character);
        }
        return rep;
    }

    public static List<String> getRepresentationWithoutFreeSpace(List<String> input) {
        List<String> repClean = new ArrayList<>(input);
        while(repClean.contains(FREE_SPACE)) {
            repClean = fillOneEmptySpace(repClean);
        }
        return repClean;
    }

    public static List<String> fillOneEmptySpace(List<String> input) {
        int index = input.indexOf(FREE_SPACE);
        if(index < 0) return input;
        int indexId = getHighestIdIndex(input);
        return IntStream.range(0, indexId).
                mapToObj(i -> {
                    if(i == index)
                        return input.get(indexId);
                    else return input.get(i);
                }).
                toList();
    }

    public static int getHighestIdIndex(List<String>  input) {
        for(int i = input.size()-1 ; i>=0; i--) {
            if(!input.get(i).equals(FREE_SPACE)) return i;
        }
        return -1;
    }
}
