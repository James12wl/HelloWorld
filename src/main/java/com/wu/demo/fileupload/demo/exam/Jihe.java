package com.wu.demo.fileupload.demo.exam;

import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class Jihe {
    /*
    Collection
    1.List 必须保持元素特定的顺序
    2.Set 不能有重复元素  是无序的 判断两个对象相同用equals 不用==
    3.Queue 保持一个队列（先进先出）的顺序
    Map 一组成对的键值对对象
    Collection 每个位置只能保存一个元素（对象）
    Map 就像一个小型的数据库，保存的是键值对  我们可以通多键 找到该键对应的值
    List集合代表一个元素有序、可重复的集合，集合中每个元素都有其对应的顺序索引
     ArrayList是基于数组实现的List类，它封装了一个动态的增长的、允许再分配的Object[]数组。
     */

    public static void main(String args[]){

        //创建一个EnumMap对象 该EnumMap的所有key 必须是Season枚举类的枚举值
        EnumMap enumMap = new EnumMap(Season.class);
        enumMap.put(Season.SUMMER , "夏日炎炎");
        enumMap.put(Season.SPRING,"春暖花开");
        System.out.println(enumMap);


        IdentityHashMap ihm = new IdentityHashMap();
        ihm.put("语文" , 67);
        ihm.put("语文" , 89);

        ihm.put("java" , 97);
        ihm.put("java" , 98);
        System.out.println(ihm);

        WeakHashMap whm = new WeakHashMap();
        //将WeakHashMap中添加三个key-value对，
        //三个key都是匿名字符串对象（没有其他引用）
        whm.put(new String("语文") , new String("良好"));
        whm.put(new String("数学") , new String("及格"));
        whm.put(new String("英文") , new String("中等"));

        //将WeakHashMap中添加一个key-value对，
        //该key是一个系统缓存的字符串对象。"java"是一个常量字符串强引用
        whm.put("java" , new String("中等"));
        //输出whm对象，将看到4个key-value对。
        System.out.println(whm);
        //通知系统立即进行垃圾回收
        System.gc();
        System.runFinalization();
        //通常情况下，将只看到一个key-value对。
        System.out.println(whm);



        TreeMap tm = new TreeMap();
        tm.put(new R(3) , "轻量级Java EE企业应用实战");
        tm.put(new R(-5) , "疯狂Java讲义");
        tm.put(new R(9) , "疯狂Android讲义");

        System.out.println(tm);

        //返回该TreeMap的第一个Entry对象
        System.out.println(tm.firstEntry());

        //返回该TreeMap的最后一个key值
        System.out.println(tm.lastKey());

        //返回该TreeMap的比new R(2)大的最小key值。
        System.out.println(tm.higherKey(new R(2)));

        //返回该TreeMap的比new R(2)小的最大的key-value对。
        System.out.println(tm.lowerEntry(new R(2)));

        //返回该TreeMap的子TreeMap
        System.out.println(tm.subMap(new R(-1) , new R(4)));


    }



}

enum Season{
    SPRING,SUMMER,FALL,WINTER
}

class R implements Comparable {
    int count;

    public R(int count) {
        this.count = count;
    }

    public String toString() {
        return "R[count:" + count + "]";
    }

    //根据count来判断两个对象是否相等。
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null
                && obj.getClass() == R.class) {
            R r = (R) obj;
            return r.count == this.count;
        }
        return false;
    }

    //根据count属性值来判断两个对象的大小。
    public int compareTo(Object obj) {
        R r = (R) obj;
        return count > r.count ? 1 :
                count < r.count ? -1 : 0;
    }
}