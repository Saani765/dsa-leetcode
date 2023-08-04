class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) {
			return false;
		}

		int len = s.length();
		boolean[] dp = new boolean[len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j <= i; j++) {
				
				if (j == 0 || dp[j - 1]) {
					String sub = s.substring(j, i + 1);
					if (wordDict.contains(sub)) {
						dp[i] = true;
					}
				}
			}
		}
		return dp[len - 1];
    }
}