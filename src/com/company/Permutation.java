package com.company;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    private int max;
    private int[] array;
    private int[] hold;
    private static List<String> list = new ArrayList<>();

    public Permutation(int max) {
        this.max = max;
        array = new int[max + 1];
        hold = new int[max + 1];
    }

    public void permute(int step) {
        if(step == max + 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 1; i <= max; i++) {
                stringBuilder.append(array[i]);
            }
            String item = stringBuilder.toString();
            list.add(item);
            return;  //返回上一步, 即最近一次调用permute方法的后一行
        }
        //按照1->2->3->...->n的顺序尝试
        for(int num = 1; num <= max; num++) {
            //判断是否还持有该数字
            if(hold[num] == 0) {
                array[step] = num;
                hold[num] = 1;
                //递归: 右移一格重复遍历数字的尝试
                permute(step + 1);
                //回到当前位置时取回当前位置数字
                hold[num] = 0;
            }
        }
    }
    public List<String> get(int n) {
        Permutation fa = new Permutation(n);
        fa.permute(1);
        return list;
    }
}
