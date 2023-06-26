class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int sum = Arrays.stream(rods).sum();
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int x : rods) {
            int[] cur = dp.clone();
            for (int d = 0; d + x <= sum; d++) {
                if (cur[d] < 0)
                    continue;
                dp[d + x] = Math.max(dp[d + x], cur[d]);
                dp[Math.abs(d - x)] = Math.max(dp[Math.abs(d - x)], cur[d] + Math.min(d, x));
            }
        }
        return dp[0];
    }
}