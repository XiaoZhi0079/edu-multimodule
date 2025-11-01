package com.example;

public class cad {
    public static void main(String[] args) {
        System.out.println(getcode(4));
    }
    public static String getcode(int n){
        String code="";
        for(int i=0;i<n;i++){
            code+=(int)(Math.random()*10);
        }
        return code;

    }

}
