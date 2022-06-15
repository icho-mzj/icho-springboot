package com.icho.base;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: icho
 * @Date: 2022/5/18 18:31
 * @Describe:
 */
public class CollectionsTest {

    public static void main(String[] args) {
        test06();
    }

    // ConcurrentHashMap
    private void test07() {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("k", "v");
        System.out.println("map = " + map);
    }

    /*
    (n-1)&hash = hash%n -->n是2的次幂
    在计算机中 & 的效率比 % 高很多
    */
    private static void test06() {
        String k = "k";
        String v = "v";
        HashMap<String, String> map = new HashMap<>(8);
        for (int i = 1; i < 5000000; i++) {
            map.put("k"+i, "v"+i);
        }
        System.out.println("map = " + map);
    }
    /**
     * next = e.next
     * e.next = newTable[i]
     * newTable[i] = e;
     * e = next;
     *
     * //第一次循环,(伪代码)
     *     e=A;next=B;
     *     e.next=null //此时线程一的新数组刚初始化完成，还没有元素
     *     newTab[i] = A->null //把A节点头插到新数组中
     *     e=B; //下次循环的e值
     *
     * //第二次循环
     * e=B;next=A;  //此时A，B的内容已经被线程二修改为 B->A->null，然后被线程一读到，所以B的下一个节点指向A
     * e.next=A->null  // A->null 为第一次循环后线程一新数组的结构
     * newTab[i] = B->A->null //新节点B插入之后，线程一新数组的结构
     * e=A;  //下次循环的 e 值
     *
     * //第三次循环
     * e=A;next=null;  // A节点后边已经没有节点了
     * e.next= B->A->null  // B->A->null 为第二次循环后线程一新数组的结构
     * //我们把A插入后，抽象的表达为 A->B->A->null，但是，A只能是一个，不能分身啊
     * //因此实际上是 e(A).next指向发生了变化，A的 next 由指向 null 改为指向了 B，
     * //而 B 本身又指向A，因此A和B互相指向，成环
     * newTab[i] = A->B 且 B->A
     * e=next=null; //e此时为空，结束循环
     *
     * get()最终调用getEntry() e!=null e=e.next 死循环
     */



    private static void test05() {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(0);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(3);
        hashSet.add(null);
        System.out.println("hashSet = " + hashSet);

        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void test04() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 3) list.remove(i);
        }
        System.out.println("list = " + list);

        list.addFirst(0);
        System.out.println("list = " + list);
        list.removeLast();
        System.out.println("list = " + list);
    }

    private static void test03() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(111);
        list.add(12);
        list.add(13);
        list.add(10);
        list.add(1);
        Collections.sort(list);
        System.out.println("list = " + list);
    }

    private static void test02() {
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        map.put("", "");

        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("", "");

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println("list = " + list);
    }

    // 遍历Map
    private static void test01() {
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");

        // 1.
        for (String key : map.keySet()) {
            System.out.println(key + " : "+map.get(key));
        }

        // 2.容量大时
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : "+entry.getValue());
        }

        // 3.
        for (String value : map.values()) {
            System.out.println(value);
        }

    }
}
