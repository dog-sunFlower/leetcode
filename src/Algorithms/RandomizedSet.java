package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by zhangrunlin on 16/8/6.
 */
public class RandomizedSet {
    HashMap<Integer,Integer> map;
    List<Integer> list;
    int listEnd;

    RandomizedSet() {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
        listEnd = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    Boolean insert(int val) {
        //首先判断是否集合中包含该元素
        if(map.containsKey(val))    return false;
        map.put(val,listEnd);
        if(listEnd == list.size()){
            list.add(val);
        }else {
            list.set(listEnd,val);
        }
        listEnd++;
        System.out.println(list.toString());
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    Boolean remove(int val) {
        if(map.isEmpty() || !map.containsKey(val))    return false;
        int index = map.get(val);
        int lastVal = list.get(--listEnd);
        list.set(index,lastVal);
        map.put(lastVal,index);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    int getRandom() {
        Random engine = new Random();
        int index = engine.nextInt(listEnd);
        return list.get(index);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(6);
        randomizedSet.insert(5);
        randomizedSet.insert(4);
        randomizedSet.remove(6);
        randomizedSet.insert(3);
        randomizedSet.insert(2);
        randomizedSet.insert(1);
        System.out.println(randomizedSet.getRandom());
    }
}
