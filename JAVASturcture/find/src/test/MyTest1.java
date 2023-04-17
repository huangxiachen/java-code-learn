package test;
import function.binary.BinarySearch;

import java.util.Scanner;

/**
 * @description://TODO
 * @author: Luck_chen]
 * @date: 2023/4/10 12:17
 * @Version 1.0.0.0
 */
public class MyTest1 {
    public static void main(String[] args) {
//        二分查找法
        binaryTest();


    }

    //    二分查找法
    public static void binaryTest() {
        int[] testArr = {1, 13, 18, 29, 99, 98, 110, 112,119};
        BinarySearch binarySearch = new BinarySearch();
        Scanner scanner = new Scanner(System.in);
        System.out.println("input：");

        while (true) {
            int element = scanner.nextInt();
            binarySearch.result(testArr, element);
        }


    }
}
