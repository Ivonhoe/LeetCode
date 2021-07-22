/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
 *
 * https://leetcode-cn.com/problems/odd-even-linked-list/description/
 *
 * algorithms
 * Medium (65.64%)
 * Likes:    443
 * Dislikes: 0
 * Total Accepted:    117.6K
 * Total Submissions: 179.2K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 
 * 
 * 示例 2:
 * 
 * 输入: 2->1->3->5->6->4->7->NULL 
 * 输出: 2->3->6->7->1->5->4->NULL
 * 
 * 说明:
 * 
 * 
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode ans = head;
        ListNode p = head;
        ListNode q = head.next;
        ListNode half = q;
        // p,q交替向后，指向next.next节点，最后将两个链表拼接在一起
        while(p!=null||q!=null){
            if(p!=null){
                if(p.next!=null){
                    p.next = p.next.next;
                }
                p = p.next;
            }
            if(q!=null){
                if(q.next!=null){
                    q.next = q.next.next;
                }
                q = q.next;
            }
        }
        // 找到奇数节点的末尾
        ListNode k = ans;
        while(k!=null && k.next!=null){
            k=k.next;
        }
        k.next = half;
        return ans;
    }
}
// @lc code=end

