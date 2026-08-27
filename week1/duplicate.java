import java.util.HashSet;
import java.util.Set;
class Duplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {
                return true;
            }
            
            window.add(nums[i]);
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        
        return false;
    }
    public static void main(String[] args) {
        Duplicate d = new Duplicate();
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(d.containsNearbyDuplicate(nums, k));
    }
}
