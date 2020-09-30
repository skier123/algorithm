package leetcode;

import LinkedList.ListNode;
/**
 * Copyright (C), 2020-2020, Qinghao Sun
 * Author: Sun Qinghao
 * Date: 2020/9/30 9:14 下午
 * FileName: AddNum_2
 * Description: LeetCode_2 two sum
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 解题思路：
 * 因为两个数字相加会产生进位，所以使用i来保存进位。
 * 则当前位的值为(l1.val + l2.val + i) % 10
 * 则进位值为(l1.val + l2.val + i) / 10
 * 建立新node，然后将进位传入下一层。
 *
 * 或者说：递归总是返回当前节点，并将当前节点的next连接到下一次，即更高节点
 *
 * 作者：dnanki
 * 链接：https://leetcode-cn.com/problems/add-two-numbers/solution/di-gui-si-lu-jian-dan-dai-ma-duan-by-dnanki/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class AddNum_2 {


        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return dfs(l1, l2, 0);
        }

        ListNode dfs(ListNode l, ListNode r, int i) {
            if (l == null && r == null && i == 0) return null;//均为空，执行完毕，返回空
            //A ？ B：C ，意思就是如果A为真执行B，否则执行C
            int sum = (l != null ? l.val : 0) + (r != null ? r.val : 0) + i;
            ListNode node = new ListNode(sum % 10);
            //下一个,即为更高位，重复执行
            node.next = dfs(l != null ? l.next : null, r != null ? r.next : null, sum / 10);
            return node;//返回当前的节点
        }





}
