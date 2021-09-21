
/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

样例
输入：[1,2,3,2,2,2,5,4,2]
返回值：2

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int source[]=new int[]{1,2,3,2,2,2,5,4,2};//该数组模拟输入
        HashMap<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < source.length; i++) {
            int temp=source[i];
            if(maps.containsKey(temp)){
                Integer integer = maps.get(temp);
                maps.put(temp,++integer);
            }else {
                maps.put(temp,1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = maps.entrySet();
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(entries);

        int key=0,value=0;
        for (Map.Entry<Integer, Integer> entry : list) {
            if(value<entry.getValue()){
                key=entry.getKey();
                value=entry.getValue();
            }
        }

        if(value>source.length/2) System.out.println(key);
        else System.out.println("no result");
    }
}
