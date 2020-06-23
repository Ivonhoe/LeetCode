package ivonhoe.java.leetcode.core;

/**
 * 字符串的排列 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 
 * 示例1:
 * 
 * 输入: s1 = "ab" s2 = "eidbaooo" 输出: True 解释: s2 包含 s1 的排列之一 ("ba").
 * 
 * 
 * 示例2:
 * 
 * 输入: s1= "ab" s2 = "eidboaoo" 输出: False
 * 
 * 注意：
 * 
 * 输入的字符串只包含小写字母 两个字符串的长度都在 [1, 10,000] 之间
 */
class Solution {
    /**
     * 字符串长度为1~1W之间，不能选择全排序的方式获得所有s2的所有排序字符串 使用滑动窗口的概念
     * https://www.cnblogs.com/MrSaver/p/9638279.html
     * 
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] numList1 = new int[26];
        int[] numList2 = new int[26];

        for (int i = 0; i < s2.length(); i++) {

        }
        return true;
    }

    /**
     * 全组合
     * 
     * https://www.cnblogs.com/lifegoesonitself/p/3225803.html
     * 
     * 求全组合，则假设原有元素n个，则最终组合结果是2^n个
     * 用位操作方法：假设元素原本有：a,b,c三个，则1表示取该元素，0表示不取。故去a则是001，取ab则是011.
     * 所以一共三位，每个位上有两个选择0,1.所以是2^n个结果。
     * 这些结果的位图值都是0,1,2....2^n。所以可以类似全真表一样，从值0到值2^n依次输出结果：即：
     * 000,001,010,011,100,101,110,111 。对应输出组合结果为： 空,a, b ,ab,c,ac,bc,abc.
     * 这个输出顺序刚好跟数字0~2^n结果递增顺序一样 取法的二进制数其实就是从0到2^n-1的十进制数
     */
    public void combination() {
        String[] str = { "a", "b", "c" };
        int n = str.length;
        int nbit = 1 << n;
        for (int i = 0; i < nbit; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                int temp = 1 << j;
                if ((temp & i) != 0) {
                    sb.append(str[j]);
                }
            }
            System.out.println(sb);
        }
    }

    /**
     * 全排列
     * 
     * https://www.cnblogs.com/lifegoesonitself/p/3225803.html
     * 
     * 递归：
     * 
     * 从集合中依次选出每一个元素，作为排列的第一个元素，然后对剩余的元素进行全排列，如此递归处理，
     * 从而得到所有元素的全排列。以对字符串abc进行全排列为例，我们可以这么做：以abc为例：
     * 固定a，求后面bc的排列：abc，acb，求好后，a和b交换，得到bac 固定b，求后面ac的排列：bac，bca，求好后，c放到第一位置，得到cba
     * 固定c，求后面ba的排列：cba，cab。
     * 
     * @param str
     * @param result
     * @param len
     */
    public void permutation(String str, String result, int len) {
    }
}