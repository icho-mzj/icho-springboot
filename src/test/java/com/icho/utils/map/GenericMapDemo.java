package com.icho.utils.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: icho
 * @Date: 2021/10/20 21:53
 * @Describe: 增强map,同时put多个值
 */
public class GenericMapDemo<K,V> {

    public Builder<K, V> bd;

    public GenericMapDemo(Builder<K, V> bd){
        this.bd = bd;
    }

    public V get(K k){
        return bd.map.get(k);
    }

    public Map<K, V> map(){
        return bd.map;
    }

    @Override
    public String toString() {
        return "GenericMap{" +
                "bd=" + bd +
                '}';
    }

    public static class Builder<K, V>{
        Map<K,V> map;

        public Builder(){
            map = new HashMap<K,V>();
        }

        public Builder<K, V> put(K k, V v){
            map.put(k, v);
            return this;
        }

        public GenericMapDemo<K, V> builder(){
            return new GenericMapDemo<K, V>(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "map=" + map +
                    '}';
        }
    }

    public static void main(String[] args){
        GenericMapDemo.Builder<Integer,String> tm = new GenericMapDemo.Builder<Integer,String>();
        tm.put(1,"a").put(2,"b").put(3,"c").builder().map();
        System.out.println("tm = " + tm.map);
    }

}
