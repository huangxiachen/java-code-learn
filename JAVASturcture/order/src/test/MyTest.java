package test;


import sort.Bubble;
import sort.Insert;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/6 19:00
 * @Version 1.0.0.0
 */
public class MyTest {

    public static void main(String[] args) {
//        bubbleTest();
        insertTest();

    }
    public static void bubbleTest(){
        Integer arr [] = new Integer[5];
        Bubble bubble = new Bubble();
        Scanner scanner = new Scanner(System.in);


        while (true){
            System.out.println("input:");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            bubble.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void insertTest(){
        int arr [] = new int[5];
        Insert insert = new Insert();
        Scanner scanner = new Scanner(System.in);


        while (true){
            System.out.println("input:");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            insert.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

}
