package com.OOPday02.cn;

public class TestDriver {
    public static int transfer(QuoteTransfer quote) {
        quote.a = 888;
        return quote.a;
    }

    public static void main(String[] args) {
        ParaTransfer paraTransfer = new ParaTransfer();
        int a = 1;
        System.out.println("没有调用之前的a : " + a);
        System.out.println("调用的时候a : " + paraTransfer.transfer(a));
        System.out.println("没有调用之后的a : " + a);
        System.out.println("*****************************引用传递*******************************");
        QuoteTransfer quoteTransfer = new QuoteTransfer();
        System.out.println("QuoteTransfer 对象中的a ： " + quoteTransfer.a);
        int change = transfer(quoteTransfer);
        System.out.println("调用方法中的QuoteTransfer 对象中的a ： " + change);
        System.out.println("调用之后QuoteTransfer 对象中的a ： " + quoteTransfer.a);
    }
}
