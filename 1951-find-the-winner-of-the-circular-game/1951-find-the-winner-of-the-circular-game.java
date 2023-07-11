class Solution {
    static int solve(int n, int k) {
	    /* if there is only one friend left */
        if (n == 1)
            return 0; 
        return (solve(n - 1, k) + k) % n;
    }
    public int findTheWinner(int n, int k) {
         return solve(n, k) + 1;
    }
}