package LinkedList;


import java.util.Random;

public class TestLinkedList {

    public static ListNode init(int n){
        int min = 1;
        int max = 10;
        if(n<1)return null;
        ListNode head = new ListNode(8);
        for(int i=1;i<n;i++){
            head.add(min + ((int) (new Random().nextFloat() * (max - min))));
        }
        return head;
    }
    public static ListNode initCircle(int n,int x){
        int min = 1;
        int max = 10;
        if(n<1||x>=n)return null;
        ListNode target = null;
        ListNode nodenow;
        ListNode head = new ListNode(8);
        nodenow=head;
        for(int i=1;i<n;i++){
            head.add(min + ((int) (new Random().nextFloat() * (max - min))));
        }

        int flage=1;
        while(nodenow.next!=null){
            nodenow=nodenow.next;
            if(flage!=x)flage++;
            else target=nodenow;
        }
        nodenow.next=target;
        return head;
    }


    public static void main(String[] s){
        Operations operations=new Operations();
        ListNode list1=init(10);
        ListNode List2=init(15);
        ListNode circle=initCircle(13,2);

        System.out.println(operations.hasCycle(circle));


    }
}
