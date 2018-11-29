package com.wu.demo.fileupload.demo.exam;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookCompare implements Comparable {
    private String name;
    private float price;
    private String press;
    private String author;

    //构造方法
    public BookCompare(String name, float price, String press, String author) {
        this.name = name;
        this.price = price;
        this.press = press;
        this.author = author;
        System.out.println(name.toString());
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<BookCompare> list = new ArrayList<BookCompare>();
        BookCompare b1 = new BookCompare("java1", 25f, "不错的书", "LY1");
        BookCompare b2 = new BookCompare("java2", 26f, "不错的书", "LY2");
        BookCompare b3 = new BookCompare("java3", 50f, "不错的书", "LY3");
        BookCompare b4 = new BookCompare("java4", 20f, "不错的书", "LY4");
        BookCompare b5 = new BookCompare("java5", 15f, "不错的书", "LY5");
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            BookCompare book = (BookCompare) list.get(i);
            System.out.println(book);
        }
    }

    public int compareTo(Object obj) {
        BookCompare p = (BookCompare)obj;
        if(p.price>this.price){
            return 1;
        }
        else if(p.price<this.price){
            return -1;
        }
        else{
            return 0;
        }
    }
    //重写toString方法
    public String toString(){//这上是重写了本类的toString方法,对系统自带的其它字段的toString方法无效
        return "书名："+this.name+", 价格："+this.price+", 说明："+this.press+", 作者: "+this.author;
    }
}
//.sort(List)方法,当然还可能使用java.util.Arrays.sort(数组),那样就必须把//list转化为数组,由于本例使用Collections.sort(List)已经足够,另一方法,大家可//以尝试自已使用.


