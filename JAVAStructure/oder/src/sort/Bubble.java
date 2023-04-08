package sort;

import java.util.Comparator;

/**
 * @description://冒泡排序
 * @author: Luck_chen
 * @date: 2023/4/6 18:46
 * @Version 1.0.0.0
 *
 *
 */
public class Bubble {
//    对数组元素排序
    public static void sort(Comparable [] arr){
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (greater(arr[j-1],arr[j])){
                    exchange(j-1, j, arr);
                }
            }
        }

    }
//    比较大小
    private static boolean greater(Comparable a,Comparable b){
        return a.compareTo(b) > 0;
    }
//    交换两个元素
    private static void exchange(int i, int j, Comparable[] arr){
        Comparable temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
