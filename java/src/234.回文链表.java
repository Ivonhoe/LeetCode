/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (48.05%)
 * Likes:    1051
 * Dislikes: 0
 * Total Accepted:    275.4K
 * Total Submissions: 565.8K
 * Testcase Example:  '[1,2,2,1]'
 *
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2
 * 输出: false
 * 
 * 示例 2:
 * 
 * 输入: 1->2->2->1
 * 输出: true
 * 
 * 
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
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
    // 1. 转成数组,用收尾指针判断是否是回文数组
    // 2. 翻转链表，但是如果空间复杂度O(1)，只能翻转链表后半部分
    // 3. 用栈,空间复杂度不是O(1)
    public boolean isPalindrome(ListNode head) {
        ListNode half = endOfFirstHalf(head);
        ListNode startOfReverseHalf = reverseList(half.next);

        ListNode p = head;
        ListNode q = startOfReverseHalf;
        while(q!=null){
            if(p.val != q.val){
                return false;
            }
            p = p.next;
            q = q.next;
        }

        return true;
    }

    // 翻转链表    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // 找到链表中点
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
// @lc code=end

