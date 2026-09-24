import java.util.*;
public class Task53_KPairsSmallestSums {
    static List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (a.length == 0 || b.length == 0 || k == 0) return ans;
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (x,y) -> Integer.compare(a[x[0]] + b[x[1]], a[y[0]] + b[y[1]]));
        for (int i = 0; i < Math.min(k,a.length); i++) heap.offer(new int[]{i,0});
        while (!heap.isEmpty() && ans.size() < k) {
            int[] p = heap.poll();
            int i = p[0], j = p[1];
            ans.add(Arrays.asList(a[i], b[j]));
            if (j + 1 < b.length) heap.offer(new int[]{i,j+1});
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        System.out.println("K Smallest Pairs = " + kSmallestPairs(nums1,nums2,k));
    }
}
