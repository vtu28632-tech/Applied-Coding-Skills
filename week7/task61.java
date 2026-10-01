import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Task61 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];


        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }

        int[] order = new int[numCourses];
        int count = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[count++] = course;

            for (int next : graph.get(course)) {
                if (--indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return count == numCourses ? order : new int[0];
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }
}