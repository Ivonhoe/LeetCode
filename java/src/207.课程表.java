/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 *
 * https://leetcode-cn.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (54.62%)
 * Likes:    915
 * Dislikes: 0
 * Total Accepted:    134.7K
 * Total Submissions: 247.1K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi]
 * ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 
 * 
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 
 * 
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 
 * 示例 2：
 * 
 * 
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * prerequisites[i].length == 2
 * 0 i, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 * 
 * 
 */

// @lc code=start

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            return true;
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
                return false;
            }
            
            
            nodeList.get(ancestorIndex).addSuccessor(nodeList.get(successorIndex));
        }

        DirectedGraphWalker walker = new DirectedGraphWalker(nodeList);
        return walker.findCycle() == null;
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
            // Logger.log(it.getName());
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

