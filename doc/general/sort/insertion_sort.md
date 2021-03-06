  # 插入排序

通过构建有序序列,对于未排序数据,在已排序序列中从后向前扫描,找到相应位置并插入.

## 算法描述

1. 从第一个元素开始,该元素可以认为已经被排序
2. 取出下一个元素,在已经排序的元素序列中从后向前扫描
3. 如果该元素（已排序）大于新元素,将该元素移到下一位置
4. 重复步骤3,直到找到已排序的元素小于或者等于新元素的位置
5. 将新元素插入到该位置后
6. 重复步骤2~5

## 演示

![](../../img/sort_insertion.gif)

## 算法复杂度

|项|值|
|---|---|
|时间复杂度|O(n<sup>2</sup>)|
|空间复杂度|O(1)|
|稳定性|稳定|

## 代码实现

```java
  public final static Integer[] selectionSort(Integer[] inputArray) {
    final int LEN = inputArray.length;
    int preIndex,currVal;
    for(int i=1;i<LEN;i++) {
      preIndex = i-1;
      currVal = inputArray[i];
      while(preIndex>=0 && inputArray[preIndex]>currVal) {
        // move value of preIndex to preIndex+1
        inputArray[preIndex+1] = inputArray[preIndex];
        preIndex--;
      }
      inputArray[preIndex+1]=currVal;
    }
    return inputArray;
  }
```

[InsertionSortDemo](../../../code/Algorithm/sort/src/main/java/com/openthinks/demo/sort/InsertionSortDemo.java)