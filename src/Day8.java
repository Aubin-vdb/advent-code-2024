import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day8 {

    public static void main(String[] args) {
        AntennaMap antennaMap = getAntennasMap();
        List<Position> antinodes = getAntinodes(antennaMap, true);
        System.out.println("Result antinodes: " + antinodes.size());
    }

    public static AntennaMap getAntennasMap() {
        char[][] matrix = new char[50][50];
        Map<String, List<Position>> antennas = new HashMap<>();
        String filePath = "/Users/aubin/Downloads/antennas.txt";
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                for(int j = 0; j < line.length(); j++) {
                    matrix[i][j] = line.charAt(j);
                    if(line.charAt(j) != '.') {
                        antennas.computeIfAbsent(String.valueOf(line.charAt(j)), _ -> new ArrayList<>()).add(new Position(i, j));
                    }
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new AntennaMap(matrix, antennas);
    }

    public static List<Position> getAntinodes(AntennaMap antennaMap, boolean part2) {
        List<Position> distinctAntinodes = new ArrayList<>();
        for(Map.Entry<String, List<Position>> entry : antennaMap.antennas.entrySet()) {
            List<Position> positions = entry.getValue();
            // Each antenna is an antinode in part 2
            if(part2) {
                positions.forEach(p -> addAntinode(distinctAntinodes, p));
            }
            for(int i = 0; i < positions.size(); i++) {
                Position current = positions.get(i);
                for(int j = i+1; j < positions.size(); j++) {
                    Position previous = positions.get(j);
                    if(current.equals(previous)) continue;

                    computeAntinodes(current, previous, distinctAntinodes, antennaMap, part2);
                }
            }
        }
        return distinctAntinodes;
    }

    public static void addAntinode(List<Position> antinodes, Position antinode) {
        if(!antinodes.contains(antinode)) {
            antinodes.add(antinode);
        }
    }

    public static void computeAntinodes(Position current, Position previous, List<Position> distinctAntinodes, AntennaMap antennaMap, boolean part2) {
        int diffXAbs = Math.abs(current.x - previous.x);
        int diffYAbs = Math.abs(current.y - previous.y);
        int diffX = current.x - previous.x;
        int diffY = current.y - previous.y;

        Position antinode1 = new Position();
        Position antinode2 = new Position();
        if(current.x < previous.x) {
            antinode1.setX(current.x - diffXAbs);
            antinode2.setX(previous.x + diffXAbs);
        } else {
            antinode1.setX(current.x + diffXAbs);
            antinode2.setX(previous.x - diffXAbs);
        }
        if(current.y < previous.y) {
            antinode1.setY(current.y - diffYAbs);
            antinode2.setY(previous.y + diffYAbs);
        } else {
            antinode1.setY(current.y + diffYAbs);
            antinode2.setY(previous.y - diffYAbs);
        }
        while (isValidPosition(antinode1, antennaMap.matrix)) {
            addAntinode(distinctAntinodes, antinode1);
            if(!part2) break;
            antinode1 = new Position(antinode1.x + diffX, antinode1.y + diffY);
        }
        while(isValidPosition(antinode2, antennaMap.matrix)) {
            addAntinode(distinctAntinodes, antinode2);
            if(!part2) break;
            antinode2 = new Position(antinode2.x - diffX, antinode2.y - diffY);
        }
    }

    public static boolean isValidPosition(Position position, char[][] matrix) {
        return position != null && position.x >= 0 && position.x < matrix.length && position.y >= 0 && position.y < matrix[0].length;
    }

    public static class AntennaMap {
        public char[][] matrix;
        public Map<String, List<Position>> antennas;

        public AntennaMap(char[][] matrix, Map<String, List<Position>> antennas) {
            this.matrix = matrix;
            this.antennas = antennas;
        }
    }

    public static class Position {
        public int x;
        public int y;

        public Position() {}

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Position && this.x == ((Position) obj).x && this.y == ((Position) obj).y;
        }

    }
}
