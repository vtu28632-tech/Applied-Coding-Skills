import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[0] = true;
        queue.offer(0);
        int visitedCount = 1;

        while (!queue.isEmpty()) {
            int room = queue.poll();

            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    visitedCount++;
                    queue.offer(key);
                }
            }
        }

        return visitedCount == n;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2),
            Arrays.asList(3),
            Arrays.asList()
        );

        System.out.println(canVisitAllRooms(rooms)); // true
    }
}