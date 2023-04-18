package function.binary;

/**
 * @description:二分查找法
 * @author: Luck_chen
 * @date: 2023/4/10 12:17
 * @Version 1.0.0.0
 */
public class BinarySearch {
  public static int binaryFunction(int arr[],int element){
      int left,right,middle,target;
      left = 0;
      right = arr.length -1;
      middle = 0;
      while (left<=right){
          middle = (left+right)/2;
          target=arr[middle];
          if (element == target)
              return middle;
          if (element > target)
              left = middle +1;
          if (element < target)
              right = middle -1;
      }
      return -1;
  }

//  判断结果
    public static  void  result(int arr[],int element){
      if (binaryFunction(arr,element) == -1){
          System.out.println("没找到");
      }else {
          System.out.println(binaryFunction(arr, element)+"找到了");
      }
    }

}
