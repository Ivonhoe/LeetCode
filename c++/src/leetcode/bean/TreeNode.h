//
// Created by YangFan on 2020/11/9.
//

#ifndef LEETCODE_TREENODE_H
#define LEETCODE_TREENODE_H

#include "istream"

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


#endif //LEETCODE_TREENODE_H
