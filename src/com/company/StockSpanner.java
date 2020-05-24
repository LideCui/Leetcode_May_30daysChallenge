package com.company;

import java.util.Stack;

/*
Use a double linked list
 */
public class StockSpanner {

//    /*
//    pass all tests but take too long
//     */
//    int data;
//    StockSpanner next;
//    StockSpanner prev;
//
//    public StockSpanner() { //create head
//        int val = -1;
//    }
//
//    public StockSpanner(int v) {
//        int data = v;
//        StockSpanner prev = null;
//        StockSpanner next = null;
//    }
//
//    StockSpanner head;
//
//    public int next(int price) {
//        StockSpanner st = new StockSpanner(price);
//        st.data = price;
//        st.next = null;
//
//        StockSpanner ptr = head;
//        if(head==null) {
//            st.prev = null;
//            head = st;
//            return 1;
//        }
//
//        while(ptr.next!=null){
//            ptr = ptr.next;
//        }
//        ptr.next = st;
//        st.prev = ptr;
//
//        int days = 1;
//        while(ptr!=null){
//            //System.out.println("ptr.data"+ptr.data);
//            if(ptr.data>price) break;
//            days++;
//            ptr=ptr.prev;
//        }
//
//        return days;
//    }

    //instead stack is a better way
    Stack<int[]> pairs;

    public StockSpanner() {
        pairs = new Stack();
    }

    public int next(int price) {
        int days = 1;
        int[] pair = new int[2];
        pair[0] =price;
        pair[1] = days;
        while (!pairs.isEmpty() && pairs.peek()[0] <= price) {
            days+=pairs.pop()[1];
        }
        pair[1]=days;

        pairs.push(pair);return days;
    }

    private int[] pricesStack;
    private int[] spansStack;
    private int top;

//    public StockSpanner() {
//        pricesStack = new int[10000];
//        spansStack = new int[10000];
//        top = -1;
//    }
//
//    public int next(int price) {
//        int span = 1;
//        while (0 <= top && pricesStack[top] <= price) {
//            span += spansStack[top--];
//        }
//        top++;
//        pricesStack[top] = price;
//        spansStack[top] = span;
//        return span;
//    }
}
