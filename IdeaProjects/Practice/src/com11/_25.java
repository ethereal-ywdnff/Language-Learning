package com11;

public class _25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode a = head, b = head;
        for(int i = 0; i < k; i ++) {
            if(b == null) return head; // 整个链表不够 k 个，直接返回 head
            b = b.next; // a b 分组做反转
        }
        // [a, b) 做翻转操作
        // 在 Java 中，使用 var 关键字来定义变量是 Java 10 以后引入的一个特性，称为局部变量类型推断。使用 var 声明变量时，编译器会根据变量初始化时赋值的类型来推断变量的类型，这样可以简化代码书写，特别是在变量类型名字很长或很复杂时。
        var newHead = reverseFromAToB(a, b);
        a.next = reverseKGroup(b, k); // [b, ..) 递归翻转
        return newHead;
    }
    private static ListNode reverseFromAToB(ListNode a, ListNode b) {
        //每次把当前节点向后的链接反转（即向前链接）
        ListNode pre = null, cur = null;
        while(a != b) { //e.g. (1->2->3->4->5) a = 1    a = 2
            cur = a.next; // cur = 2    cur = 3
            a.next = pre; // 1.next = null (i.e. null <- 1)     2.next = 1 (i.e. null <- 1 <- 2)
            pre = a; // pre = 1     pre = 2
            a = cur; // a = 2     a = 3
        }
        return pre;
    }
}
