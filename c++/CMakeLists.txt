cmake_minimum_required(VERSION 3.17)
project(leetcode) # 工程名字，随你怎么叫都行

set(CMAKE_CXX_STANDARD 14)

add_executable(main main.cpp src/leetcode/bean/TreeNode.cpp src/leetcode/bean/TreeNode.h)
add_executable(235-LowestCommonAncestorOfABinarySearchTree src/leetcode/editor/cn/235-LowestCommonAncestorOfABinarySearchTree.cpp)
add_executable(46-Permutations src/leetcode/editor/cn/46-Permutations.cpp)
add_executable(70-ClimbingStairs src/leetcode/editor/cn/70-ClimbingStairs.cpp)
add_executable(122-BestTimeToBuyAndSellStockIi src/leetcode/editor/cn/122-BestTimeToBuyAndSellStockIi.cpp)
add_executable(455-AssignCookies src/leetcode/editor/cn/455-AssignCookies.cpp)
add_executable(127-WordLadder src/leetcode/editor/cn/127-WordLadder.cpp)
add_executable(200-NumberOfIslands src/leetcode/editor/cn/200-NumberOfIslands.cpp)
add_executable(1-TwoSum src/leetcode/editor/cn/1-TwoSum.cpp)
add_executable(81-SearchInRotatedSortedArrayIi src/leetcode/editor/cn/81-SearchInRotatedSortedArrayIi.cpp)
add_executable(33-SearchInRotatedSortedArray src/leetcode/editor/cn/33-SearchInRotatedSortedArray.cpp)
add_executable(153-FindMinimumInRotatedSortedArray src/leetcode/editor/cn/153-FindMinimumInRotatedSortedArray.cpp)
add_executable(874-WalkingRobotSimulation src/leetcode/editor/cn/874-WalkingRobotSimulation.cpp)