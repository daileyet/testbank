# 计数排序

该排序算法要求输入数据必须有确定范围的整数.

## 算法描述

1. 找出待排序的数组A中最大和最小的元素
2. 统计数组A中每个值为i的元素出现的次数,存入数组C的第i项
3. 从数组C填充目标数组A,从计数不为0的数组C的元素,每填充一次,对应计数减一,直至所有数组C的元素值计数为0

## 演示

![](../../img/sort_counting.gif)

## 算法复杂度

|项|值|
|---|---|
|时间复杂度|O(n+k)|
|空间复杂度|O(n+k) |
|稳定性|稳定|

## 代码实现

```java
public final static Integer[] countingSort(Integer[] inputArray,Integer maxValue) {
    if(maxValue==null) {// calculate max value
      maxValue = Collections.max(Arrays.asList(inputArray));
    }
    final int LEN_COUNTING = maxValue + 1;
    final Integer[] countingArray = new Integer[LEN_COUNTING];
    // counting
    for(int i=0,j=inputArray.length;i<j;i++) {
      int countingIndex = inputArray[i];
      if(countingArray[countingIndex]==null) {
        countingArray[countingIndex]=1;
      }else {
        countingArray[countingIndex]=countingArray[countingIndex]+1;
      }
    }
    // fill target array
    int index = 0;
    for(int i=0;i<LEN_COUNTING;i++) {
      while(countingArray[i]!=null && countingArray[i]!=0) {
        inputArray[index]=i;
        countingArray[i]=countingArray[i]-1;
        index++;
      }
    }
    return inputArray;
  }
```

[CountingSortDemo](../../../code/Algorithm/sort/src/main/java/com/openthinks/demo/sort/CountingSortDemo.java)