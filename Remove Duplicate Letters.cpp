class Solution {
public:
    std::string removeDuplicateLetters(std::string s) {
        std::stack<char> stack;
        std::unordered_set<char> seen;
        std::unordered_map<char, int> last_occ;
        for (int i = 0; i < s.size(); i++) {
            last_occ[s[i]] = i;
        }
        
        for (int i = 0; i < s.size(); i++) {
            char c = s[i];
            if (seen.find(c) == seen.end()) {
                while (!stack.empty() && c < stack.top() && i < last_occ[stack.top()]) {
                    seen.erase(stack.top());
                    stack.pop();
                }
                seen.insert(c);
                stack.push(c);
            }
        }
        
        std::string result = "";
        while (!stack.empty()) {
            result = stack.top() + result;
            stack.pop();
        }
        return result;
    }
};
