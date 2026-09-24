import java.util.*;
public class Task52_TopKFrequent {
    static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for (Map.Entry<Integer,Integer> e : map.entrySet()) {
            heap.offer(new int[]{e.getKey(), e.getValue()});
            if (heap.size() > k) heap.poll();
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) ans[i] = heap.poll()[0];
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println("Top K Frequent Elements = " + Arrays.toString(topKFrequent(nums,k)));
    }
}
