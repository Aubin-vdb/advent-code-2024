import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Day6 {
    public static final int MATRIX_SIZE = 130;

    public static Position start;

    public static Map<String, Position> directions = Map.of(
            "N", new Position(-1, 0, "N"),
            "E", new Position(0, 1, "E"),
            "S", new Position(1, 0, "S"),
            "W", new Position(0, -1, "W")
    );

    public static void main(String[] args) {

        char[][] matrix = getMap();

        long result = getDistinctPositionBeforeLeavingMap(matrix);
        System.out.println("Result: " + result);
    }

    public static char[][] getMap() {
        char[][] matrix = new char[MATRIX_SIZE][MATRIX_SIZE];
        String filePath = "/Users/aubin/Downloads/map.txt";
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                for(int j = 0; j < line.length(); j++) {
                    matrix[i][j] = line.charAt(j);
                    if(line.charAt(j) == '^') {
                        start = new Position(i, j,"N");
                    }
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    public static long getDistinctPositionBeforeLeavingMap(char[][] matrix) {
        Position current = start;
        List<Position> visited = new ArrayList<>();
        while(current != null) {
            if(!visited.contains(current)) {
                visited.add(current);
            }
            Position next = getNextPosition(matrix, current);
            if(next == null) {
                break;
            }
            current = next;
        }
        return visited.size();
    }

    public static Position getNextPosition(char[][] matrix, Position current) {
        Position posDirection = directions.get(current.getDirection());
        // Stop iterations when I'm out of the map
        if(current.x + posDirection.x < 0 || current.x + posDirection.x >= MATRIX_SIZE || current.y + + posDirection.y < 0 || current.y + + posDirection.y >= MATRIX_SIZE) {
            return null;
        }
        // Obstacle --> turn right
        if(matrix[current.x + posDirection.x][current.y + posDirection.y] == '#') {
            String newDirection = turnRight(current.getDirection());
            Position newPosDirection = directions.get(newDirection);

            return new Position(current.x + newPosDirection.x, current.y + newPosDirection.y, newDirection);
        }
        // Otherwise move forward
        return new Position(current.x + posDirection.x, current.y + posDirection.y, current.getDirection());
    }
    
    public static String turnRight(String direction) {
        return switch (direction) {
            case "N" -> "E";
            case "E" -> "S";
            case "S" -> "W";
            case "W" -> "N";
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        };
    }

    public static class Position {
        public int x;
        public int y;
        public String direction;

        public Position(int x, int y, String direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public String getDirection() {
            return direction;
        }

        @Override
        public boolean equals(Object obj) {
            return this.x == ((Position) obj).x && this.y == ((Position) obj).y;
        }

    }
}
