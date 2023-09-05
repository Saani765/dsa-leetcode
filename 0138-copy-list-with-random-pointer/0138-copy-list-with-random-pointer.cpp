/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(!head) return nullptr;

        Node* original = head; // itr for original
        Node* cloned = nullptr; // itr for cloed
        Node* temp = nullptr; // temporary for node creation

        // First pass: clone nodes and link them next to origial
        while(original) {
            temp = new Node(original->val);
            temp->next = original->next;
            original->next=temp;
            original = temp->next;
        }

        original = head;
        Node* newHead = head->next;

        // Second pass: Assign random pointers to cloned nodes
        while(original) {
            if(original->random) {
                original->next->random = original->random->next;
            } else {
                original->next->random = nullptr;
            }
            original = original->next->next; // skip copy
        }
        
        original = head;

        // Third Pass: Seperate original and cloned 
        while(original) {
            temp = original->next; 
            original->next = temp->next; 
            original = original->next;

            if(original) {
                temp->next = original->next;
            } else {
                temp->next = nullptr;
            }
        }

    return newHead;
    }
};