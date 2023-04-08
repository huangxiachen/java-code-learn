package sort;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/8 20:38
 * @Version 1.0.0.0
 */
public class Insert {

    public static void sort(int arr[]) {
        int temp = 0;
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            boolean flag = false;
            for (int j = i; j > 0; j--) {
                if (temp < arr[j-1]) {
                    arr[j] = arr[j-1];
                    index = j-1;
                    flag = true;
                }
            }
              if (flag){
                  arr[index] = temp;
              }
        }
    }


}
