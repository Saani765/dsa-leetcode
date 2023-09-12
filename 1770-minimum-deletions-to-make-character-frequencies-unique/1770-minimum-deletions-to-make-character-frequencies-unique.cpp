class Solution {
public:
    int minDeletions(string s) {
        // Create an unordered map to count the frequency of each character.
        unordered_map<char, int> mp;

        // Iterate through the characters in the input string 's'.
        for (auto &it : s) {
            mp[it]++; // Increment the character's frequency in the map.
        }

        // Create a max-heap (priority queue) to store character frequencies in decreasing order.
        priority_queue<int> pq;

        // Populate the max-heap with character frequencies from the map.
        for (auto &it : mp) {
            pq.push(it.second);
        }

        // Initialize a variable to keep track of the minimum number of deletions needed.
        int count = 0;

        // Continue as long as there are at least two frequencies in the max-heap.
        while (pq.size() != 1) {
            int top = pq.top(); // Get the character frequency with the highest count.
            pq.pop(); // Remove it from the max-heap.

            // Check if the next character in the max-heap has the same frequency as 'top' (and it's not zero).
            if (pq.top() == top && top != 0) {
                count++; // Increment the deletion count.
                pq.push(top - 1); // Decrease 'top' frequency by 1 and push it back into the max-heap.
            }
        }

        // Return the minimum number of deletions required to make the string "good."
        return count;
    }
};