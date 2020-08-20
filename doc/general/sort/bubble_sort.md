# 冒泡排序

一种简单的排序算法.

## 算法描述

1. 比较相邻的元素; 如果第一个比第二个大,则交换
2. 对每一对相邻元素作同样的工作,从开始第一对到结尾的最后一对,这样在最后的元素应该会是最大的数
3. 针对所有的元素重复以上的步骤,除了最后一个
4. 重复步骤1~3,直到排序完成

## 演示

![](../../img/sort_bubble.gif)

## 代码实现

```java
  /**
   * Bubble sort
   * 
   * @param inputArray un-sort integer array
   * @return sorted array
   */
  public final static Integer[] bubbleSort(final Integer[] inputArray) {
    final int LEN = inputArray.length;
    for (int i = 0; i < LEN - 1; i++) {
      for (int j = 0; j < LEN - 1 - i; j++) {
        if (inputArray[j] > inputArray[j + 1]) {
          swap(inputArray, j, j + 1);
        }
      }
    }
    return inputArray;
  }
```

[BubbleSortDemo](../../../code/Algorithm/sort/src/main/java/com/openthinks/demo/sort/BubbleSortDemo.java)