/**
 * 
 */
package com.openthinks.demo.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public final class SortContext {

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

  public final static Integer[] insertionSort(Integer[] inputArray) {
    final int LEN = inputArray.length;
    int preIndex, currVal;
    for (int i = 1; i < LEN; i++) {
      preIndex = i - 1;
      currVal = inputArray[i];
      while (preIndex >= 0 && inputArray[preIndex] > currVal) {
        // move value of preIndex to preIndex+1
        inputArray[preIndex + 1] = inputArray[preIndex];
        preIndex--;
      }
      inputArray[preIndex + 1] = currVal;
    }
    return inputArray;
  }

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

  private static void swap(Integer[] inputArray, int i, int j) {
    int temp = inputArray[j];
    inputArray[j] = inputArray[i];
    inputArray[i] = temp;
  }
}
