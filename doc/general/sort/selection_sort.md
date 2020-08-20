# 选择排序

从未排序的数列中找最小的元素,存放到数列的起始位置,然后重复该步骤,直到所有元素均排序完毕.

## 算法描述

1. 初始状态：无序区为R[1..n], 有序区为空
2. 第i趟排序(i=1,2,3…n-1)开始时,当前有序区和无序区分别为R[1..i-1]和R(i..n).该趟排序从当前无序区中-选出关键字最小的记录 R[k],将它与无序区的第1个记录R交换,使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区
3. n-1趟结束,排序结束

## 演示

![](../../img/sort_selection.gif)

## 代码实现

```java
  public final static Integer[] selectionSort(Integer[] inputArray) {
    final int LEN = inputArray.length;
    for (int i = 0; i < LEN - 1; i++) {
      int min_index = i;
      for (int j = i + 1; j < LEN; j++) {
        if (inputArray[j] < inputArray[min_index]) {
          min_index = j;
        }
      }
      if (min_index != i)
        swap(inputArray, min_index, i);
    }
    return inputArray;
  }
  ```

  [SelectionSortDemo](../../../code/Algorithm/sort/src/main/java/com/openthinks/demo/sort/SelectionSortDemo.java)
