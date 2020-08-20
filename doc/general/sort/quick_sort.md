# 快速排序

快速排序使用分治思想来把一个数列分为两个子数列.

## 算法描述

1. 从数列中挑选一个元素,标记为`基准`元素
2. 重新排序数列,所有元素比基准值小的摆放在基准前面,所有元素比基准值大的摆在基准的后面; 该过程称为分区
3. 递归地把小于基准值元素的子数列和大于基准值元素的子数列排序

## 演示

![](../../img/sort_quick.gif)

## 代码实现

```java
  /**
   * Quick sort
   * 
   * @param inputArray un-sort integer array
   * @param leftIndex left start index
   * @param rightIndex right end index
   * @return sorted array
   */
  public final static Integer[] quickSort(final Integer[] inputArray, Integer leftIndex,
      Integer rightIndex) {
    final int LEN = inputArray.length;
    final int lIndex = leftIndex == null ? 0 : leftIndex;
    final int rIndex = rightIndex == null ? LEN - 1 : rightIndex;
    if (lIndex < rIndex) {
      // do partition
      final int partitionIndex = quickSortPartition(inputArray, lIndex, rIndex);
      quickSort(inputArray, lIndex, partitionIndex - 1);
      quickSort(inputArray, partitionIndex + 1, rIndex);
    }
    return inputArray;
  }


  private static int quickSortPartition(Integer[] inputArray, int lIndex, int rIndex) {
    int pivot = lIndex;
    int flag = pivot + 1;
    for (int index = flag; index <= rIndex; index++) {
      if (inputArray[index] < inputArray[pivot]) {
        if (index != flag) {
          swap(inputArray, index, flag);
        }
        flag++;
      }
    }
    if (pivot != (flag - 1))
      swap(inputArray, pivot, flag - 1);
    return flag - 1;
  }
```

[QuickSortDemo](../../../code/Algorithm/sort/src/main/java/com/openthinks/demo/sort/QuickSortDemo.java)