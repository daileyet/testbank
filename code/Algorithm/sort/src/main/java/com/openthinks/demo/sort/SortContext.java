/**
 * 
 */
package com.openthinks.demo.sort;

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

  private static void swap(Integer[] inputArray, int i, int j) {
    int temp = inputArray[j];
    inputArray[j] = inputArray[i];
    inputArray[i] = temp;
  }
}