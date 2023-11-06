package com.springboard.test1;

public class AllCombinations {
    public static void main(String[] args) {
        int[] items = {0, 1, 2};
        int cnt = 0;
        for (int item1 : items) {
            for (int item2 : items) {
                for (int item3 : items) {
                    for (int item4 : items) {
                        System.out.println("[" + (++cnt)  + "] 항목1: " + item1 + ", 항목2: " + item2 + ", 항목3: " + item3 + ", 항목4: " + item4);
                    }
                }
            }
        }
    }
}