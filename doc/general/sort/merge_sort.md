# 归并排序

将已有序的子序列合并,得到完全有序的序列;即先使每个子序列有序,再使子序列段间有序.若将两个有序表合并成一个有序表,称为2-路归并.该算法是采用分治法的一个非常典型的应用.

## 算法描述

1. 把长度为n的输入序列分成两个长度为n/2的子序列
2. 对这两个子序列分别采用归并排序
3. 将两个排序好的子序列合并成一个最终的排序序列

## 演示

![](../../img/sort_merge.gif)

## 算法复杂度

|项|值|
|---|---|
|时间复杂度|O(n*log<sub>2</sub>n)|
|空间复杂度|O(n) |
|稳定性|稳定|

## 代码实现

```java
public final static Integer[] mergeSort(Integer[] inputArray) {
    final int LEN = inputArray.length;
    if (LEN < 2)
      return inputArray;
    int middle = (int) Math.floor(LEN / 2);
    Integer[] leftArray = Arrays.copyOfRange(inputArray, 0, middle);
    Integer[] rightArray = Arrays.copyOfRange(inputArray, middle, LEN);
    return merge(mergeSort(leftArray), mergeSort(rightArray));
  }

  private final static Integer[] merge(Integer[] leftArray, Integer[] rightArray) {
    final int LEN_L = leftArray.length, LEN_R = rightArray.length;
    final Integer[] mergedArray = new Integer[LEN_L+LEN_R];
    int i,j,k;
    for(i=0,j=0,k=0;i<LEN_L&&j<LEN_R;k++) {
      if(leftArray[i]<=rightArray[j]) {
        mergedArray[k]=leftArray[i];
        i++;
      }else {
        mergedArray[k]=rightArray[j];
        j++;
      }
    }
    while(i<LEN_L) {
      mergedArray[k]=leftArray[i];
      i++;k++;
    }
    while(j<LEN_R) {
      mergedArray[k]=rightArray[j];
      j++;k++;
    }
    return mergedArray;
  }
```

[MergeSortDemo](../../../code/Algorithm/sort/src/main/java/com/openthinks/demo/sort/MergeSortDemo.java)