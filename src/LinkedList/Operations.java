package LinkedList;

public class Operations {

    //是否有环，用两个一快一慢的区找，如果相会则为有环
    public boolean hasCycle(ListNode head) {

        ListNode slowerNode = head;
        ListNode fasterNode = head;

        while ( slowerNode != null && fasterNode != null && fasterNode.next != null ){

            slowerNode = slowerNode.next;
            fasterNode = fasterNode.next.next;

            if (slowerNode == fasterNode){
                return true;
            }
        }

        return false;
    }

    //两个链表的交点
    //          o o o o o
    //                    o o o o o o o
    //              o o o
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lengthA = _calculateLinkedListLength(headA);
        int lengthB = _calculateLinkedListLength(headB);

        int n = lengthA - lengthB;

        ListNode pA = headA;
        ListNode pB = headB;
        //较为长的链表移动差值个点
        for ( int i = 0; i < Math.abs(n); i++){

            if (n > 0){
                pA = pA.next;
            }else {
                pB = pB.next;
            }
        }
        //在剩下的点中依次查找是否相同
        while (pA != null && pB != null){

            if ( pA == pB ){
                return pB;
            }

            pA = pA.next;
            pB = pB.next;
        }

        return null;

    }

    //计算长度
    private static int _calculateLinkedListLength( ListNode head ){

        int count = 0;

        while ( head != null ){

            count ++;

            head = head.next;
        }

        return count;
    }

    //反转列表
    public static ListNode reverseList(ListNode head) {

        ListNode preNode = null;
        ListNode curNode = head;
        //当未遍历到当前节点为空时，记录下一个节点，当前节点指向前节点，前节点成为当前节点当前节点为下一节点
        while ( curNode != null ){

            ListNode nextNode = curNode.next;
            //反转指向
            curNode.next = preNode;
            preNode = curNode;
            //节点移动
            curNode = nextNode;
        }

        return preNode;
    }

    //合并列表（有序）
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //若其中一个为空，返回两者不空的那个
        if ( l1 == null ){
            return l2;
        }

        if ( l2 == null ){
            return l1;
        }

        ListNode mergedNode = null;

        if ( l1.val < l2.val ){
            //数值小的那个为返回节点，下一个节点为剩下两个的进行该算法的返回
            mergedNode = l1;
            mergedNode.next = mergeTwoLists(mergedNode.next, l2);

        }else{

            mergedNode = l2;
            mergedNode.next = mergeTwoLists(l1, mergedNode.next);
        }

        return mergedNode;
    }


    public static ListNode FindKthToTail(ListNode pListHead,  int k) {


        if (pListHead == null){
            return null;
        }

        ListNode pHead = pListHead;
        ListNode pBehind = null;

        for ( int i = 0; i < k -1; i++){

            if (pHead.next != null){
                pHead = pHead.next;
            }else {
                return null;
            }
        }

        pBehind = pListHead;

        while(pHead.next != null){
            pHead = pHead.next;
            pBehind = pBehind.next;
        }

        return pBehind;
    }
    //倒顺序打印 递归，先递归再打印
    public static void PrintListReversingly(ListNode pHead)
    {
        if(pHead != null)
        {
            if (pHead.next != null)
            {
                PrintListReversingly(pHead.next);
            }

            System.out.println(pHead.val);
        }
    }

    //删除后数第n个
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if( head == null || head.next == null){
            return null;
        }

        ListNode firstNode = head;
        ListNode secondNode = head;
        //向头节点下走n个
        for(int i = 0; i < n; i++){
            firstNode = firstNode.next;
        }

        // 如果空，返回头节点的下一个节点（删除第一个节点）
        if(firstNode == null){
            return head.next;
        }
        //如果头节点仍有下一个节点，头节点下移，第二个阶段下移，此时两节点永远相差n，知道头节点空
        while(firstNode.next != null)
        {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        //头节点空则条件达成，此时second节点的下一个为删除节点
        secondNode.next = secondNode.next.next;

        return head;

    }

    public void deleteNode(ListNode node) {

        if ( node == null || node.next == null)  {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }


    public ListNode deleteDuplicates(ListNode head) {


        if ( head == null || head.next == null){
            return head;
        }

        ListNode curNode = head;

        while (curNode.next != null){

            if (curNode.val == curNode.next.val){

                //delNode is the node to delete
                ListNode delNode = curNode.next;
                curNode.next = delNode.next;

            } else{

                curNode = curNode.next;

            }
        }

        return head;

    }

    public ListNode deleteAllDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode cur = head;

        while (cur != null) {

            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            if (pre.next == cur) {
                //pre is next to cur
                pre = pre.next;

            } else {

                pre.next = cur.next;

            }
            //move cur
            cur = cur.next;
        }
        return fakeHead.next;
    }

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode cur = dummyHead;

        while (cur.next != null){

            if (cur.next.val == val){

                ListNode delNode = cur.next;
                cur.next = delNode.next;

            } else{

                cur = cur.next;

            }
        }

        ListNode returnNode = dummyHead.next;

        return returnNode;
    }


    public ListNode partition(ListNode head, int x) {


        if (head == null || head.next == null){
            return head;
        }

        ListNode left = new ListNode(-1);
        ListNode p = left;

        ListNode right = new ListNode(-1);
        ListNode q = right;

        while(head != null){

            if( head.val < x){

                p.next = head;
                p = p.next;

            }else{

                q.next = head;
                q = q.next;
            }

            head = head.next;
        }

        q.next = null; //right end
        p.next = right.next;//left end
        return left.next;


    }


    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode left = new ListNode(-1);
        ListNode p = left;

        ListNode right = new ListNode(-1);
        ListNode q = right;

        int index = 1;

        while( head != null ){

            if(__partitionCondition(index)){

                p.next = head;
                p = p.next;

            }else{
                q.next = head;
                q = q.next;
            }

            head = head.next;

            index++;
        }

        q.next = null; //right end
        p.next = right.next;//left end
        return left.next;
    }

    private boolean __partitionCondition(int val){

        if (val % 2 == 1){
            return true;
        } else {
            return false;
        }
    }


}
