/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (40.28%)
 * Likes:    6336
 * Dislikes: 0
 * Total Accepted:    873.8K
 * Total Submissions: 2.2M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 
 * 题目数据保证列表表示的数字不含前导零
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
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = getLength(l1);
        int length2 = getLength(l2);
        
        ListNode p = l1,q = l2;
        // 短的后面补零
        if(length1>length2){
           addZero(l2, length1-length2);
        }else if(length1<length2){
           addZero(l1, length2-length1);
        }
        ListNode ans = new ListNode();
        ListNode k = ans;
        int plus = 0;
        while(p!=null&&q!=null){
            int number = plus+p.val+q.val;
            if(number>=10){
                number = number%10;
                plus = 1;
            }else{
                plus = 0;
            }
            p = p.next;
            q = q.next;

            ListNode node = new ListNode(number);
            k.next = node;
            k = k.next;
        }
        // 检查最后的进位
        if(plus>0){
            k.next = new ListNode(1);
        }
        return ans.next;
    }

    private ListNode addZero(ListNode node, int count){
        ListNode ans = node;
        while(node.next!=null){
            node= node.next;
        }
        while(count>0){
            node.next = new ListNode(0);
            node = node.next;
            count--;
        }
        return ans;
    }

    private int getLength(ListNode node){
        int ans = 0;
        while(node!=null){
            node = node.next;
            ans++; 
        }
        return ans;
    }
}
// @lc code=end

