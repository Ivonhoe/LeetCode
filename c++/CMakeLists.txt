cmake_minimum_required(VERSION 3.17)
project(leetcode) # 工程名字，随你怎么叫都行

set(CMAKE_CXX_STANDARD 14)

add_executable(main main.cpp src/leetcode/bean/TreeNode.cpp src/leetcode/bean/TreeNode.h)
add_executable(235-LowestCommonAncestorOfABinarySearchTree src/leetcode/editor/cn/235-LowestCommonAncestorOfABinarySearchTree.cpp)
add_executable(46-Permutations src/leetcode/editor/cn/46-Permutations.cpp)