/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 *
 * https://leetcode-cn.com/problems/course-schedule-ii/description/
 *
 * algorithms
 * Medium (53.54%)
 * Likes:    459
 * Dislikes: 0
 * Total Accepted:    84.6K
 * Total Submissions: 156.3K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * 
 * 示例 1:
 * 
 * 输入: 2, [[1,0]] 
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 
 * 示例 2:
 * 
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 
 * 
 * 说明:
 * 
 * 
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 
 * 
 * 提示:
 * 
 * 
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 
 * 拓扑排序也可以通过 BFS 完成。
 * 
 * 
 * 
 */

// @lc code=start



class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        
        if(prerequisites == null){
            return new int[0];
        }

        List<TaskNode> nodeList = new ArrayList<TaskNode>();
        for(int i=0;i<numCourses;i++){
           TaskNode node = new TaskNode(i);
           nodeList.add(node); 
        }

        for(int i=0;i<prerequisites.length;i++){
            int ancestorIndex = prerequisites[i][1];
            int successorIndex = prerequisites[i][0];
            if(ancestorIndex == successorIndex){
                return new int[0];
            }
            
            nodeList.get(ancestorIndex).addSuccessor(nodeList.get(successorIndex));
        }
        
        
        DirectedGraphWalker walker = new DirectedGraphWalker(nodeList);
        List<TaskNode> ansList = walker.findValues();
        if(ansList.size()!=numCourses){
            return new int[0];
        }
        for(int i=0;i<ansList.size();i++){
            ans[i] = ansList.get(i).value;
        }
        
        return ans;
    }
    
    public static class TaskNode{

        int value;

        /**
        * 前驱的节点 A->B，必须A先执行B后执行，则B的mAncestor包含A
        */
        private List<TaskNode> mAncestor;

        /**
        * 后继节点 A->B，必须A先执行B后执行，则A的mDescendent包含B
        */
        private List<TaskNode> mSuccessor;

        public TaskNode(int value){
            this.value = value;
            this.mAncestor = new ArrayList<TaskNode>();
            this.mSuccessor = new ArrayList<TaskNode>();
        }

        public void addAncestor(TaskNode node){
            if(mAncestor.contains(node)||this==node){
                return;
            }
            mAncestor.add(node);
        }

        public void addSuccessor(TaskNode node){
            if(mSuccessor.contains(node)||this==node){
                return;
            }

            mSuccessor.add(node);
        }

        public List<TaskNode> getSuccessor(){
            return mSuccessor;
        }
    }

    private static class NodeDetail {
        private final TaskNode node;
        private int dfn = 0;
        private int low = 0;

        private NodeDetail(TaskNode task) {
            node = task;
        }
    
    }

    public static class DirectedGraphWalker {

    private List<TaskNode> nodeList;
    private List<NodeDetail> cachingNodeDetail = new ArrayList<>();
    private Map<TaskNode, NodeDetail> nodeDetailMap = new HashMap<>();
    private List<TaskNode> cycle = new ArrayList<>();
    private List<TaskNode> values = new ArrayList<>();

    public DirectedGraphWalker(List<TaskNode> nodes) {
        if (nodes == null) {
            return;
        }
        nodeList = nodes;
        for (TaskNode it : nodeList) {
            NodeDetail detail = new NodeDetail(it);
            cachingNodeDetail.add(detail);
            nodeDetailMap.put(it, detail);
        }
    }

    /**
     * targan
     */
    private List<TaskNode> doSearch() {
        cycle.clear();
        values.clear();
        int time = 0;
        Deque<NodeDetail> stack = new LinkedList<>();

        for (int i = 0; i < cachingNodeDetail.size(); i++) {
            NodeDetail nodeDetail = cachingNodeDetail.get(i);
            if (nodeDetail.dfn == 0) {
                boolean findCycle = targan(stack, nodeDetail, time, values);
                if (findCycle) {
                    return null;
                }
            }
        }

        Collections.reverse(values);
        for (TaskNode it : cycle) {
            System.out.println(it.value);
        }
        return values;
    }

    /**
     * targan算法求强连通分量
     */
    private boolean targan(Deque<NodeDetail> stack, NodeDetail current, int time, List<TaskNode> ans) {
        stack.push(current);
        current.dfn = current.low = ++time;

        List<TaskNode> children = current.node.getSuccessor();
        for (int y = 0; y < children.size(); y++) {
            TaskNode desc = children.get(y);
            if(current.node == desc){
                return true;
            }
            NodeDetail descDetail = nodeDetailMap.get(desc);
            if (descDetail.dfn == 0) {
                boolean findCycle = targan(stack, descDetail, time, ans);
                current.low = Math.min(current.low, descDetail.low);
            } else if (stack.contains(descDetail)) {
                current.low = Math.min(current.low, descDetail.dfn);
            }
        }

        if (current.low == current.dfn) {
            List<TaskNode> strongConnection = new ArrayList<>();
            while (true) {
                NodeDetail detail = stack.pop();
                strongConnection.add(detail.node);
                if (detail == current) {
                    break;
                }
            }
            if (strongConnection.size() > 1) {
                cycle.addAll(strongConnection);
                return true;
            } else {
                ans.addAll(strongConnection);
            }
        }
        return false;
    }

    public List<TaskNode> findValues() {
        doSearch();
        return values;
    }

    public List<TaskNode> findCycle() {
        doSearch();
        if (cycle.size() > 1) {
            return cycle;
        }
        return null;
    }

}
}
// @lc code=end

