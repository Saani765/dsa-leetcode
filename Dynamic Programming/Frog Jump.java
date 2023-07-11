import java.util.*;
class Solution {
    private int n;
    private List<Integer> jumps = Arrays.asList(-1, 0, 1);
    private Map<String, Integer> hashMap = new HashMap<>();
    
    private int binarySearch(List<Integer> nums, int l, int r, int key) {
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (key < nums.get(mid)) {
                r = mid - 1;
            } else if (key > nums.get(mid)) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    
    private boolean solve(List<Integer> nums, int i, int prev) {
        if (i >= n) {
            return false;
        }
        if (i == n - 1) {
            return true;
        }
        String key = i + "_" + prev;
        if (hashMap.containsKey(key)) {
            return hashMap.get(key) == 1;
        }
        int curr = nums.get(i);
        for (int t : jumps) {
            int jump = prev + t;
            int j = binarySearch(nums, i + 1, n - 1, curr + jump);
            if (j == -1) {
                continue;
            }
            if (solve(nums, j, jump)) {
                hashMap.put(key, 1);
                return true;
            }
        }
        hashMap.put(key, 0);
        return false;
    }
    
    public boolean canCross(int[] arr) {
         ArrayList<Integer> stones = new ArrayList<>();

        for (int stone : arr) {
            stones.add(stone);
        }
        if (stones.get(1) > 1) {
            return false;
        }
        n = stones.size();
        hashMap.clear();
        return solve(stones, 1, 1);
    }
}