package org.example;

import java.util.Arrays;

public class ArrayAgain {
    public static void main(String[] args) {

        int[] xArr = {10, 20, 30};
        int[] yArr = xArr;
        int[] zArr = Arrays.copyOf(xArr,xArr.length);

        System.out.println(Arrays.toString(xArr));
        System.out.println(Arrays.toString(yArr));
        System.out.println(Arrays.toString(zArr));

        yArr[1] += 3;
        xArr[1] += 1;


 //  ************ xArr and yArr pointers to same place of list  ***************
        // zArr pointer to different place list and take copy of xArr

        System.out.println(Arrays.toString(xArr));
        System.out.println(Arrays.toString(yArr));
        System.out.println(Arrays.toString(zArr));
    }
}
