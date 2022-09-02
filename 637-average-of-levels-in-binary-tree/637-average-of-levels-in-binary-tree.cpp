/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<double> averageOfLevels(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);
        vector<TreeNode*> level;
        vector<double> averageOfLvls;
        while(!q.empty())
        {
            auto node=q.front();
            q.pop();
            if(node)
            {
                level.push_back(node);
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            else
            {
                double total=0;
                for(auto n:level)
                {
                    total+=(double)n->val;
                }
                double avg=total/level.size();
                averageOfLvls.push_back(avg);
                if(!q.empty())
                    q.push(NULL);
                level.clear();
            }
        }
        return averageOfLvls;        
    }
};