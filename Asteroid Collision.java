class Solution {
    public int[] asteroidCollision(int[] a) {
        int top = -1;
        for (int x : a) {
            boolean stillAlive = true; // new guys is still alive
            while (stillAlive && x < 0 && top >= 0 && a[top] > 0) {
                stillAlive = a[top] + x < 0;
                if (a[top] + x <= 0) top--; // die young or die together
            }
            if (stillAlive) a[++top] = x; // if new guys is still alive, put it on top of stack
        }
        
        return Arrays.copyOf(a, top+1);
    }
}