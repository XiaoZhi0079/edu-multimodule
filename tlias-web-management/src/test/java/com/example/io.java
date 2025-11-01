package com.example;
import java.util.Scanner;

public class io {
    public static void main(String[] args) {

        int[] num={1,4,67,423,54,23,5,6,7,8};
        for(int i=0;i< num.length-1;i++) {
            for (int j=0; j < num.length-1-i; j++) {
                int temp = 0;
                if (num[j] < num[j + 1]) {
                    temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
        for(int i=0;i< num.length;i++)
            System.out.println(num[i]);
    }
}
